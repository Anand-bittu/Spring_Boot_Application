package com.anand.cfg;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DB1Config {
    
	@ConfigurationProperties("spring.db1.datasource")
	@Bean
	public DataSourceProperties mysqlDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean
	public DataSource mysqlDataSource() {
		/*
		 * DriverManagerDataSource datasource=new DriverManagerDataSource();
		 * datasource.setUrl(mysqlDataSourceProperties().getUrl());
		 * datasource.setUsername(mysqlDataSourceProperties().getUsername());
		 * datasource.setPassword(mysqlDataSourceProperties().getPassword()); return
		 * datasource;
		 * 
		 */
		return mysqlDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
}
