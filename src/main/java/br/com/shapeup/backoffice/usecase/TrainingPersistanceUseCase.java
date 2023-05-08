package br.com.shapeup.backoffice.usecase;

import br.com.shapeup.backoffice.domain.Training;
import br.com.shapeup.backoffice.ports.input.TrainingPersistanceInput;
import br.com.shapeup.backoffice.ports.output.TrainingPersistanceOutput;

import java.util.List;

public class TrainingPersistanceUseCase implements TrainingPersistanceInput {

    private final TrainingPersistanceOutput trainingPersistanceOutput;

    public TrainingPersistanceUseCase(TrainingPersistanceOutput trainingPersistanceOutput) {
        this.trainingPersistanceOutput = trainingPersistanceOutput;
    }

    @Override
    public void deleteTrainingById(Long id) {
        trainingPersistanceOutput.deleteTrainingById(id);

    }

    public List<Training> findAllTrainingById(List<Training> id) {

        return trainingPersistanceOutput.findAllTrainingById(id);
    }
}
