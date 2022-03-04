package com.example.agenda.service;

import com.example.agenda.model.Contacto;
import com.example.agenda.repository.ContactoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactoServiceImpl implements ContactoService 
{
    @Autowired
    private ContactoRepository contactoRepository;
    
    
    @Override
    public List<Contacto> all() {
        return contactoRepository.findAll();
    }
    
    @Override
    public Contacto findById(int id)
    {
        Contacto contacto = null;
        Optional<Contacto> optional = contactoRepository.findById(id);
        
        if(optional.isPresent()) contacto = optional.get();
        //else throw new RuntimeException("Contacto id:" + id + " no encontrado");
        return contacto;
    }
    
    @Override
    public void save(Contacto contacto)
    {
        this.contactoRepository.save(contacto);
    }
    
    @Override
    public void delete(int id)
    {
        this.contactoRepository.deleteById(id);
    }
}
