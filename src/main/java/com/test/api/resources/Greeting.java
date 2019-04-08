/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 12-Jul-2018
 */
package com.test.api.resources;

import com.test.api.framework.Async;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Singleton
@Path("greeting")
@Produces(MediaType.APPLICATION_JSON)
public class Greeting {

    @Inject
    private Async async;

    @GET
    public void getMessage(@Suspended final AsyncResponse response) {
        HashMap<String, Object> json = new HashMap<>();
        json.put("message", "greeting");

        async.execute(response, () -> {
            response.resume(Response.status(Response.Status.OK).entity(json).build());
        });
    }

}
