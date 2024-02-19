package com.example.Challenge1.Building.a.Library.Management.System;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Challenge1BuildingALibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(Challenge1BuildingALibraryManagementSystemApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
