package com.anand.cfg;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DB2Config {
    
	@ConfigurationProperties("spring.db2.datasource")
	@Bean
	public DataSourceProperties h2DataSourceProperties() {
		System.out.println("dap");
		return new DataSourceProperties();
	}
	
	//create datasourceObject
	@Primary
	@Bean
	public DataSource h2DataSource() {
		System.out.println("ds");
	  return h2DataSourceProperties().initializeDataSourceBuilder().build();
	}
	
}
