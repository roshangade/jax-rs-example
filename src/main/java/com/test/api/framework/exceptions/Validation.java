/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 7/8/18
 */
package com.test.api.framework.exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.*;

@Provider
public class Validation implements ExceptionMapper<ConstraintViolationException> {

    public Response toResponse(ConstraintViolationException e) {
        Map<String, List<String>> errors = new LinkedHashMap<>();

        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            this.toValidationError(errors, violation);
        }

        return ErrorResponse.build(ErrorResponse.Keys.INVALID_BODY, errors);

    }

    private Map<String, List<String>> toValidationError(Map<String, List<String>> errors, ConstraintViolation<?> constraintViolation) {
        String key = constraintViolation.getPropertyPath().toString();
        key = key.replaceAll("^(\\w*).arg(\\d).(\\w*).", "").replaceAll("([A-Z])", "_$1").toLowerCase();
        errors.put(key, new ArrayList<String>() {{
            add(constraintViolation.getMessage());
        }});
        return errors;
    }

}

