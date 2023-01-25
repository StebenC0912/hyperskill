package com.project.noteapp.infrastructure.respository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface NotebookJpaRepo extends JpaRepository<NotebookEntity, String> {

}
