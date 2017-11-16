package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.Param;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Class represents a description for single {@link Param}
 * <p>It is used for describe a {@link Param}:
 * is it required and if yes – which {@link Param} <tt>(or params)</tt> can replace it
 * <p>
 * E.g. there are two required params <i>artist</i> and <i>album</i> in method <tt>album.getInfo</tt>,
 * but it can be replaced by param <i>mbid</i>
 * <p>In this case each of two required params has replacement – param <i>mbid</i>
 *
 * @author BlizzedRu
 */
public final class ApiParamDescription {

    private Param param;
    private boolean isRequired;
    private List<Param> replacements;

    public ApiParamDescription(Param param, boolean isRequired) {
        this.param = param;
        this.isRequired = isRequired;
    }

    public ApiParamDescription(Param param, boolean isRequired, Param... replacements) {
        this.param = param;
        this.isRequired = isRequired;
        this.replacements = Arrays.asList(replacements);
    }

    public Param getParam() {
        return param;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public boolean hasReplacements() {
        return replacements != null;
    }

    /**
     * Returns a {@link List} of replacements
     *
     * @return {@link List} of replacements or empty list if absent
     */
    public List<Param> getReplacements() {
        if (replacements == null) return Collections.emptyList();
        return replacements;
    }

}
