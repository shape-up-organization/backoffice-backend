package br.com.shapeup.backoffice.application.web.requests;

import jakarta.validation.constraints.NotBlank;

public record UpdateExerciseRequest(
        @NotBlank
        String id,
        @NotBlank
        String exercise
) {
}
