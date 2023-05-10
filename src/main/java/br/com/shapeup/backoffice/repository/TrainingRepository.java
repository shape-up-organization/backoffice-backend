package br.com.shapeup.backoffice.repository;

import br.com.shapeup.backoffice.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    void deleteTrainingById(Long id);
    List<Training>getAllTraining();
    List<Training> findByName(String name);
    List<Training> findByCategoryAndDuration(String category, int duration);

    List<Training> findByXpGreaterThan(double xp);

}
