package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Notebook;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    
}
