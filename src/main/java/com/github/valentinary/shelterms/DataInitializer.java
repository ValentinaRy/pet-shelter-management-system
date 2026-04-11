package com.github.valentinary.shelterms;

import com.github.valentinary.shelterms.animal.Animal;
import com.github.valentinary.shelterms.animal.AnimalRepository;
import com.github.valentinary.shelterms.employee.Employee;
import com.github.valentinary.shelterms.employee.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AnimalRepository animalRepository;
    private final EmployeeRepository employeeRepository;

    public DataInitializer(AnimalRepository animalRepository, EmployeeRepository employeeRepository) {
        this.animalRepository = animalRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        animalRepository.save(Animal.builder()
                .name("Biscuit")
                .species("Dog")
                .breed("Beagle")
                .birthday(LocalDate.of(2023, 10, 10))
                .about("Playful and friendly")
                .build());

        animalRepository.save(Animal.builder()
                .name("Luna")
                .species("Cat")
                .breed("mixed")
                .birthday(LocalDate.of(2021, 1, 11))
                .about("Calm, prefers quiet homes")
                .build());
        employeeRepository.save(Employee.builder()
                .name("Steven")
                .occupation("Vet")
                .birthday(LocalDate.of(1995, 3, 8))
                .build());
    }
}
