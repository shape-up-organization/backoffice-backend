package br.com.shapeup.backoffice.application.services;

import br.com.shapeup.backoffice.application.mapper.ExerciseMapper;
import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.ExerciseRegistredResponse;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.repository.ExerciseRepository;
import br.com.shapeup.backoffice.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    ExerciseMapper exerciseMapper;

    public ExerciseRegistredResponse saveExercise(ExerciseRegisterRequest registerRequest){
        Training treino = trainingRepository.findById(UUID.fromString(registerRequest.getTrainingId())).get();
       Exercise exercise = exerciseMapper.exerciseRegisterToExercises(registerRequest,treino);
       exerciseRepository.save(exercise);
       return  new ExerciseRegistredResponse(exercise.getId(),exercise.getExercise());
    }
}
