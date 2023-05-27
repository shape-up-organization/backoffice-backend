package br.com.shapeup.backoffice.application.services;

import br.com.shapeup.backoffice.application.exceptions.NotFoundException;
import br.com.shapeup.backoffice.application.mapper.TrainingMapper;
import br.com.shapeup.backoffice.application.web.requests.TrainingRegisterRequest;
import br.com.shapeup.backoffice.application.web.requests.UpdateTrainingRequest;
import br.com.shapeup.backoffice.application.web.responses.TrainingRegistredResponse;
import br.com.shapeup.backoffice.domain.Exercise;
import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.repository.ExerciseRepository;
import br.com.shapeup.backoffice.repository.TrainingRepository;
import br.com.shapeup.backoffice.utils.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;
    private final ExerciseRepository exerciseRepository;

    public TrainingRegistredResponse saveTraining(TrainingRegisterRequest trainingRegisterRequest) {

        List<Exercise> exercises = new ArrayList<>();

        Training training = trainingMapper.traningRegisterToTraining(trainingRegisterRequest);
        addExercisesToTraining(trainingRegisterRequest.getExercises(), training, exercises);

        training.setExercises(exercises);
        trainingRepository.save(training);
        exerciseRepository.saveAll(exercises);

        return trainingMapper.trainingToTrainingRegistredResponse(training);
    }

    public List<TrainingRegistredResponse> findAll() {
        List<Training> trainings = trainingRepository.findAll();

        return trainingMapper.trainingsToTrainingRegistredResponse(trainings);
    }

    public List<TrainingRegistredResponse> findByCategory(String category) {
        List<Training> trainings = trainingRepository.findByCategory(category);

        return trainingMapper.trainingsToTrainingRegistredResponse(trainings);
    }


    public List<TrainingRegistredResponse> findByName(String name) {
        List<Training> trainings = trainingRepository.findByName(name);

        return trainingMapper.trainingsToTrainingRegistredResponse(trainings);
    }

    public List<TrainingRegistredResponse> findByCategoryAndDuration(String category, int duration) {
        List<Training> trainings = trainingRepository.findByCategoryAndDuration(category, duration);

        return trainingMapper.trainingsToTrainingRegistredResponse(trainings);
    }

    public Optional<Training> findById(UUID id) {
        return trainingRepository.findById(id);
    }

    public void deleteTrainingById(UUID id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training not found"));

        List<Exercise> exercises = training.getExercises();

        exerciseRepository.deleteAll(exercises);
        trainingRepository.deleteById(id);
    }

    public List<TrainingRegistredResponse> findByXpGreaterThan(Long xp) {
        List<Training> trainings = trainingRepository.findByXpGreaterThan(xp);

        return trainingMapper.trainingsToTrainingRegistredResponse(trainings);
    }

    public Training getTrainingById(UUID id) {
        return trainingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Training not found"));
    }

    public TrainingRegistredResponse updateTraining(UpdateTrainingRequest updateTrainingRequest) {

        List<Exercise> exercises = new ArrayList<>();

        Training training = trainingRepository.findById(UUID.fromString(updateTrainingRequest.id()))
                .orElseThrow(() -> new NotFoundException("Training not found"));

        if(!updateTrainingRequest.exercises().isEmpty()) {
            exerciseRepository.deleteAll(training.getExercises());
            training.getExercises().clear();
            addExercisesToTraining(updateTrainingRequest.exercises(), training, exercises);
        }

        training.setId(UUID.fromString(updateTrainingRequest.id()));
        ObjectUtils.copyNonNullProperties(updateTrainingRequest, training);
        exerciseRepository.saveAll(exercises);
        training.setExercises(exercises);
        trainingRepository.save(training);

        return trainingMapper.trainingToTrainingRegistredResponse(training);
    }

    private static void addExercisesToTraining(List<String> exercisesString, Training training, List<Exercise> exercises) {
        for(String exercise : exercisesString) {
            var exerciseModel = Exercise.builder()
                    .exercise(exercise)
                    .training(training)
                    .build();

            exercises.add(exerciseModel);
        }
    }
}
