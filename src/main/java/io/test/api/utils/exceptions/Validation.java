package io.test.api.utils.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.test.api.models.ValidationError;

@Provider
public class Validation implements ExceptionMapper<ConstraintViolationException> {

	public Response toResponse(ConstraintViolationException e) {

        List<ValidationError> errors = new ArrayList<>();
        /*exception.getConstraintViolations().stream()
                .map(a -> this.toValidationError(a))
                .collect(Collectors.toList());*/

        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        //List<String> messages = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            errors.add(this.toValidationError(violation));

        }
        
        return Response.status(Response.Status.PRECONDITION_FAILED).entity(errors)
                       .type(MediaType.APPLICATION_JSON).build();
    }

    private ValidationError toValidationError(ConstraintViolation<?> constraintViolation) {
        ValidationError error = new ValidationError();
        error.setPath(constraintViolation.getPropertyPath().toString());
        error.setMessage(constraintViolation.getMessage());
        return error;
    }

}

