package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Notebook;
import com.generation.services.NotebookService;


@Controller
@RequestMapping("/notebook")
public class NotebookController {

    @Autowired
    NotebookService notebookService;
    

    @RequestMapping("")
    public String notebookRegistro(@ModelAttribute("notebook") Notebook notebook){
        return "notebook.jsp";
    }

    @PostMapping("/registro")
    public String saveNotebook(@Valid @ModelAttribute("notebook") Notebook notebook,
            BindingResult resultado, Model model) {
        // El bindingResult va seguido del Valid, este valida lo que esta en el jsp
        if (resultado.hasErrors() || notebook.getModelo() == "" || notebook.getColor() == "" || notebook.getMarca() == "") { // Capturando si existe un error en el
            model.addAttribute("msgError", "Datos mal ingresados"); // ingreso de datos desde el jsp
            return "notebook.jsp";
        } else {
            // Enviar el objeto al servicio
            notebookService.saveNotebook(notebook);

            return "redirect:/notebook/mostrar";
        }

    }
    @RequestMapping("/mostrar")
    public String mostrar(Model model){
        // Obtener una lista de autos
        List<Notebook> listaNotebooks = notebookService.findAll();
        model.addAttribute("listaNotebooks", listaNotebooks); // Pasamos la lista al jsp
        return "mostrarNotebooks.jsp"; // La pagina que desplegamos
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        
        System.out.println("El id es "+ id);
        Notebook notebook = notebookService.buscarId(id);
        model.addAttribute("notebook", notebook); //pasar al jsp

        return "editarNotebook.jsp";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarNotebook(@PathVariable("id") Long id, @Valid @ModelAttribute("notebook") Notebook notebook,
            BindingResult resultado, Model model) {
        // El bindingResult va seguido del Valid, este valida lo que esta en el jsp
        if (resultado.hasErrors() || notebook.getModelo() == "" || notebook.getColor() == "" || notebook.getMarca() == "") {
            model.addAttribute("msgError", "Datos mal ingresados");
            return "notebook.jsp";
        } else {
            notebook.setId(id);
            // Enviar el objeto al servicio
            notebookService.saveNotebook(notebook);

            return "redirect:/notebook/mostrar";
        }
    }




}
