package com.bogdanov.devhands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDevhandsApplication {

//	@Bean
//	@ServiceConnection
//	PostgreSQLContainer<?> postgresContainer() {
//		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
//	}

	public static void main(String[] args) {
		SpringApplication.from(DevhandsApplication::main).with(TestDevhandsApplication.class).run(args);
	}

}
