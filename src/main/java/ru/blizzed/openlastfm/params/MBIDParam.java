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

public class MBIDParam extends Param<String> {

    private static final String MBID_PATTERN = "^[0-9a-f]{8}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{12}$";

    public MBIDParam(String name) {
        super(name);
    }

    @Override
    public Param<String> of(String data) {
        if (data != null && data.matches(MBID_PATTERN)) return super.of(data);
        else throw new IllegalArgumentException("Param doesn't match MBID pattern.");
    }

}
