package br.com.shapeup.backoffice.application.mapper;

import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.ExerciseRegistredResponse;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.domain.Training;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public Exercise toModel(ExerciseRegisterRequest exerciseRegisterRequest, Training training){
        return Exercise.builder()
                .exercise(exerciseRegisterRequest.exercise())
                .training(training)
                .build();
    }

    public ExerciseRegistredResponse toExerciseRegistredResponse(Exercise exercise) {
        return ExerciseRegistredResponse.builder()
                .id(exercise.getId())
                .exercise(exercise.getExercise())
                .build();
    }

    public List<ExerciseRegistredResponse> toListExerciseRegistredResponse(List<Exercise> exercises) {
        return exercises.stream()
                .map(this::toExerciseRegistredResponse)
                .toList();
    }
}
