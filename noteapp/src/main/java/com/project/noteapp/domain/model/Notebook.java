package com.project.noteapp.domain.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Notebook {

    private String title;
    private String content;
    private LocalDate date;


    public Notebook(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = LocalDate.now();
    }

}
