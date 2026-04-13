package com.github.valentinary.shelterms.animal;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/animals")
    List<Animal> getAll() {
        return animalService.findAll();
    }

    @PostMapping("/animals")
    Animal newAnimal(@RequestBody Animal newAnimal) {
        return animalService.save(newAnimal);
    }

    @GetMapping("/animals/{id}")
    Animal getById(@PathVariable Long id) {

        return animalService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find animal " + id));
    }

    @PutMapping("/animals/{id}")
    Animal updateAnimal(@RequestBody Animal newAnimal, @PathVariable Long id) {

        return animalService.findById(id)
                .map(animal -> {
                    animal.setName(newAnimal.getName());
                    animal.setSpecies(newAnimal.getSpecies());
                    animal.setBreed(newAnimal.getBreed());
                    animal.setBirthday(newAnimal.getBirthday());
                    animal.setAbout(newAnimal.getAbout());
                    return animalService.save(animal);
                })
                .orElseGet(() -> animalService.save(newAnimal));
    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimal(@PathVariable Long id) {
        animalService.delete(id);
    }
}
