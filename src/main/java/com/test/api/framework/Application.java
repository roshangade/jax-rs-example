/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 14/7/18
 */
package com.test.api.framework;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;

public class Application extends ResourceConfig {

    public Application() {
        System.out.println("REST Application.");

        packages("com.test.api.framework.middlewares");
        packages("com.test.api.framework.exceptions");
        packages("com.test.api.framework.utils");
        packages("com.test.api.framework.dj");

        register(new AbstractBinder() {

            @Override
            protected void configure() {
                bind(Async.class).to(Async.class).in(Singleton.class);
                bind(Response.class).to(Response.class).in(Singleton.class);
            }
        });
    }

}
