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
		basePackages = "com.anand.db2.repo",
		entityManagerFactoryRef = "H2EntityManagerFactoryBean"
		,transactionManagerRef = "h2TransactionManager")
public class H2JPAConfig {

	
	
	//create EntityManger
	@Bean
	public LocalContainerEntityManagerFactoryBean 
	H2EntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("h2DataSource")DataSource datasource) {
		System.out.println("Entity Manger");
		return entityManagerFactoryBuilder.dataSource(datasource)
				.packages("com.anand.db2.entity")
				.build();
	
	}
	
	//transtion Manger
	@Bean
	public PlatformTransactionManager h2TransactionManager(
			@Qualifier("H2EntityManagerFactoryBean")LocalContainerEntityManagerFactoryBean emf) {
		return new JpaTransactionManager(emf.getObject());
	}
	
	
}
