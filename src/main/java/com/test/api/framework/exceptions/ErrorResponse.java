/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 20/7/18
 */
package com.test.api.framework.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ErrorResponse {

    protected static Response build(Keys key) {

        Map<String, Object> json = new LinkedHashMap<>();
        json.put("message", key.getMessage());
        json.put("code", key.getCode());

        return send(key, json);
    }

    protected static Response build(Keys key, Map<String, List<String>> errors) {

        Map<String, Object> json = new LinkedHashMap<>();
        json.put("message", key.getMessage());
        json.put("code", key.getCode());
        json.put("errors", errors);

        return send(key, json);
    }

    private static Response send(Keys key, Map json) {
        return Response.status(key.getStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(json)
                .build();
    }

    protected enum Keys {

        INTERNAL_SERVER_ERROR(100, Status.SERVICE_UNAVAILABLE, "error.internal-server-error"),
        UNAUTHORIZED(101, Status.UNAUTHORIZED, "error.not-authorized"),
        SERVICE_UNAVAILABLE(103, Status.SERVICE_UNAVAILABLE, "error.service-unavailable"),
        NOT_FOUND(104, Status.NOT_FOUND, "error.not-found"),
        NOT_ALLOWED(105, Status.METHOD_NOT_ALLOWED, "error.method-not-allowed"),
        NO_SUCH_ELEMENT(106, Status.BAD_REQUEST, "error.bad-request"),
        INVALID_BODY(107, _Status.UNPROCESSABLE_ENTITY, "error.validation"),
        ;

        private int code;
        private StatusType status;
        private String message;

        Keys(int code, StatusType status, String message) {
            this.code = code;
            this.status = status;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public StatusType getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }

    // custom status
    protected enum _Status implements StatusType {

        UNPROCESSABLE_ENTITY(422, "Unprocessable Entity");

        private final int statusCode;
        private final String reasonPhrase;
        private final Status.Family family;

        _Status(int statusCode, String reasonPhrase) {
            this.statusCode = statusCode;
            this.reasonPhrase = reasonPhrase;
            this.family = Status.Family.familyOf(statusCode);
        }

        @Override
        public int getStatusCode() {
            return statusCode;
        }

        @Override
        public String getReasonPhrase() {
            return reasonPhrase;
        }

        @Override
        public Status.Family getFamily() {
            return family;
        }
    }
}