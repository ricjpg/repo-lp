package hn.unah.reposicion.Services;

import java.util.List;

import hn.unah.reposicion.Models.Posiciones;

public interface PosicionesService {
    

    public List<Posiciones> obtenerTodas();

    public Posiciones simulacion();
}
