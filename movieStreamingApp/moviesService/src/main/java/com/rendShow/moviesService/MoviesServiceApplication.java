package com.rendShow.moviesService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.rendShow.moviesService.config.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class MoviesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}

}
