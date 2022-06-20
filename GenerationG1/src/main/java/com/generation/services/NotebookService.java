package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Notebook;
import com.generation.repositories.NotebookRepository;

@Service
public class NotebookService {
    
    @Autowired
    NotebookRepository notebookRepository;

    public void saveNotebook(@Valid Notebook notebook) {
        notebookRepository.save(notebook);
    }

    public List<Notebook> findAll() {
        return notebookRepository.findAll();
    }

    public Notebook buscarId(Long id) {
        return notebookRepository.findById(id).get(); //.get especifica el tipo de dato que necesitamos
    }


}
