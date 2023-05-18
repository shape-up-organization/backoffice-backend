package br.com.shapeup.backoffice.application.web.controllers;

import br.com.shapeup.backoffice.application.services.ExerciseService;
import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.ExerciseRegistredResponse;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.repository.ExerciseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    ExerciseService service;

    @PostMapping
    public ResponseEntity <ExerciseRegistredResponse> createExercise(@Valid @RequestBody ExerciseRegisterRequest exercise){
        ExerciseRegistredResponse exerciseSave = this.service.saveExercise(exercise);
       return ResponseEntity.status(HttpStatus.CREATED).body(exerciseSave);
    }

}
