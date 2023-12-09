package hn.unah.reposicion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="equipos")
public class Equipos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoequipo")
    private int codigoEquipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ataque")
    private double ataque;

    @Column(name = "defensa")
    private double defensa;

    @JsonIgnore
    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Posiciones posicion;
    
}
