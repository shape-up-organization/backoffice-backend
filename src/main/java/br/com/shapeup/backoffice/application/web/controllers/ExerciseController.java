package br.com.shapeup.backoffice.application.web.controllers;

import br.com.shapeup.backoffice.application.services.ExerciseService;
import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.application.web.requests.UpdateExerciseRequest;
import br.com.shapeup.backoffice.application.web.responses.ExerciseRegistredResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/backoffice/exercises")
@CrossOrigin(origins = "*")
public class ExerciseController {

   private final ExerciseService service;

   @PostMapping
   public ResponseEntity<Void> saveExercise(@Valid @RequestBody ExerciseRegisterRequest request){
      service.createExercise(request);
      return ResponseEntity.status(HttpStatus.CREATED).build();
   }

   @PutMapping
    public ResponseEntity<ExerciseRegistredResponse> updateExercise(@Valid @RequestBody UpdateExerciseRequest request){
       ExerciseRegistredResponse exerciseRegistredResponse = service.updateExercise(request);
       return ResponseEntity.ok(exerciseRegistredResponse);
    }

    @GetMapping
   public ResponseEntity<List<ExerciseRegistredResponse>> findAll(){
      List<ExerciseRegistredResponse> exercises = service.findAll();
      return ResponseEntity.ok(exercises);
   }
}