package br.com.shapeup.backoffice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String category;
    @NotNull
    private double xp;
    @Size(min = 0, max = 500)
    private String description;
    private int duration;

    public Training(String name, String category, double xp, String description, int duration) {
        this.name = name;
        this.category = category;
        this.xp = xp;
        this.description = description;
        this.duration = duration;
    }
}





