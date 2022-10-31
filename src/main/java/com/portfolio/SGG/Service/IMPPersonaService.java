
package com.portfolio.SGG.Service;

import com.portfolio.SGG.Entity.Persona;
import com.portfolio.SGG.Interface.IPersonaService;
import com.portfolio.SGG.Repository.IPersonaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMPPersonaService implements IPersonaService {
    @Autowired IPersonaRepository IPersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = IPersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        IPersonaRepository.save(persona);
    }

    @Override
    public void deletPersona(Long Id) {
        IPersonaRepository.deleteById(Id);
    }
    @Override
    public Persona findPersona(Long Id) {
        Persona persona = IPersonaRepository.findById(Id).orElse(null);
       return persona;
    }
    
}
