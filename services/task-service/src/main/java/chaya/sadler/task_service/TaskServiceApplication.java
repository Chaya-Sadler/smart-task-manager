package chaya.sadler.task_service;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskServiceApplication {

	public static void main(String[] args) {

        SpringApplication.run(TaskServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner testFlyway(Flyway flyway) {
        return args -> {
            System.out.println("Flyway locations: " + flyway.getConfiguration().getLocations());
            System.out.println("Migrations pending: " + flyway.info().pending().length);
        };
    }

}
