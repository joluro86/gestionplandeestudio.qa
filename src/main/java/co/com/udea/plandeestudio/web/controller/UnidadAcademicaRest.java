package co.com.udea.plandeestudio.web.controller;

import co.com.udea.plandeestudio.domain.model.Mensaje;
import co.com.udea.plandeestudio.domain.model.UnidadAcademica;
import co.com.udea.plandeestudio.domain.service.UnidadAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UnidadAcademicaRest.UNIDAD_ACADEMICA)
public class UnidadAcademicaRest {
    public static final String UNIDAD_ACADEMICA = "/unidadAcademica";

    private final UnidadAcademicaService service;

    @Autowired
    public UnidadAcademicaRest(UnidadAcademicaService service) {
        this.service = service;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<UnidadAcademica> getUnidadAcademicaByCodigo(@PathVariable String codigo) {
        return new ResponseEntity<>(service.getUnidadAcademicaByCodigo(codigo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UnidadAcademica>> getUnidadesAcademicas() {
        return new ResponseEntity<>(service.getUnidadesAcademicas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UnidadAcademica> saveUnidadAcademica(@RequestBody UnidadAcademica unidadAcademica) {
        return new ResponseEntity<>(service.saveUnidadAcademica(unidadAcademica), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UnidadAcademica> updateUnidadAcademica(@RequestBody UnidadAcademica unidadAcademica) {
        return new ResponseEntity<>(service.updateUnidadAcademica(unidadAcademica), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Mensaje> deleteUnidadAcademicaByCodigo(@PathVariable String codigo) {
        return new ResponseEntity<>(new Mensaje( "001", "Unidad academica eliminada"), HttpStatus.OK);
    }
}
