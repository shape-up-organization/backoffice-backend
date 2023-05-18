package br.com.shapeup.backoffice.application.services;

import br.com.shapeup.backoffice.application.mapper.TrainingMapper;
import br.com.shapeup.backoffice.application.web.requests.TrainingRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.TrainingRegistredResponse;
import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.repository.TrainingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TrainingMapper trainingMapper;

    public TrainingRegistredResponse saveTraining(TrainingRegisterRequest trainingRegisterRequest) {

        Training training = trainingMapper.traningRegisterToTraining(trainingRegisterRequest);
        trainingRepository.save(training);

        return trainingMapper.trainingToTrainingRegistredResponse(training);
    }

    public List<Training> findAll() {

        return trainingRepository.findAll();
    }
    public List<Training>findByCategory(String category){
        return trainingRepository.findByCategory(category);
    };

    public List<Training> findByName(String name) {
        return trainingRepository.findByName(name);
    }

    public List<Training> findByCategoryAndDuration(String category, int duration) {
        return trainingRepository.findByCategoryAndDuration(category, duration);
    }

    public Optional<Training> findById(UUID id) {
        return trainingRepository.findById(id);
    }

    public void deleteTrainingById(UUID id) {
        trainingRepository.deleteById(id);
    }

    public List<Training> findByXpGreaterThan(Long xp) {
        List<Training> trainings = trainingRepository.findByXpGreaterThan(xp);
        return trainings;
    }
}
