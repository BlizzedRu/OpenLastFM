package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.models.ModelParser;
import ru.blizzed.openlastfm.params.Param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * This class represents method that may be converted to {@link ApiRequest} for call the LastFM API
 * with set of {@link ApiParams}
 * <p>
 * May contain description for each method param.
 * Contains self and section names
 * Contains {@link ModelParser} to parse a model of response
 * <p>
 * ApiMethod instance can be got only with using of {@link Builder}
 * <p>
 *
 * @param <ResultType> type of expected response model
 * @author BlizzedRu (Ivan Vlasov)
 * @see Builder
 */
public final class ApiMethod<ResultType> {

    /**
     * An exception that can be thrown if you have not pass required params for chosen method
     */
    public static class NoRequiredParamsException extends IllegalArgumentException {
        public NoRequiredParamsException(String message) {
            super(message);
        }
    }

    private String alias;
    private String sectionAlias;
    private List<ApiParamDescription> paramsDescriptions;
    private ModelParser<ResultType> modelParser;

    /**
     * @param sectionAlias section name (e.g. <i>author</i>, <i>track</i>, etc)
     * @param alias self method name (e.g. <i>getInfo</i>, <i>getTracks</i>)
     */
    private ApiMethod(String sectionAlias, String alias) {
        this.alias = alias;
        this.sectionAlias = sectionAlias;
        paramsDescriptions = new ArrayList<>();
    }

    /**
     * Returns a self method name (alias)
     *
     * @return method alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Returns amount of all contained {@link ApiParamDescription}
     *
     * @return method params count
     */
    public int getParamsCount() {
        return paramsDescriptions.size();
    }


    /**
     * Returns {@link ApiParamDescription} at concrete position
     *
     * @param index a position of needed {@link ApiParamDescription}
     * @return {@link ApiParamDescription} at specified position
     * @throws IllegalArgumentException if <strong>index</strong> is not in range
     */
    public ApiParamDescription getParamDescriptionAt(int index) {
        if (index >= getParamsCount() | index < 0)
            throw new IllegalArgumentException("Illegal index " + index + ". Expected 0 to " + (getParamsCount() - 1) + ".");
        return paramsDescriptions.get(index);
    }

    /**
     * Returns full alias of the method formatted as LastFM claims <code>(%sectionName.%methodName)</code>
     * <p>e.g. <i>artist.getInfo</i>, <i>album.getTags</i>, etc
     *
     * @return full alias of the method
     */
    public String getFullAlias() {
        return String.format(Locale.US, "%s.%s", getSectionAlias().toLowerCase(), getAlias());
    }

    /**
     * Returns the section name
     * <p>e.g. <i>artist</i>, <i>album</i>, <i>etc</i>
     *
     * @return name of the method section
     */
    public String getSectionAlias() {
        return sectionAlias;
    }

    /**
     * @see #withParams(Param... params)
     * @see ApiParams#from(Param[])
     * @see ApiParams#from(List)
     *
     * @param params {@link ApiParams} that contains all required params at least
     * @return {@link ApiRequest} that may be executed for calling to LastFM
     * @throws NoRequiredParamsException if you have not pass required params for chosen method
     */
    public ApiRequest<ResultType> withParams(ApiParams params) throws NoRequiredParamsException {
        if (!checkForAllRequiredParams(params))
            throw new NoRequiredParamsException(
                    paramsDescriptions.stream().filter(ApiParamDescription::isRequired).count()
                            + " required params expected."
            );
        return new ApiRequest<>(this, params);
    }

    /**
     * Generates a new {@link ApiRequest} with specified set of {@link Param} which can be executed for calling to LastFM
     * <p>
     * There is no need to pass here your <strong>api key</strong>, it will be got from {@link ru.blizzed.openlastfm.OpenLastFMContext} by default
     * <p>
     * By default params contain a <i>"US"</i> {@link ru.blizzed.openlastfm.params.LangParam} if you have
     * initialized {@link ru.blizzed.openlastfm.OpenLastFMContext} without <i>lang</i> param
     * <p>If you have initialized it with your custom <i>lang</i> param it will be used by default
     * <p>
     * You can pass here another {@link ru.blizzed.openlastfm.params.LangParam} if it differs from specified in {@link ru.blizzed.openlastfm.OpenLastFMContext}
     * <p>
     * @param params a single {@link Param} or array of {@link Param} that contains all required params at least
     * @return {@link ApiRequest} that may be executed for calling to LastFM
     * @throws NoRequiredParamsException if you have not pass required params for chosen method
     */
    public ApiRequest<ResultType> withParams(Param... params) throws NoRequiredParamsException {
        return withParams(ApiParams.from(params));
    }

    /**
     * Returns used {@link ModelParser} for response parsing
     *
     * @return used {@link ModelParser}
     */
    public ModelParser<ResultType> getModelParser() {
        return modelParser;
    }

    private boolean checkForAllRequiredParams(ApiParams params) {
        return paramsDescriptions.stream()
                .filter(ApiParamDescription::isRequired)
                .filter(p -> !params.asList().contains(p.getParam()))
                .filter(p -> !params.asList().containsAll(p.getReplacements()))
                .count() == 0;
    }

    /**
     * Builder class for {@link ApiMethod}
     *
     * @see ApiMethod
     * @param <ResultType> type of expected response model
     */
    public static class Builder<ResultType> {

        private ApiMethod<ResultType> method;

        /**
         * @param sectionAlias section name (e.g. <i>author</i>, <i>track</i>, etc)
         * @param alias self method name (e.g. <i>getInfo</i>, <i>getTracks</i>)
         */
        public Builder(String sectionAlias, String alias) {
            method = new ApiMethod<>(sectionAlias, alias);
        }

        /**
         * Adds a {@link ApiParamDescription} to the method
         *
         * @param paramsDescriptions single or set of {@link ApiParamDescription} to add to the method
         * @return {@link Builder}
         */
        public Builder<ResultType> addParamsDescriptions(ApiParamDescription... paramsDescriptions) {
            method.paramsDescriptions.addAll(Arrays.asList(paramsDescriptions));
            return this;
        }

        /**
         * Set the name of the method section
         * <p>e.g. <i>author</i>, <i>track</i>, etc
         *
         * @param sectionAlias name <i>(alias)</i> of the method section
         * @return {@link Builder}
         */
        public Builder<ResultType> setSectionAlias(String sectionAlias) {
            method.sectionAlias = sectionAlias;
            return this;
        }

        /**
         * Set the name of the method itself
         * <p>e.g. <i>getInfo</i>, <i>getTracks</i>, etc
         *
         * @param alias name <i>(alias)</i> of the method itself
         * @return {@link Builder}
         */
        public Builder<ResultType> setAlias(String alias) {
            method.alias = alias;
            return this;
        }

        /**
         * Builds a new ApiMethod with specified <tt>section name</tt> {@link #setSectionAlias(String)}, <tt>self name</tt> {@link #setAlias(String)}
         * and {@link ModelParser}
         *
         * @param resultModelParser A {@link ModelParser} used for parse a response model
         * @return full built {@link ApiMethod}
         */
        public ApiMethod<ResultType> buildWithResultModelParser(ModelParser<ResultType> resultModelParser) {
            method.modelParser = resultModelParser;
            return method;
        }
    }

}
