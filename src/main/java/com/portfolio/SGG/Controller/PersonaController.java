
package com.portfolio.SGG.Controller;


import com.portfolio.SGG.Entity.Persona;
import com.portfolio.SGG.Interface.IPersonaService;
import java.util.List;
import java.lang.Long;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontgabriel.web.app")
public class PersonaController {
    @Autowired IPersonaService IPersonaService;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return IPersonaService.getPersona();
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
        return "Persona creada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        IPersonaService.deletPersona(id);
        return "Persona borrada";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String newNombre,
                                @RequestParam("newApellido") String newApellido,
                                @RequestParam("newImg") String newImg){
    Persona persona = IPersonaService.findPersona(id);
    persona.setNombre(newNombre);
    persona.setApellido(newApellido);
    persona.setImg(newImg);
    IPersonaService.savePersona(persona);
    return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return IPersonaService.findPersona((long)1);
    }
    
    
    
}
