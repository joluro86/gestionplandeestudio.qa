package co.com.udea.plandeestudio.persistence.repositoryimpl.departamento;

import co.com.udea.plandeestudio.domain.model.Departamento;
import co.com.udea.plandeestudio.domain.repository.departamento.DepartamentoRepository;
import co.com.udea.plandeestudio.persistence.crud.DepartamentoCrud;
import co.com.udea.plandeestudio.persistence.entity.DepartamentoEntity;
import co.com.udea.plandeestudio.persistence.mapper.DepartamentoMapper;
import co.com.udea.plandeestudio.persistence.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartamentoRepositoryImpl implements DepartamentoRepository {
    private final DepartamentoCrud persistence;
    private final DepartamentoMapper mapper;
    private final PersonaMapper mapperPersona;

    @Autowired
    public DepartamentoRepositoryImpl (DepartamentoCrud persistence, DepartamentoMapper mapper, PersonaMapper mapperPersona) {
        this.persistence = persistence;
        this.mapper = mapper;
        this.mapperPersona = mapperPersona;
    }

    @Override
    public Optional<Departamento> save(Departamento departamento) {
        DepartamentoEntity entity = mapper.toDepartamentoEntity(departamento);

        return Optional.of(mapper.toDepartamento(persistence.save(entity)));
    }

    @Override
    public Optional<Departamento> getDepartamentoByCodigo(Integer codigo) {
        Optional<DepartamentoEntity> entity = persistence.findDepartamentoEntityByCodigoDepartamento(codigo);

        return entity.map(mapper::toDepartamento);

    }

    @Override
    public Optional<List<Departamento>> getAllDepartamentos() {
        List<DepartamentoEntity> list = persistence.findAll();

        if (!list.isEmpty()) {
            return Optional.of(mapper.toDepartamentos(list));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Departamento> updateDepartamento(Departamento departamento) {
        Optional<DepartamentoEntity> entity = persistence.findDepartamentoEntityByCodigoDepartamento(departamento.getCodigoDepartamento());

        if (!entity.isPresent()) {
            return Optional.empty();
        }

        entity.get().setDecano(mapperPersona.toPersonaEntity(departamento.getDecano()));
        entity.get().setDireccion(departamento.getDireccion());
        entity.get().setTelefono(departamento.getTelefono());
        entity.get().setEmail(departamento.getEmail());

        return Optional.of(mapper.toDepartamento(entity.get()));
    }

    @Override
    public void deleteByCodigo(Integer codigo) {
        persistence.deleteDepartamentoEntityByCodigoDepartamento(codigo);
    }
}
