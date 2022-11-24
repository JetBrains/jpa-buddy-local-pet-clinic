package com.example.swaggerprovider.controllers;

import com.example.swaggerprovider.model.Pet;
import com.example.swaggerprovider.model.User;
import com.example.swaggerprovider.model.Visit;
import com.github.javafaker.Faker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/pet")
public class PetController {
    private List<Pet> pets = generateFakePets();
    private Faker faker = new Faker();

    private List<Pet> generateFakePets() {
        Faker faker = new Faker();
        List<Pet> petList = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                int hashCode = faker.hacker().abbreviation().hashCode();
                user = new User((long) i,
                                faker.name().username(),
                                faker.name().firstName(),
                                faker.name().lastName(),
                                faker.bothify("????##@gmail.com"),
                                String.valueOf(hashCode),
                                faker.phoneNumber().phoneNumber(),
                                faker.random().nextInt(0,3));
            }
            List<Visit> visits = new ArrayList<>();
            Pet pet = new Pet((long) i,
                              faker.cat().name(),
                              user,
                              visits);
            for (int j = 0; j < faker.random().nextInt(2,5); j++) {
                Visit visit = new Visit(faker.random().nextLong(),
                                        faker.date().past(10, TimeUnit.DAYS).toInstant().atOffset(ZoneOffset.UTC),
                                        faker.name().fullName(),
                                        faker.company().name());
                visits.add(visit);
            }
            petList.add(pet);
        }
        return petList;
    }

    @GetMapping("/{petId}")
    public ResponseEntity<?> getPetById(@PathVariable Long petId) {
        Pet body = pets.get(Math.toIntExact(petId));
        System.out.println(body);
        return ResponseEntity.ok(body);
    }
}