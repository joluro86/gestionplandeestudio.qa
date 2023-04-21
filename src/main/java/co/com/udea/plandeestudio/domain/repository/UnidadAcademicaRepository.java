package co.com.udea.plandeestudio.domain.repository;

import co.com.udea.plandeestudio.domain.model.UnidadAcademica;

import java.util.List;
import java.util.Optional;

public interface UnidadAcademicaRepository {
    Optional<UnidadAcademica> getUnidadAcademicaByCodigo(String codigo);
    Optional<List<UnidadAcademica>> getAllUnidadAcademica();
    Optional<UnidadAcademica> save(UnidadAcademica unidadAcademica);
    Optional<UnidadAcademica> update(UnidadAcademica unidadAcademica);
    void delete(String codigo);
}
