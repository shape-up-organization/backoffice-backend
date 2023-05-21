package br.com.shapeup.backoffice.application.web.responses;

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
    private Long xp;
    private String description;
    private Integer duration;
}
