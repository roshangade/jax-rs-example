/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 4/8/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.NoSuchElementException;

@Provider
public class NoSuchElement implements ExceptionMapper<NoSuchElementException> {

    public Response toResponse(NoSuchElementException e) {
        return ErrorResponse.build(ErrorResponse.Keys.NO_SUCH_ELEMENT);
    }
}
