package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.Param;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ApiParamDescription {

    private Param param;
    private boolean required;
    private List<Param> replacements;

    public ApiParamDescription(Param param, boolean required) {
        this.param = param;
        this.required = required;
    }

    public ApiParamDescription(Param param, boolean required, Param... replacements) {
        this.param = param;
        this.required = required;
        this.replacements = Arrays.asList(replacements);
    }

    public Param getParam() {
        return param;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean hasReplacements() {
        return replacements != null;
    }

    public List<Param> getReplacements() {
        if (replacements == null) return Collections.emptyList();
        return replacements;
    }

}
