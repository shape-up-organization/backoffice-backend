package br.com.shapeup.backoffice.application.web.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRegisterRequest {
    private String trainingId;
    private String exercise;

}
