package co.com.udea.plandeestudio.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "unidad_academica")
public class UnidadAcademicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String codigo;
    private String nombre;
    @OneToOne
    private PersonaEntity decano;
    private String actaEntidad;
    private String actaConsejoSuperior;
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PersonaEntity getDecano() {
        return decano;
    }

    public void setDecano(PersonaEntity decano) {
        this.decano = decano;
    }

    public String getActaEntidad() {
        return actaEntidad;
    }

    public void setActaEntidad(String actaEntidad) {
        this.actaEntidad = actaEntidad;
    }

    public String getActaConsejoSuperior() {
        return actaConsejoSuperior;
    }

    public void setActaConsejoSuperior(String actaConsejoSuperior) {
        this.actaConsejoSuperior = actaConsejoSuperior;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
