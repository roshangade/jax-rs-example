/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 15/7/18
 */
package com.test.api.framework;

import com.test.api.framework.utils.Messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Response {

    public Optional<HashMap> parse(Object res) {
        try {

            // parse response body into JSON
            HashMap json = (HashMap) res;

            // parse message
            String message = (String) json.get("message");
            if (message != null) {
                json.replace("message", parseMessage(message));
            }

            // parse error object
            HashMap errors = (HashMap) json.get("errors");
            if (errors != null) {
                json.replace("errors", parseErrors(errors));
            }

            return Optional.of(json);

        } catch (Exception e) {
            // TODO: log error
            e.printStackTrace();
            System.out.println("Response Parse Error: " + e.getMessage());
        }
        return Optional.empty();
    }

    private static String parseMessage(String msg) {
        return Messages.get(msg);
    }

    private static HashMap parseErrors(HashMap<String, ArrayList<String>> errors) {
        errors.forEach((key,value) -> {
            ArrayList<String> errs = new ArrayList<>();
            value.forEach(val -> errs.add(parseMessage(val)));
            errors.replace(key, errs);
        });

        return errors;
    }
}
