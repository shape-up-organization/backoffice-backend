package br.com.shapeup.backoffice.application.mapper;

import br.com.shapeup.backoffice.application.web.requests.TrainingRegisterRequest;
import br.com.shapeup.backoffice.application.web.responses.TrainingRegistredResponse;
import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.domain.enums.CategoryEnum;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public Training traningRegisterToTraining(TrainingRegisterRequest trainingRegisterRequest) {

        return Training.builder()
                .name(trainingRegisterRequest.getName())
                .duration(trainingRegisterRequest.getDuration())
                .xp(trainingRegisterRequest.getXp())
                .category(CategoryEnum.toEnum(trainingRegisterRequest.getCategory()))
                .description(trainingRegisterRequest.getDescription())
                .classification(trainingRegisterRequest.getClassification())
                .unlockXp(trainingRegisterRequest.getUnlockXp())
                .build();
    }

    public TrainingRegistredResponse trainingToTrainingRegistredResponse(Training training) {
        return new TrainingRegistredResponse(
                training.getId().toString(),
                training.getName(),
                training.getCategory().name(),
                training.getXp(),
                training.getDescription(),
                training.getDuration()
        );
    }

}
