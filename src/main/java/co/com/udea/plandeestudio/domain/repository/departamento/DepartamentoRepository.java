package co.com.udea.plandeestudio.domain.repository.departamento;

import co.com.udea.plandeestudio.domain.model.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository {
    Optional<Departamento> save(Departamento departamento);
    Optional<Departamento> getDepartamentoByCodigo(Integer codigo);
    Optional<List<Departamento>> getAllDepartamentos();
    Optional<Departamento> updateDepartamento(Departamento departamento);
    void deleteByCodigo(Integer codigo);
}
