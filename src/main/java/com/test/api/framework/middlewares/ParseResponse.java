/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 12/7/18
 */
package com.test.api.framework.middlewares;

import com.test.api.framework.Response;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Optional;

@Priority(Priorities.ENTITY_CODER)
@Provider
public class ParseResponse implements ContainerResponseFilter {

    @Inject
    private Response response;

    public void filter(ContainerRequestContext req, ContainerResponseContext res) {

        Optional<HashMap> json = response.parse(res.getEntity());

        if(json.isPresent()) {
            res.setEntity(json);
        }

    }
}
