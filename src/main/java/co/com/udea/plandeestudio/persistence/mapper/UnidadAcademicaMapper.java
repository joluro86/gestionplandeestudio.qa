package co.com.udea.plandeestudio.persistence.mapper;

import co.com.udea.plandeestudio.domain.model.UnidadAcademica;
import co.com.udea.plandeestudio.persistence.entity.UnidadAcademicaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnidadAcademicaMapper {

    UnidadAcademica toUnidadAcademica(UnidadAcademicaEntity unidadAcademicaEntity);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    UnidadAcademicaEntity toUnidadAcademicaEntity(UnidadAcademica unidadAcademica);

    List<UnidadAcademica> tounidadesAcademicas(List<UnidadAcademicaEntity> unidadesAcademicas);
}
