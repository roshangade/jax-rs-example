/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 20/7/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotAuthorized implements ExceptionMapper<NotAuthorizedException> {

    public Response toResponse(NotAuthorizedException e) {
        return ErrorResponse.build(ErrorResponse.Keys.UNAUTHORIZED);
    }

}
