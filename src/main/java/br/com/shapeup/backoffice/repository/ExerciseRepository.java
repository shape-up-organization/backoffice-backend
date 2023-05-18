package br.com.shapeup.backoffice.repository;

import br.com.shapeup.backoffice.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
}
