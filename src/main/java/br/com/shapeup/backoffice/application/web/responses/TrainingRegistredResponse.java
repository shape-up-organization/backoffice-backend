package br.com.shapeup.backoffice.application.web.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRegistredResponse {
    private Long id;
    private String name;
    private String category;
    private double xp;
    private String description;
    private int duration;
}
