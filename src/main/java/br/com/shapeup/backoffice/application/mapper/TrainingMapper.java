package br.com.shapeup.backoffice.application.mapper;

import br.com.shapeup.backoffice.application.web.requests.TrainingRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.TrainingRegistredResponse;
import br.com.shapeup.backoffice.domain.Training;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public Training traningRegisterToTraining(TrainingRegisterRequest trainingRegisterRequest) {
        return new Training(
                null,
                trainingRegisterRequest.getName(),
                trainingRegisterRequest.getCategory(),
                trainingRegisterRequest.getXp(),
                trainingRegisterRequest.getDescription(),
                trainingRegisterRequest.getDuration()
        );
    }

    public TrainingRegistredResponse trainingToTrainingRegistredResponse(Training training) {
        return new TrainingRegistredResponse(
                training.getId(),
                training.getName(),
                training.getCategory(),
                training.getXp(),
                training.getDescription(),
                training.getDuration()
        );
    }

}
