package com.jcortes.sbtutos.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

	@Bean(name = "dataSource")
	@Profile("dev")
	public DataSource dev() {
		return new DataSource("dev:192.168.1.45", 49175);
	}

	@Bean(name = "dataSource")
	@Profile("prod")
	public DataSource prod() {
		return new DataSource("prod:192.168.1.45", 49176);
	}

	// When there is not an active profile this bean is created and injected where
	// required.
	@Bean(name = "dataSource")
	public DataSource defaultDS() {
		return new DataSource("dafault:192.168.1.45", 4000);
	}
}
