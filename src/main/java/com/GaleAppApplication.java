package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.domain", "com.iba.domain"})
@EntityScan(basePackages = {"com.domain", "com.iba.domain"})
public class GaleAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(GaleAppApplication.class, args);
	}
}
