package co.com.udea.plandeestudio.persistence.crud;

import co.com.udea.plandeestudio.persistence.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoCrud extends JpaRepository<DepartamentoEntity, Integer> {

    Optional<DepartamentoEntity> findDepartamentoEntityByCodigoDepartamento(Integer codigoDepartamento);

    void deleteDepartamentoEntityByCodigoDepartamento(Integer codigoDepartamento);
}
