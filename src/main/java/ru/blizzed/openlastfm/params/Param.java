/*
 * Copyright (c) 2017 BlizzedRu (Ivan Vlasov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
