package br.com.shapeup.backoffice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_exercise")
public class Exercise {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String exercise;
    @ManyToOne
    private Training training;
}
