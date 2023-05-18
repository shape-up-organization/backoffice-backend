package br.com.shapeup.backoffice.application.web.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
public class ExerciseRegistredResponse {
    private UUID id;
    private String exercise;
}
