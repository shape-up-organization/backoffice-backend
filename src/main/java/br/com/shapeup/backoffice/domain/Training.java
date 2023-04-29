package br.com.shapeup.backoffice.domain;

import java.sql.Time;
import java.time.LocalDateTime;

public class Training {

    private String name;
    private String description;
    private int duration;


    public Training(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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





