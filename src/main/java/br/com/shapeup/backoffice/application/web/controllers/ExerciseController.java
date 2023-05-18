package br.com.shapeup.backoffice.application.web.controllers;
import br.com.shapeup.backoffice.application.services.ExerciseService;
import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.repository.ExerciseRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercises")
public class ExerciseController {

   private final ExerciseService service;

   @PostMapping()
   public ResponseEntity<Void> saveExercise(@Valid @RequestBody ExerciseRegisterRequest request){
      service.createExercise(request);
      return ResponseEntity.status(HttpStatus.CREATED).build();
   }
}
