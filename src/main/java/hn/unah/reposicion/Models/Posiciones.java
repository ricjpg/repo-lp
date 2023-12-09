package hn.unah.reposicion.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="posiciones")
public class Posiciones {
    
    // @Id
    // @OneToOne
    // @JoinColumn(name = "codigoequipo")
    // private Equipos equipo;

    @Id
    @Column(name = "codigoequipo")
    private int codigoEquipo;

    @MapsId
    @OneToOne
    @JoinColumn(name = "codigoequipo")
    private Equipos equipo;

    @Column(name = "empates")
    private int empates;
    
    @Column(name = "ganados")
    private int ganados;
    
    @Column(name = "perdidos")
    private int perdidos;
    
    @Column(name = "golesfavor")
    private int golesFavor;
    
    @Column(name = "golescontra")
    private int golesContra;
    
    @Column(name = "puntos")
    private int puntos;
    
    
}