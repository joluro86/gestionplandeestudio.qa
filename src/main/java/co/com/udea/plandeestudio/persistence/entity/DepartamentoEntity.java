package co.com.udea.plandeestudio.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_departamento", unique = true)
    private Integer codigoDepartamento;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    @OneToOne
    private PersonaEntity decano;
    @ManyToOne
    @JoinColumn(name = "unidad_academica")
    private UnidadAcademicaEntity unidadAcademica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Integer codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonaEntity getDecano() {
        return decano;
    }

    public void setDecano(PersonaEntity decano) {
        this.decano = decano;
    }

    public UnidadAcademicaEntity getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademicaEntity unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
}
