package com.project.noteapp.domain.service;

import com.project.noteapp.domain.model.Notebook;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NotebookService {
    Notebook createNotebook(Notebook notebook);
    Notebook searchNotebook(String title);
    void deleteNotebook(String title);
    List<Notebook> findAll();
}
