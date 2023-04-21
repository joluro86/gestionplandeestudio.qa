package co.com.udea.plandeestudio.domain.service;

import co.com.udea.plandeestudio.domain.errorhandler.BadResponseHandler;
import co.com.udea.plandeestudio.domain.model.UnidadAcademica;
import co.com.udea.plandeestudio.domain.model.enums.Responses;
import co.com.udea.plandeestudio.domain.repository.UnidadAcademicaRepository;
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


    public UnidadAcademica getUnidadAcademicaByCodigo(String codigo) {
        return repository.getUnidadAcademicaByCodigo(codigo)
                .orElseThrow( () -> {
                            throw new BadResponseHandler(Responses.NOT_FOUND_ENTITY.getMensaje(),
                                    Responses.NOT_FOUND_ENTITY.getCodigo(),
                                    Responses.NOT_FOUND_ENTITY.getHttpStatus());
                        });
    }

    public List<UnidadAcademica> getUnidadesAcademicas() {
        return repository.getAllUnidadAcademica()
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_FOUND_ENTITIES.getMensaje(),
                            Responses.NOT_FOUND_ENTITIES.getCodigo(),
                            Responses.NOT_FOUND_ENTITIES.getHttpStatus());
                });
    }

    @transaccion 
    public UnidadAcademica saveUnidadAcademica(UnidadAcademica unidadAcademica) {
        return repository.save(unidadAcademica)
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_SAVE_ENTITy.getMensaje(),
                            Responses.NOT_SAVE_ENTITy.getCodigo(),
                            Responses.NOT_SAVE_ENTITy.getHttpStatus());
                });
    }

    @transaccion 
    public boolean deleteUnidadAcademica(String codigo) {
        return repository.getUnidadAcademicaByCodigo(codigo).map(unidadAcademica -> {
            repository.delete(codigo);
            return true;
        }).orElseThrow( () -> {
            throw new BadResponseHandler(Responses.NOT_DELETE_ENTITy.getMensaje(),
                    Responses.NOT_DELETE_ENTITy.getCodigo(),
                    Responses.NOT_DELETE_ENTITy.getHttpStatus());
        });
    }

    @transaccion 
    public UnidadAcademica updateUnidadAcademica(UnidadAcademica unidadAcademica) {
        return repository.update(unidadAcademica)
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_SAVE_ENTITy.getMensaje(),
                            Responses.NOT_SAVE_ENTITy.getCodigo(),
                            Responses.NOT_SAVE_ENTITy.getHttpStatus());
                });
    }

}
