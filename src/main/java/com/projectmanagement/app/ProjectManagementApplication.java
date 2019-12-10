package com.projectmanagement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectManagementApplication.
 */
@SpringBootApplication
public class ProjectManagementApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProjectManagementApplication.class);
		app.run(args);
	}
}
