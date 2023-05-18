package br.com.shapeup.backoffice.application.services;

import br.com.shapeup.backoffice.application.mapper.ExerciseMapper;
import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.repository.ExerciseRepository;
import br.com.shapeup.backoffice.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final TrainingRepository trainingRepository;
    private final ExerciseMapper exerciseMapper;

    public void createExercise(ExerciseRegisterRequest exerciseRegisterRequest){
        var training = trainingRepository.findById(UUID.fromString(exerciseRegisterRequest.trainingId()));
        var exercise = exerciseMapper.toModel(exerciseRegisterRequest, training.get());

        exerciseRepository.save(exercise);
    }

}
