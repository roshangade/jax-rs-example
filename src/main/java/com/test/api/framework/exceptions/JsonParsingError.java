/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 9/8/18
 */
package com.test.api.framework.exceptions;

import javax.json.stream.JsonParsingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonParsingError implements ExceptionMapper<JsonParsingException> {

    public Response toResponse(JsonParsingException e) {
        return ErrorResponse.build(ErrorResponse.Keys.NO_SUCH_ELEMENT);
    }

}
