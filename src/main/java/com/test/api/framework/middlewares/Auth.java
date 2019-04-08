/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 12/7/18
 */
package com.test.api.framework.middlewares;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

@Priority(Priorities.AUTHENTICATION)
@Provider
public class Auth implements ContainerRequestFilter {

    private final ArrayList<String> URLS = new ArrayList<>(Arrays.asList("greeting", "login", "register", "forgot-password", "reset-password"));
    private final String REGEX = "\\/$";
    private final Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);

    public void filter(ContainerRequestContext req) {
        // TODO: connect with Redis
        String authtoken = req.getHeaderString("Authtoken");

        // check cookie
        authtoken = (authtoken == null) ? getAuthtokenFromCookie(req) : authtoken;

        // check token validation
        if (authtoken == null) {
            if (requiredAuth(req)) {
                throw new NotAuthorizedException("Bearer");
            }
        } else {
            // TODO: validate authtoken from redis
        }
    }

    private String getAuthtokenFromCookie(ContainerRequestContext req) {
        for (Cookie c : req.getCookies().values()) {
            if (c.getName().equals("Authtoken")) {
                // TODO: decrypt value
                return c.getValue();
            }
        }
        return null;
    }

    private boolean requiredAuth(ContainerRequestContext req) {
        return (URLS.indexOf(pattern.matcher(req.getUriInfo().getPath()).replaceAll("")) == -1);
    }
}
