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

package ru.blizzed.openlastfm.errors;

public final class LastFMErrors {

    private LastFMErrors() {
    }

    public static final LastFMError INVALID_SERVICE = new LastFMError(2, "This service does not exist");
    public static final LastFMError INVALID_METHOD = new LastFMError(3, "No method with that name in this package");
    public static final LastFMError AUTH_FAILED = new LastFMError(4, "You do not have permissions to access the service");
    public static final LastFMError INVALID_FORMAT = new LastFMError(5, "This service doesn't exist in that format");
    public static final LastFMError INVALID_PARAMS = new LastFMError(6, "Your request is missing a required parameter");
    public static final LastFMError INVALID_RESOURCE = new LastFMError(7, "");
    public static final LastFMError OPERATION_FAILED = new LastFMError(8, "Something else went wrong");
    public static final LastFMError INVALID_SESSION_KEY = new LastFMError(9, "Please re-authenticate");
    public static final LastFMError INVALID_API_KEY = new LastFMError(10, "You must be granted a valid key by last.fm");
    public static final LastFMError SERVICE_OFFLINE = new LastFMError(11, "This service is temporarily offline. Try again later.");
    public static final LastFMError SUBSCRIBERS_ONLY = new LastFMError(12, "This station is only available to paid last.fm subscribers");
    public static final LastFMError INVALID_METHOD_SIGNATURE = new LastFMError(13, "Invalid method signature supplied");
    public static final LastFMError UNAUTHORIZED_TOKEN = new LastFMError(14, "This token has not been authorized");
    public static final LastFMError STREAMING_API = new LastFMError(15, "This item is not available for streaming");
    public static final LastFMError TEMPORARILY_ERROR = new LastFMError(16, "There was a temporary error processing your request. Please try again");
    public static final LastFMError LOGIN_REQUIRES = new LastFMError(17, "User requires to be logged in");
    public static final LastFMError TRIAL_EXPIRED = new LastFMError(18, "This user has no free radio plays left. Subscription required");
    public static final LastFMError NOT_ENOUGH_CONTENT = new LastFMError(20, "There is not enough content to play this station");
    public static final LastFMError NOT_ENOUGH_MEMBERS = new LastFMError(20, "This group does not have enough members for radio");
    public static final LastFMError NOT_ENOUGH_FANS = new LastFMError(20, "This artist does not have enough fans for for radio");
    public static final LastFMError NOT_ENOUGH_NEIGHBOURS = new LastFMError(20, "There are not enough neighbours for radio");
    public static final LastFMError NO_PEEK_RADIO = new LastFMError(24, "This user is not allowed to listen to radio during peak usage");
    public static final LastFMError RADIO_NOT_FOUND = new LastFMError(25, "Radio station not found");
    public static final LastFMError SUSPENDED_API_KEY = new LastFMError(26, "Access for your account has been suspended, please contact Last.fm");
    public static final LastFMError DEPRECATED = new LastFMError(27, "This type of request is no longer supported");
    public static final LastFMError RATE_LIMIT = new LastFMError(29, "Your IP has made too many requests in a short period");

}
