package ru.blizzed.openlastfm.params;

import java.util.Objects;

public class Param<DataType> {

    protected String name;
    protected DataType data;

    public Param(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public Param<DataType> of(DataType data) {
        Param<DataType> param = new Param<>(name);
        param.data = data;
        return param;
    }

    public DataType getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Param param = (Param) o;
        return Objects.equals(name, param.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
