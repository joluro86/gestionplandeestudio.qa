package co.com.udea.plandeestudio.domain.service.departamento;

import co.com.udea.plandeestudio.domain.errorhandler.BadResponseHandler;
import co.com.udea.plandeestudio.domain.model.Departamento;
import co.com.udea.plandeestudio.domain.model.enums.Responses;
import co.com.udea.plandeestudio.domain.repository.departamento.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentoRepository repository;

    @Autowired
    public DepartamentoService (DepartamentoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Departamento getDepartamentoByCodigo(Integer codigo) {
        return repository.getDepartamentoByCodigo(codigo)
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_FOUND_ENTITY.getMensaje(),
                            Responses.NOT_FOUND_ENTITY.getCodigo(),
                            Responses.NOT_FOUND_ENTITY.getHttpStatus());
                });
    }

    @Transactional(readOnly = true)
    public List<Departamento> getAllDepartamentos() {
        return repository.getAllDepartamentos()
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_FOUND_ENTITIES.getMensaje(),
                            Responses.NOT_FOUND_ENTITIES.getCodigo(),
                            Responses.NOT_FOUND_ENTITIES.getHttpStatus());
                });
    }

    @Transactional
    public Departamento saveDepartameto(Departamento departamento) {
        return repository.save(departamento)
                .orElseThrow( () -> {
                    throw new BadResponseHandler(Responses.NOT_SAVE_ENTITY.getMensaje(),
                            Responses.NOT_SAVE_ENTITY.getCodigo(),
                            Responses.NOT_SAVE_ENTITY.getHttpStatus());
                });
    }

    @Transactional
    public boolean deleteDepartamento(Integer codigo) {
        return repository.getDepartamentoByCodigo(codigo).map(departamento -> {
            repository.deleteByCodigo(codigo);
            return true;
        }).orElseThrow( () -> {
            throw new BadResponseHandler(Responses.NOT_DELETE_ENTITY.getMensaje(),
                    Responses.NOT_DELETE_ENTITY.getCodigo(),
                    Responses.NOT_DELETE_ENTITY.getHttpStatus());
        });
    }

    @Transactional
    public Departamento updateDepartamento(Departamento departamento) {
        return repository.getDepartamentoByCodigo(departamento.getCodigoDepartamento())
                .map(temp -> repository.updateDepartamento(departamento).orElseThrow( () -> {
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
