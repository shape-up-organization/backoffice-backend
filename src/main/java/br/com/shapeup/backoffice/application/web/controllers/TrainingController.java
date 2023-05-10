package br.com.shapeup.backoffice.application.web.controllers;

import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.repository.TrainingRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    @Autowired
    TrainingRepository trainingRepository;

    @PostMapping
    public ResponseEntity<Void> createTraining(@Valid @RequestBody Training training) {
        Training savedTrainings = trainingRepository.save(training);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Training>> ListTraining() {
        List<Training> trainings = trainingRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Training>> findTrainingsByName(@PathVariable String name) {
        List<Training> trainings = trainingRepository.findByName(name);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Training>> findTrainingsByCategoryAndDuration(@RequestParam String category, @RequestParam int duration) {
        List<Training> trainings = trainingRepository.findByCategoryAndDuration(category, duration);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/xp")
    public ResponseEntity<List<Training>> findTrainingsByXpGreaterThan(@RequestParam double xp) {
        List<Training> trainings = trainingRepository.findByXpGreaterThan(xp);
        return ResponseEntity.ok(trainings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        Optional<Training> training = trainingRepository.findById(id);
        if (training.isPresent()) {
            trainingRepository.deleteTrainingById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}