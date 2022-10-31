
package com.portfolio.SGG.Security.Repository;

import com.portfolio.SGG.Security.Entity.Rol;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.SGG.Security.Enums.RolNombre;
import java.util.Optional;



@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
