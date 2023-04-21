package com.mybookingshow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class IdentityServiceApplication {

	public static void main(String[] args) {
		/*System.setProperty("mysql.driver-class-name", "com.mysql.cj.jdbc.Driver");
		System.setProperty("mysql.service.username", "root");
		System.setProperty("mysql.service.password", "admin");
		System.setProperty("mysql.service.dialect", "org.hibernate.dialect.MySQL5Dialect");*/
		SpringApplication.run(IdentityServiceApplication.class, args);
		log.info("Identity Service has successfully started");

	}

}
