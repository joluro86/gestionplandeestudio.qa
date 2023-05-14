package co.com.udea.plandeestudio.web.controller.departamento;

import co.com.udea.plandeestudio.domain.model.Departamento;
import co.com.udea.plandeestudio.domain.model.Mensaje;
import co.com.udea.plandeestudio.domain.service.departamento.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DepartamentoRest.DEPARTAMENTO)
public class DepartamentoRest {
    public static final String DEPARTAMENTO = "/departamento";
    private final DepartamentoService service;

    @Autowired
    public DepartamentoRest (DepartamentoService service) {
        this.service = service;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Departamento> getDepartamento(@PathVariable Integer codigo) {
        return new ResponseEntity<>(service.getDepartamentoByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getDepartamentos() {
        return new ResponseEntity<>(service.getAllDepartamentos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Departamento> saveDepartamento(@RequestBody Departamento departamento) {
        return new ResponseEntity<>(service.saveDepartameto(departamento), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Departamento> updateDepartamento(@RequestBody Departamento departamento) {
        return new ResponseEntity<>(service.updateDepartamento(departamento), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Mensaje> deleteDepartamento(@PathVariable Integer codigo) {
        service.deleteDepartamento(codigo);
        return new ResponseEntity<>(new Mensaje( "001", "Departamento eliminado eliminada"), HttpStatus.OK);
    }
}
