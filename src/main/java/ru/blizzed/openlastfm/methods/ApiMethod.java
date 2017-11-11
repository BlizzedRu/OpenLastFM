package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.model.ModelBuilder;
import ru.blizzed.openlastfm.model.ObjectModelBuilder;
import ru.blizzed.openlastfm.params.Param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class ApiMethod<ResultType> {

    public static class NoRequiredParamsException extends IllegalArgumentException {
        public NoRequiredParamsException(String message) {
            super(message);
        }
    }

    private String alias;
    private String sectionAlias;
    private List<ApiParamDescription> paramsDescriptions;
    private ModelBuilder<ResultType> modelBuilder;

    public ApiMethod(String sectionAlias, String alias) {
        this.alias = alias;
        this.sectionAlias = sectionAlias;
        paramsDescriptions = new ArrayList<>();
    }

    public String getAlias() {
        return alias;
    }

    public int getParamsCount() {
        return paramsDescriptions.size();
    }

    public ApiParamDescription getParamDescriptionAt(int index) {
        if (index >= getParamsCount() | index < 0)
            throw new IllegalArgumentException("Illegal index " + index + ". Expected 0 to " + (getParamsCount() - 1) + ".");
        return paramsDescriptions.get(index);
    }

    public String getFullAlias() {
        return String.format(Locale.US, "%s.%s", getSectionAlias().toLowerCase(), getAlias());
    }

    public String getSectionAlias() {
        return sectionAlias;
    }

    public ApiRequest<ResultType> withParams(ApiParams params) throws NoRequiredParamsException {
        if (!checkForAllRequiredParams(params))
            throw new NoRequiredParamsException(
                    paramsDescriptions.stream().filter(ApiParamDescription::isRequired).count()
                    + " required params expected."
            );
        return new ApiRequest<>(this, params);
    }

    public ApiRequest<ResultType> withParams(Param... params) throws NoRequiredParamsException {
        return withParams(ApiParams.from(params));
    }

    protected ApiMethod<ResultType> addParamsDescriptions(ApiParamDescription... paramsDescriptions) {
        this.paramsDescriptions.addAll(Arrays.asList(paramsDescriptions));
        return this;
    }

    protected ApiMethod<ResultType> setModelBuilder(ModelBuilder<ResultType> builder) {
        this.modelBuilder = builder;
        return this;
    }

    protected ModelBuilder<ResultType> getModelBuilder() {
        return modelBuilder;
    }

    private boolean checkForAllRequiredParams(ApiParams params) {
        return paramsDescriptions.stream()
                .filter(ApiParamDescription::isRequired)
                .filter(p -> !params.asList().contains(p.getParam()))
                .filter(p -> !params.asList().containsAll(p.getReplacements()))
                .count() == 0;
    }

}
