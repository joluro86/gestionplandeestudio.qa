package co.com.udea.plandeestudio.persistence.crud;

import co.com.udea.plandeestudio.persistence.entity.UnidadAcademicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnidadAcademicaCrud extends JpaRepository<UnidadAcademicaEntity, Integer> {

    Optional<UnidadAcademicaEntity> findUnidadAcademicaEntitiesByCodigo(String codigo);

    void deleteUnidadAcademicaEntityByCodigo(String codigo);

    //void updateUnidadAcademicaEntityByCodigo(String codigo);
}
