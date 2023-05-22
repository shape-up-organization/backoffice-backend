package br.com.shapeup.backoffice.application.web.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRegistredResponse {
    private String id;
    private String name;
    private String category;
    private String classification;
    private Long xp;
    private Long unlockXp;
    private String description;
    private Integer duration;
    private List<String> exercises;
}
