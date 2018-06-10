package io.test.api;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import io.test.api.models.TweetsDAO;
import io.test.api.utils.Database;

public class Main extends ResourceConfig {

	public Main() {
		//packages("io.test.api.utils");
		//packages("io.test.api.utils.exceptions");
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(Database.class).to(Database.class).in(Singleton.class);
				bind(TweetsDAO.class).to(TweetsDAO.class).in(Singleton.class);
			}
		});
	}
}
