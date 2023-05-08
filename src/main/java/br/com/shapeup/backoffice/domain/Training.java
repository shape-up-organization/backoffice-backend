package br.com.shapeup.backoffice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String category;
    @NotNull
    private double Xp;

    private List<String> atividades;
    private String description;
    private int duration;

    public Training(Long id, String name, String category, double xp, List<String> atividades, String description, int duration) {
        this.id = id;
        this.name = name;
        this.category = category;
        Xp = xp;
        this.atividades = atividades;
        this.description = description;
        this.duration = duration;
    }

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getXp() {
        return Xp;
    }

    public void setXp(double xp) {
        Xp = xp;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}





