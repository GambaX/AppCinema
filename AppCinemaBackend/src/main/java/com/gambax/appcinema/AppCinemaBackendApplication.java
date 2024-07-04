package com.gambax.appcinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gambax.appcinema")
public class AppCinemaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCinemaBackendApplication.class, args);
		System.out.println("========== CinemaApp Backend sta runnando! ==========");
	}

}
