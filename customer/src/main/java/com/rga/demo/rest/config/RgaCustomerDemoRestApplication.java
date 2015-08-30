package com.rga.demo.rest.config;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

public class RgaCustomerDemoRestApplication extends ResourceConfig {

	public RgaCustomerDemoRestApplication() {
		packages("org.codingpedia.demo.rest");
		register(EntityFilteringFeature.class);
		EncodingFilter.enableFor(this, GZipEncoder.class);
	}

}
