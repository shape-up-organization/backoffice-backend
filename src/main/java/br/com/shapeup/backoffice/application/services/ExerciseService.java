package br.com.shapeup.backoffice.application.services;

import br.com.shapeup.backoffice.application.exceptions.NotFoundException;
import br.com.shapeup.backoffice.application.mapper.ExerciseMapper;
import br.com.shapeup.backoffice.application.web.requests.ExerciseRegisterRequest;
import br.com.shapeup.backoffice.application.web.requests.UpdateExerciseRequest;
import br.com.shapeup.backoffice.application.web.responses.ExerciseRegistredResponse;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.repository.ExerciseRepository;
import br.com.shapeup.backoffice.repository.TrainingRepository;
import br.com.shapeup.backoffice.utils.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public ExerciseRegistredResponse updateExercise(UpdateExerciseRequest updateExerciseRequest) {
        var exercise = exerciseRepository.findById(UUID.fromString(updateExerciseRequest.id()))
                .orElseThrow(() -> new NotFoundException("Exercise not found"));

        Exercise updatedExercise = ObjectUtils.copyNonNullProperties(updateExerciseRequest, exercise);

        return exerciseMapper.toExerciseRegistredResponse(updatedExercise);
    }

    public List<ExerciseRegistredResponse> findAll() {
        List<Exercise> exerciseList = exerciseRepository.findAll();

        return exerciseMapper.toListExerciseRegistredResponse(exerciseList);
    }
}
