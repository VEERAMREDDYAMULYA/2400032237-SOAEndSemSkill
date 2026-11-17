package com.example.tourist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;

@SpringBootApplication
public class TouristApplication {
    public static void main(String[] args) {
        SpringApplication.run(TouristApplication.class, args);
    }

    // Inserts one sample record so the PUT endpoint can be tested immediately.
    @Bean
    CommandLineRunner loadSampleTourist(TouristRepository repository) {
        return args -> {
            if (!repository.existsById(1L)) {
                repository.save(new Tourist(1L, "Arun", "Chennai", "arun@example.com"));
            }
        };
    }
}
