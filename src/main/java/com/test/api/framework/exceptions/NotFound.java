/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 14/7/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFound implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException e) {
        return ErrorResponse.build(ErrorResponse.Keys.NOT_FOUND);
    }
}
