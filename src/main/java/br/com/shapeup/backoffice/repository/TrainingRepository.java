package br.com.shapeup.backoffice.repository;

import br.com.shapeup.backoffice.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, UUID> {
List<Training> findByCategory(String category);
    List<Training> findByName(String name);
    List<Training> findByCategoryAndDuration(String category, int duration);

    List<Training> findByXpGreaterThan(Long xp);

}
