package co.com.udea.plandeestudio.persistence.repositoryimpl;

import co.com.udea.plandeestudio.domain.model.UnidadAcademica;
import co.com.udea.plandeestudio.domain.repository.UnidadAcademicaRepository;
import co.com.udea.plandeestudio.persistence.crud.UnidadAcademicaCrud;
import co.com.udea.plandeestudio.persistence.entity.UnidadAcademicaEntity;
import co.com.udea.plandeestudio.persistence.mapper.UnidadAcademicaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UnidadAcademicaRepositoryImpl implements UnidadAcademicaRepository {
    private final UnidadAcademicaCrud persistence;
    private final UnidadAcademicaMapper mapper;

    @Autowired
    public UnidadAcademicaRepositoryImpl(UnidadAcademicaCrud persistence, UnidadAcademicaMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }


    @Override
    public Optional<UnidadAcademica> getUnidadAcademicaByCodigo(String codigo) {
        return persistence.findUnidadAcademicaEntitiesByCodigo(codigo)
                .map(mapper::toUnidadAcademica);
    }

    @Override
    public Optional<List<UnidadAcademica>> getAllUnidadAcademica() {
        List<UnidadAcademicaEntity> lista = persistence.findAll();
        if (lista.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.tounidadesAcademicas(lista));
    }

    @Override
    public Optional<UnidadAcademica> save(UnidadAcademica unidadAcademica) {
        UnidadAcademicaEntity entity = mapper.toUnidadAcademicaEntity(unidadAcademica);
        return Optional.of(mapper.toUnidadAcademica(persistence.save(entity)));
    }

    @Override
    public Optional<UnidadAcademica> update(UnidadAcademica unidadAcademica) {
        UnidadAcademicaEntity entity = mapper.toUnidadAcademicaEntity(unidadAcademica);
        return Optional.of(mapper.toUnidadAcademica(persistence.update(entity)));
    }

    @Override
    public void delete(String codigo) {
        persistence.deleteUnidadAcademicaEntityByCodigo(codigo);
    }
}
