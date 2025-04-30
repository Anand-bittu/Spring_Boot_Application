package com.anand.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.anand.db1.repo",
		entityManagerFactoryRef ="mysqlEntityManagerFactoryBean"
		,transactionManagerRef ="mysqlTransactionManager" )
public class MYSQLJPAConfig {

	//create EntityManger Object
	
	@Bean
	public LocalContainerEntityManagerFactoryBean 
	mysqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("mysqlDataSource")DataSource datasource) {
		
		return entityManagerFactoryBuilder
				.dataSource(datasource)
				.packages("com.anand.db1.entity")
				.build();
	}
	
	//transation Manger
	@Bean
	public PlatformTransactionManager
	mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emf) {
		return new JpaTransactionManager(emf.getObject());
	}
	
	
}
