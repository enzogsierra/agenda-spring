package com.example.agenda.controller;

import com.example.agenda.model.Contacto;
import com.example.agenda.service.ContactoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PublicController 
{
    @Autowired
    private ContactoService contactoService;
    
    // Index
    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("contactos", contactoService.all());
        return "index";
    }
    
    
    // Añadir contacto
    @GetMapping("/nuevo-contacto")
    public String newContact(Model model)
    {
        Contacto contacto = new Contacto();
        model.addAttribute("contacto", contacto);
        return "nuevo-contacto";
    }
    
    @PostMapping("/nuevo-contacto")
    public String newContact_POST(@ModelAttribute("contacto") Contacto contacto)
    {
        // Guardar nuevo contacto
        contactoService.save(contacto);
        
        return "redirect:/?msg=1"; // Redirigir a index
    }
    
    
    // Editar contacto
    @GetMapping("/editar-contacto/{id}")
    public String editContact(@PathVariable(value = "id") int id, Model model) throws JsonProcessingException
    {
        // Buscar el contacto según el id asignado por url
        Contacto contacto = contactoService.findById(id);
        
        // Verificar si existe el contacto
        if(contacto == null) return "redirect:/?msg=4";

        //
        model.addAttribute("contacto", contacto);
        return "editar-contacto";
    }
    
    @PostMapping("/editar-contacto")
    public String editContact_POST(@ModelAttribute("contacto") Contacto contacto)
    {
        contactoService.save(contacto);
        return "redirect:/?msg=2";
    }
    
    
    // Eliminar contacto
    @GetMapping("/borrar-contacto/{id}")
    public String deleteContact(@PathVariable(value = "id") int id)
    {
        // Buscar el contacto según el id asignado por url
        Contacto contacto = contactoService.findById(id);
        
        // Verificar si existe el contacto
        if(contacto == null) return "redirect:/?msg=4";
        
        //
        contactoService.delete(id);
        
        return "redirect:/?msg=3";
    }
}
