package com.project.noteapp.domain.service;

import com.project.noteapp.domain.model.Notebook;
import com.project.noteapp.domain.respository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookRepository notebookRepository;
    @Override
    public Notebook createNotebook(Notebook notebook) {
        return notebookRepository.save(notebook);
    }
    @Override
    public Notebook searchNotebook(String title) {
        
        return notebookRepository.findByTitle(title);
    }

    @Override
    public void deleteNotebook(String title) {
        // implement the delete method.
        notebookRepository.delete(title);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookRepository.findAll();
    }

}

