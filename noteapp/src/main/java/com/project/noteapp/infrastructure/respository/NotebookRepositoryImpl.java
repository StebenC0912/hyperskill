package com.project.noteapp.infrastructure.respository;

import com.project.noteapp.domain.model.Notebook;
import com.project.noteapp.domain.respository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NotebookRepositoryImpl implements NotebookRepository {
    @Autowired
    private NotebookJpaRepo notebookJpaRepo;
    @Override
    public Notebook save(Notebook notebook) {
        return notebookJpaRepo.save(NotebookEntity.fromDomain(notebook)).toDomain();
    }

    @Override
    public List<Notebook> findAll() {
        return notebookJpaRepo.findAll().stream().map(NotebookEntity::toDomain).toList();
    }

    @Override
    public Notebook findByTitle(String title) {
        return notebookJpaRepo.findById(title).map(NotebookEntity::toDomain).orElse(null);
    }

    @Override
    public void delete(String title) {
        notebookJpaRepo.deleteById(title);
    }
}
