package co.com.udea.plandeestudio.persistence.crud;

import co.com.udea.plandeestudio.persistence.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaCrud extends JpaRepository<PersonaEntity, Integer> {
    
}
