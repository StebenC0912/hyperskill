package com.project.noteapp.infrastructure.respository;

import com.project.noteapp.domain.model.Notebook;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notebook")
@Entity
public class NotebookEntity {
    @Id
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private LocalDate date;
    public static NotebookEntity fromDomain(Notebook notebook){
        return new NotebookEntity(notebook.getTitle(),notebook.getContent(),notebook.getDate());
    }

    public Notebook toDomain() {
        return new Notebook(title,content,date);
    }
}
