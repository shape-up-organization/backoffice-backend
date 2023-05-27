package br.com.shapeup.backoffice.application.web.requests;

import br.com.shapeup.backoffice.domain.enums.CategoryEnum;
import java.util.List;

public record UpdateTrainingRequest(
        String id,
        String name,
        CategoryEnum category,
        Long xp,
        Long unlockXp,
        String description,
        Integer duration,
        String classification,
        List<String> exercises
) {
}
