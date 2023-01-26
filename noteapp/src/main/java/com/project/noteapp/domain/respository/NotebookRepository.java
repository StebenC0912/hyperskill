package com.project.noteapp.domain.respository;

import com.project.noteapp.domain.model.Notebook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository {
    Notebook save(Notebook notebook);
    List<Notebook> findAll();
    Notebook findByTitle(String title);
    void delete(String title);
}
