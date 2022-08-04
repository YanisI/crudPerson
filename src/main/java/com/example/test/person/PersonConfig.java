package com.example.test.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            Person mariam = new Person(
                    "mariamM",
                "Mariam",
                "Machin",
                "pssword",
                "m.machin@gmail.com",
                LocalDate.of(1998, Month.FEBRUARY, 9)

            );

            Person alex = new Person(
                    "alex27",
                    "Alex",
                    "Truc",
                    "password",
                    "a.truc@gmail.com",
                    LocalDate.of(1996, Month.JANUARY, 8)

            );

            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
