package hn.unah.reposicion.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.reposicion.Models.Equipos;
import hn.unah.reposicion.Models.Posiciones;

public interface PosicionesRepository extends JpaRepository<Posiciones, Integer>{
    

    public Posiciones findEquiposByCodigoEquipo(int codigoEquipo);
}
