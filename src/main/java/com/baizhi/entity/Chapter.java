package com.baizhi.entity;

import java.io.Serializable;

public class Chapter implements Serializable {
    private Integer id;
    private String title;
    private Double duration;
    private Double size;
    private String audioPath;
    private Special special;

    @Override
    public String toString() {
        return "Chapter{" + "id=" + id + ", title='" + title + '\'' + ", duration=" + duration + ", size=" + size + ", audioPath='" + audioPath + '\'' + ", special=" + special + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public Chapter(Integer id, String title, Double duration, Double size, String audioPath, Special special) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.size = size;
        this.audioPath = audioPath;
        this.special = special;
    }

    public Chapter() {
    }
}
