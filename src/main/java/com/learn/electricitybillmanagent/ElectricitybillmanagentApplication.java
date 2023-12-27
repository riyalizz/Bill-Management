package com.learn.electricitybillmanagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ElectricitybillmanagentApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ElectricitybillmanagentApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8083"));
		app.run(args);
		//SpringApplication.run(ElectricitybillmanagentApplication.class, args);
	}
}
