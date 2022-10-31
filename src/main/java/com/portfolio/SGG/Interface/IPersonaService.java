
package com.portfolio.SGG.Interface;

import com.portfolio.SGG.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //obtener persona
    public List<Persona> getPersona();
    
    //guardar una persoan
    public void savePersona(Persona persona);
    
    //eliminar una persona
    
    public void deletPersona(Long Id);
    
    //buscar una persona
    
    public Persona findPersona(Long Id);
    
}
