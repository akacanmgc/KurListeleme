package com.kurdurum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages={"com.kurdurum"})
public class DolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DolarApplication.class, args);
	}

}
