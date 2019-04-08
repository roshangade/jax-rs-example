/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 4/8/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotAllowed implements ExceptionMapper<NotAllowedException> {

    public Response toResponse(NotAllowedException e) {
        return ErrorResponse.build(ErrorResponse.Keys.NOT_ALLOWED);
    }
}
