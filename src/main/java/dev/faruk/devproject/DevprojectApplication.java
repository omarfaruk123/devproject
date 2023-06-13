package dev.faruk.devproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.faruk.devproject")
public class DevprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevprojectApplication.class, args);
	}

}
