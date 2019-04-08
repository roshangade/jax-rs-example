/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 14/7/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalServerError implements ExceptionMapper<Throwable> {

    public Response toResponse(Throwable e) {
        // TODO: log error
        e.printStackTrace();
        return ErrorResponse.build(ErrorResponse.Keys.INTERNAL_SERVER_ERROR);
    }
}
