package com.multichoice.ngininda.cruddemo.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("com.multichoice.ngininda.cruddemo.assessment.model")
@EnableMongoRepositories(basePackages = {"com.multichoice.ngininda.cruddemo.assessment.repository"})
@ComponentScan({"com.multichoice.ngininda.cruddemo.assessment.controller", "com.multichoice.ngininda.cruddemo.assessment.service"})
public class AssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

}
