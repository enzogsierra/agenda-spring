package com.example.agenda.service;

import com.example.agenda.model.Contacto;
import java.util.List;


public interface ContactoService 
{
    List<Contacto> all();
    Contacto findById(int id);
    void save(Contacto contacto);
    void delete(int id);
}
