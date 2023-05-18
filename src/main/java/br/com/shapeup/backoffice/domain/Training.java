package br.com.shapeup.backoffice.domain;

import br.com.shapeup.backoffice.domain.enuns.CategoryEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_training")
public class Training {
    @Column(name = "training_id")
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    @NotNull
    private Long xp;
    @Size(min = 0, max = 500)
    private String description;
    private int duration;

    private String classification;

    @OneToMany(
            mappedBy = "training",
            fetch = FetchType.EAGER
    )
    private List<Exercise> exercises;
}





