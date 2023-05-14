package co.com.udea.plandeestudio.persistence.mapper;

import co.com.udea.plandeestudio.domain.model.Departamento;
import co.com.udea.plandeestudio.persistence.entity.DepartamentoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    Departamento toDepartamento(DepartamentoEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    DepartamentoEntity toDepartamentoEntity(Departamento departamento);

    List<Departamento> toDepartamentos(List<DepartamentoEntity> departamentoEntities);
}
