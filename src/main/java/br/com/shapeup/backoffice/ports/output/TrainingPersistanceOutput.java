package br.com.shapeup.backoffice.ports.output;

import br.com.shapeup.backoffice.domain.Training;

import java.util.List;

public interface TrainingPersistanceOutput {

    void deleteTrainingById(Long id);

    List<Training> findAllTrainingById(List<Training> id);
}
