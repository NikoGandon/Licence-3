package com.example.TD3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Td3Application {

	public static void main(String[] args) {
		SpringApplication.run(Td3Application.class, args);
	}

}
