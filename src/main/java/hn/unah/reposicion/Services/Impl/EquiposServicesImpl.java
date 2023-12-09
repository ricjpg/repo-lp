package hn.unah.reposicion.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.reposicion.Models.Equipos;
import hn.unah.reposicion.Models.Posiciones;
import hn.unah.reposicion.Repositories.EquiposRepository;
import hn.unah.reposicion.Repositories.PosicionesRepository;
import hn.unah.reposicion.Services.EquiposServices;

@Service
public class EquiposServicesImpl implements EquiposServices {

    @Autowired
    private EquiposRepository equiposRepository;

    @Autowired
    private PosicionesRepository posicionesRepository;

    @Override
    public Equipos crear(Equipos equipos) {
        return this.equiposRepository.save(equipos);
    }

    @Override
    public String eliminar(int codigoEquipo) {
        Posiciones posicion = this.posicionesRepository.findEquiposByCodigoEquipo(codigoEquipo);
        Equipos equipo = this.equiposRepository.findById(codigoEquipo).get();
        if(posicion != null){
            return "no se puede eliminar porque está creado un registro en la tabla de posiciones";
        }else{
            this.equiposRepository.delete(equipo);
            return "se ha eliminado el equipo con id: "+ codigoEquipo;
        }
        
    }

    @Override
    public Equipos buscar(int codigoEquipo) {
        return this.equiposRepository.findById(codigoEquipo).get();
    }
    
}
