package com.example.backend;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BackendApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		SpringApplication.run(BackendApplication.class, args);
	}

}
