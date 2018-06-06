package io.test.api.middlewares;

import java.util.Date;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@PreMatching
@Provider
@Priority(1)
public class Runtime implements ContainerRequestFilter {
	
	public void filter(ContainerRequestContext req) {
		// start time
		req.setProperty("runtime", (new Date()).getTime());
	}
}
