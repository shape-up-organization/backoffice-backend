package br.com.shapeup.backoffice.application.web.requests;

public record ExerciseRegisterRequest(
        String exercise,
        String trainingId
) {
}
