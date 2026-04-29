package org.example.hnk24cntt1lathephong_004.config;

import lombok.RequiredArgsConstructor;
import org.example.hnk24cntt1lathephong_004.model.Spacecraft;
import org.example.hnk24cntt1lathephong_004.repository.SpacecratRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class Data {
    private final SpacecratRepository spacecratRepository;
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            if(spacecratRepository.count() == 0) {
                spacecratRepository.save(new Spacecraft(null, "Apollo", "NASA", LocalDate.of(1969, 7, 20)));
                spacecratRepository.save(new Spacecraft(null, "Voyager", "NASA", LocalDate.of(1977, 9, 5)));
            }
        };
    }

}
