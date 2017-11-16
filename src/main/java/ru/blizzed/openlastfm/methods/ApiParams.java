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

package ru.blizzed.openlastfm.methods;

import ru.blizzed.openlastfm.params.Param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class-container for set of {@link Param}
 * <p>
 * Instance can be got only from static method {@link #from(List)} or {@link #from(Param...)}
 *
 * @author BlizzedRu
 */
public final class ApiParams {

    private List<Param> params;

    private ApiParams() {
    }

    public static ApiParams from(Param... params) {
        return from(Arrays.asList(params));
    }

    public static ApiParams from(List<Param> paramList) {
        ApiParams apiParams = new ApiParams();
        apiParams.params = new ArrayList<>(paramList);
        return apiParams;
    }

    public List<Param> asList() {
        return params;
    }

    public boolean isEmpty() {
        return params.isEmpty();
    }

}
