package co.com.udea.plandeestudio.domain.service.unidadacademica;

import co.com.udea.plandeestudio.domain.errorhandler.BadResponseHandler;
import co.com.udea.plandeestudio.domain.model.UnidadAcademica;
import co.com.udea.plandeestudio.domain.model.enums.Responses;
import co.com.udea.plandeestudio.domain.repository.unidadacademica.UnidadAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UnidadAcademicaService {
    private final UnidadAcademicaRepository repository;

    @Autowired
    public UnidadAcademicaService (UnidadAcademicaRepository repository) {
        this.repository = repository;
    }


    @Transactional(readOnly = true)
    public UnidadAcademica getUnidadAcademicaByCodigo(String codigo) {
        return repository.getUnidadAcademicaByCodigo(codigo)
                .orElseThrow( () -> {
                            throw new BadResponseHandler(Responses.NOT_FOUND_ENTITY.getMensaje(),
                                    Responses.NOT_FOUND_ENTITY.getCodigo(),
                                    Responses.NOT_FOUND_ENTITY.getHttpStatus());
                        });
    }

    @Transactional(readOnly = true)
    public List<UnidadAcademica> getUnidadesAcademicas() {
        return repository.getAllUnidadAcademica()
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_FOUND_ENTITIES.getMensaje(),
                            Responses.NOT_FOUND_ENTITIES.getCodigo(),
                            Responses.NOT_FOUND_ENTITIES.getHttpStatus());
                });
    }

    @Transactional
    public UnidadAcademica saveUnidadAcademica(UnidadAcademica unidadAcademica) {
        return repository.save(unidadAcademica)
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_SAVE_ENTITY.getMensaje(),
                            Responses.NOT_SAVE_ENTITY.getCodigo(),
                            Responses.NOT_SAVE_ENTITY.getHttpStatus());
                });
    }

    @Transactional 
    public boolean deleteUnidadAcademica(String codigo) {
        return repository.getUnidadAcademicaByCodigo(codigo).map(unidadAcademica -> {
            repository.delete(codigo);
            return true;
        }).orElseThrow( () -> {
            throw new BadResponseHandler(Responses.NOT_DELETE_ENTITY.getMensaje(),
                    Responses.NOT_DELETE_ENTITY.getCodigo(),
                    Responses.NOT_DELETE_ENTITY.getHttpStatus());
        });
    }

     @Transactional
    public UnidadAcademica updateUnidadAcademica(UnidadAcademica unidadAcademica) {
        return repository.getUnidadAcademicaByCodigo(unidadAcademica.getCodigo())
                .map(temp -> repository.update(unidadAcademica).orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_UPDATE_ENTITY.getMensaje(),
                            Responses.NOT_UPDATE_ENTITY.getCodigo(),
                            Responses.NOT_UPDATE_ENTITY.getHttpStatus());
                })).orElseThrow(() -> {
                    throw new BadResponseHandler(Responses.NOT_FOUND_ENTITY.getMensaje(),
                            Responses.NOT_FOUND_ENTITY.getCodigo(),
                            Responses.NOT_FOUND_ENTITY.getHttpStatus());
                });
    }

}
