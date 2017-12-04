# OpenLastFM
Simple Java library for non-auth methods of [Last.fm API][documentation].

**OpenLastFM** provides all available [Last.fm API][documentation] methods that don't require user authorization.
Can be useful for grabbing some data from the service. E.g. artist info, album alias correction, popular tracks around and etc.

* Contains Java object wrappers for any API response
* Supports paginated result response (search or lists with many objects)
* Convenient request builders
* Can check methods for required parameters before calling
* Supports consistent queries

Full list of methods is available in [Last.fm API Documentation][documentation]

## Installing

#### Maven

In your pom.xml inside the *\<dependencies>* tag
```xml
<dependencies>
    ...
    <dependency>
        <groupId>ru.blizzed</groupId>
        <artifactId>openlastfm</artifactId>
        <version>1.0.1</version>
    </dependency>
</dependencies>
```

#### Gradle

In your build.gradle file inside the *dependencies* section

* Gradle 3.0 and above
``` 
dependencies {
   ...
   implementation 'ru.blizzed:openlastfm:1.0.1'
}
```
  
* Below 3.0
``` 
dependencies {
    ...
    compile 'ru.blizzed:openlastfm:1.0.1'
}
```
  
## Usage

#### Initialization
First of all you need to initialize library by calling one of available `initialize` methods.

* You don't care about `lang` param *(default is **EN**)*
```java 
OpenLastFMContext.initialize("your-last-fm-api-key");
```
* You need a custom language
```java 
OpenLastFMContext.initialize("your-last-fm-api-key", Locale.YOUR_LOCALE);
```
You can configure each request with `lang` param to support multilanguage

#### Building and executing requests
For example, you need to call a method from the `artist` section, then needed class, that contains all available methods, is `ApiArtist`. 
This class (and others such classes) provides you completed methods with expected result calling type.

```java 
ApiMethod<ArtistInfo> artistInfoMethod = ApiArtist.getInfo();
```

Now you need to pass params into the method and generate a request. In OpenLastFM all requests are `ApiRequest`'s.
You can get it by calling `withParams` method of gotten `ApiMethod` with needed set of params.
All params are instance of `Param` and have expected input data type. Static class `LastFMParams` contains completed instances of all parameters so you should use it.
```java 
ApiRequest<ArtistInfo> request = artistInfoMethod.withParams(LastFMParams.ARTIST.of("Dimmu Borgir"));
```
or the same but with a set of params
```java 
ApiRequest<ArtistInfo> request = artistInfoMethod.withParams(
            LastFMParams.ARTIST.of("Dimmu Borgir"),
            LastFMParams.LANG.of(Locale.GERMAN)
);
```

Yeah! We've got an `ApiRequest` and now we are a step away from the learning of Dimmu Borgir! All we need to do is just execute this request. Let's do this now!
* With callback `ApiRequestListener`
```java
request.execute(new ApiRequest.ApiRequestListener<ArtistInfo>() {
    @Override
    public void onComplete(ApiResponse<ArtistInfo> response) {
        ArtistInfo artistInfo = response.getContent();
        System.out.println(artistInfo.getBio().getContent());
  
    @Override
    public void onApiError(ApiResponse<Error> error) {
        /* This method triggers you when API has been called but response contains an error */
        // Handle Api Error
  
    @Override
    public void onFailure(ApiRequestException exception) {
        /* This method triggers you when call to API cannot be established E.g. no internet connection */
        // Handle Failure
    }
});
```
***Tip:** you can override not all callback methods*

* With exceptions handling 
```java 
try {
    ApiResponse<ArtistInfo> response = request.execute();
    ArtistInfo artist = response.getContent();
    System.out.println(artist.getBio().getContent());
} catch (ApiRequestException | ApiResponseException e) {
    // Handle error
}
```
  
Wow! We learned that Dimmu Borgir is amazing norwegian Symphonic Black Metal band and now we want to get and listen to their tracks from the best album! 
But what if you want to get only 5 tracks now, and others you are going to estimate tomorrow when your roommate will go away and you will got a wonderful opportunity for a powerful headbanging? 
Hmm.. Let's take a look!

#### Paginated responses
Here we are building our initial request as usual and if we need the next page just call `getNextPageRequest` 
```java 
ApiRequest<PageResult<Track>> request = ApiArtist.getTopTracks().withParams(
            LastFMParams.ARTIST.of("Dimmu Borgir"),
            LastFMParams.PERIOD.of(Period.THREE_MONTHS),
            LastFMParams.LIMIT.of(5)    // 5 tracks per page
);
PageResult<Track> trackPage = request.execute().getContent();
trackPage.getItems().forEach(System.out::println);
PageResult<Track> nextPage = trackPage.getNextPageRequest(request).execute().getContent();
```

#### Request cancelling
Something went wrong and your roommate is coming back so you need to cancel request for the next portion of headbanging tracks immediately:
```java 
request.cancel();
```

## Customization

#### Custom param
You can create your own `Param` with certain content type
```java 
Param<SomeType> param = new Param("paramName");
```

#### Custom method
```java 
ApiMethod<SomeType> albumApiMethod = new ApiMethod.Builder<SomeType>("sectionName", "method")
                .addParamsDescriptions(
                        new ApiParamDescription(LastFMParams.ARTIST, true, LastFMParams.MBID),
                        new ApiParamDescription(LastFMParams.MBID, false),
                        new ApiParamDescription(LastFMParams.AUTOCORRECT, false)
                )
                .buildWithResultModelParser(new ModelParser<SomeType>("rootTag") {
                    @Override
                    public SomeType parse(JsonObject root) {
                        return new Gson().parse(root, new SomeType.class);
                    }
                });
```

`ApiParamDescription` is just helper-wrapper class, which second parameter in constructor is flag that shows param is required for API. 
Third parameter is not required, but used for special situations when one of params is required but can be replaced by another. 
See examples in [Last.fm API documentation][documentation]. Params descriptions are not required but desirable.

`ModelParser` is an interface which implementation should parse an expected response object using [Google Gson](https://github.com/google/gson).
You can use completed implementations such as `models.ObjectModelParser`, `models.SkipRootModelParser`, `models.PaginatedResultModelParser`, and etc.


## License

```
Copyright (c) 2017 BlizzedRu (Ivan Vlasov)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


[documentation]: https://www.last.fm/api
