/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.John.myapplication.backend;

import com.example.JavaJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.John.example.com",
    ownerName = "backend.myapplication.John.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that displays a joke */
    @ApiMethod(name = "getJokeEndpoint")
    public MyBean getJokeEndpoint() {
        JavaJoke javaJoke = new JavaJoke();
        MyBean response = new MyBean();
        response.setData(javaJoke.getJoke());

        return response;
    }

}
