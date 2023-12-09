package hn.unah.reposicion.Services;

import hn.unah.reposicion.Models.Equipos;

public interface EquiposServices {
    
    public Equipos crear(Equipos equipos);

    public String eliminar(int codigoEquipo);

    public Equipos buscar(int codigoEquipo);
    
}
