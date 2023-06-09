package br.com.shapeup.backoffice.application.web.controllers;

import br.com.shapeup.backoffice.application.services.TrainingService;
import br.com.shapeup.backoffice.application.web.requests.TrainingRegisterRequest;
import br.com.shapeup.backoffice.application.web.requests.UpdateTrainingRequest;
import br.com.shapeup.backoffice.application.web.responses.TrainingRegistredResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/backoffice/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    @Transactional
    @PostMapping
    public ResponseEntity<TrainingRegistredResponse> createTraining(@Valid @RequestBody TrainingRegisterRequest trainingRegisterRequest) {
        TrainingRegistredResponse savedTrainings = trainingService.saveTraining(trainingRegisterRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainings);
    }

    @GetMapping
    public ResponseEntity<List<TrainingRegistredResponse>> ListTraining() {
        List<TrainingRegistredResponse> trainings = trainingService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<TrainingRegistredResponse>> findTrainingsByName(@PathVariable String name) {
        var trainings = trainingService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<TrainingRegistredResponse>> findTrainingsByCategory(@PathVariable String category){
        var trainings = trainingService.findByCategory(category);
        if (!trainings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(trainings);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/category/{category}/{duration}")
    public ResponseEntity<List<TrainingRegistredResponse>> findTrainingsByCategoryAndDuration(@PathVariable String category, @PathVariable int duration) {
        var trainings = trainingService.findByCategoryAndDuration(category, duration);
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }


    @GetMapping("/xp/{xp}")
    public ResponseEntity<List<TrainingRegistredResponse>> findTrainingsByXpGreaterThan(@PathVariable Long xp) {
        var trainings = trainingService.findByXpGreaterThan(xp);
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @PutMapping
    public ResponseEntity<TrainingRegistredResponse> updateTraining(@RequestBody UpdateTrainingRequest updateTrainingRequest) {

        var trainingRegistredResponse = trainingService.updateTraining(updateTrainingRequest);

        return ResponseEntity.ok(trainingRegistredResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable UUID id) {
            trainingService.deleteTrainingById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}