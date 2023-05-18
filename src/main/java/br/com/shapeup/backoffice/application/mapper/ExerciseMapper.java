package br.com.shapeup.backoffice.application.mapper;

import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.ExerciseRegistredResponse;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.domain.Training;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {
    public Exercise exerciseRegisterToExercises(ExerciseRegisterRequest exerciseRegisterRequest, Training training) {
        return new Exercise(
                null,
                exerciseRegisterRequest.getExercise(),
                training
        );
    }

    public ExerciseRegistredResponse exerciseToexerciseRegistredResponse(Exercise exercise) {
        return new ExerciseRegistredResponse(
                exercise.getId(),
                exercise.getExercise()
        );
    }

}
