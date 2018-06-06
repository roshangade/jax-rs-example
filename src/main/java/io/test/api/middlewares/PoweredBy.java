package io.test.api.middlewares;

import java.util.Date;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(100)
public class PoweredBy implements ContainerResponseFilter {
	
	private String poweredBy = "api.test.io";
	
	public void filter(ContainerRequestContext req, ContainerResponseContext res) {
		// set X-Powered-By
		res.getHeaders().add("X-Powered-By", poweredBy);
		
		// set X-Runtime
		res.getHeaders().add("X-Runtime", (new Date()).getTime() - ((Number) req.getProperty("runtime")).longValue());
		
				
	}
}
