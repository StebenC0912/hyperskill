package com.project.noteapp.infrastructure.controller;

import com.project.noteapp.domain.model.Notebook;
import com.project.noteapp.domain.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebook")
public class controller {
    @Autowired
    private NotebookService notebookService;

    @PostMapping
    public ResponseEntity<Notebook> createNotebook(@RequestBody Notebook notebook){
        Notebook savedNotebook = notebookService.createNotebook(notebook);

        return new ResponseEntity<>(savedNotebook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notebook> searchNotebook(@PathVariable("id") String title) {
        Notebook savedNotebook = notebookService.searchNotebook(title);
        return new ResponseEntity<>(savedNotebook, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Notebook> deleteNotebook(@PathVariable("id") String title){
        notebookService.deleteNotebook(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Notebook>> findAll(){
        List<Notebook> notebooks = notebookService.findAll();
        return new ResponseEntity<>(notebooks,HttpStatus.OK);
    }
}
