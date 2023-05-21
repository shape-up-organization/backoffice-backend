package br.com.shapeup.backoffice.repository;

import br.com.shapeup.backoffice.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainingRepository extends JpaRepository<Training, UUID> {
List<Training> findByCategory(String category);
    List<Training> findByName(String name);
    List<Training> findByCategoryAndDuration(String category, int duration);

    List<Training> findByXpGreaterThan(Long xp);

}
