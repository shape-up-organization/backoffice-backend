package br.com.shapeup.backoffice.application.web.requests;

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
public class TrainingRegisterRequest {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String category;
    @NotNull
    private Long xp;
    @NotNull
    private Long unlockXp;
    @Size(min = 0, max = 500)
    private String description;
    private Integer duration;
    private String classification;
}
