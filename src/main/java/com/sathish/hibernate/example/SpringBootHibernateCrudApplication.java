package com.sathish.hibernate.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


/**
 * 
 * @author Sathish
 *
 */
/*
 * By default Spring Boot will automatically configures JPA, and creates Spring
 * BEANs related to the JPA. These automatic configurations of the Spring Boot
 * include: DataSourceAutoConfiguration
 * DataSourceTransactionManagerAutoConfiguration HibernateJpaAutoConfiguration
 * The purpose of this application is to use Hibernate, therefore, we need to
 * disable the above automatic configurations of the Spring Boot.
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })

public class SpringBootHibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateCrudApplication.class, args);
	}
}
