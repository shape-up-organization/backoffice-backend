package br.com.shapeup.backoffice.application.web.controllers;

import br.com.shapeup.backoffice.application.services.TrainingService;
import br.com.shapeup.backoffice.application.web.requests.TrainingRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.TrainingRegistredResponse;
import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.repository.TrainingRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @Transactional
    @PostMapping
    public ResponseEntity<TrainingRegistredResponse> createTraining(@Valid @RequestBody TrainingRegisterRequest trainingRegisterRequest) {
        TrainingRegistredResponse savedTrainings = trainingService.saveTraining(trainingRegisterRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainings);
    }

    @GetMapping
    public ResponseEntity<List<Training>> ListTraining() {
        List<Training> trainings = trainingService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Training>> findTrainingsByName(@PathVariable String name) {
        List<Training> trainings = trainingService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<Training>> findTrainingsByCategory(@PathVariable String category){
        List<Training> trainingsByCategory = trainingService.findByCategory(category);
        if (!trainingsByCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(trainingsByCategory);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/category/{category}/{duration}")
    public ResponseEntity<List<Training>> findTrainingsByCategoryAndDuration(@PathVariable String category, @PathVariable int duration) {
        List<Training> trainings = trainingService.findByCategoryAndDuration(category, duration);
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }


    @GetMapping("/xp/{xp}")
    public ResponseEntity<List<Training>> findTrainingsByXpGreaterThan(@PathVariable Long xp) {
        List<Training> trainings = trainingService.findByXpGreaterThan(xp);
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable UUID id, @RequestBody Training updatedTraining) {
        Training existingTraining = trainingService.getTrainingById(id);
        if (existingTraining == null) {
            return ResponseEntity.notFound().build();
        }

        existingTraining.setName(updatedTraining.getName());
        existingTraining.setCategory(updatedTraining.getCategory());
        existingTraining.setXp(updatedTraining.getXp());
        existingTraining.setDescription(updatedTraining.getDescription());
        existingTraining.setDuration(updatedTraining.getDuration());
        existingTraining.setClassification(updatedTraining.getClassification());
        existingTraining.setExercises(updatedTraining.getExercises());

        updatedTraining = trainingService.updateTraining(existingTraining);

        return ResponseEntity.ok(updatedTraining);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable UUID id) {
        Optional<Training> training = trainingService.findById(id);
        if (training.isPresent()) {
            trainingService.deleteTrainingById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}