package br.com.shapeup.backoffice.application.web.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRegisterRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotNull
    private Long xp;
    @NotNull
    private Long unlockXp;
    @Size(min = 0, max = 500)
    @NotBlank
    private String description;
    @NotNull
    private Integer duration;
    @NotBlank
    private String classification;
    @NotNull
    private List<String> exercises;
}
