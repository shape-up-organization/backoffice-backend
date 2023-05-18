package br.com.shapeup.backoffice.application.mapper;

import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.domain.Training;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public Exercise toModel(ExerciseRegisterRequest exerciseRegisterRequest, Training training){
        return Exercise.builder()
                .exercise(exerciseRegisterRequest.exercise())
                .training(training)
                .build();
    }
}
