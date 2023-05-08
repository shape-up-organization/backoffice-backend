package br.com.shapeup.backoffice.ports.input;

import br.com.shapeup.backoffice.domain.Training;

import java.util.List;

public interface TrainingPersistanceInput {

    List<Training> findAllTrainingById(List<Training> id);

    void deleteTrainingById(Long id);
}
