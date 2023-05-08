package br.com.shapeup.backoffice.controller;

import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.ports.input.TrainingPersistanceInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/trainings")
public class TrainingController {

    private final TrainingPersistanceInput trainingPersistanceInput;

    @DeleteMapping()
    public ResponseEntity<Void> deleteById(Long id) {

        trainingPersistanceInput.deleteTrainingById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

    @GetMapping("/search-id/{id}")
    public ResponseEntity<List<Training>> getAllTrainingsById(@RequestParam List<Training> id) {
List<Training> searchTrainings =trainingPersistanceInput.findAllTrainingById(id);
return getAllTrainingsById(searchTrainings);
    }
}
