package hn.unah.reposicion.Services.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.reposicion.Models.Equipos;
import hn.unah.reposicion.Models.Posiciones;
import hn.unah.reposicion.Repositories.EquiposRepository;
import hn.unah.reposicion.Repositories.PosicionesRepository;
import hn.unah.reposicion.Services.PosicionesService;

@Service
public class PosicionesServiceImpl implements PosicionesService{

    @Autowired
    private PosicionesRepository posicionesRepository;

    @Autowired
    private EquiposRepository equiposRepository;

    @Override
    public List<Posiciones> obtenerTodas() {
        return this.posicionesRepository.findAll();
    }

    @Override
    public Posiciones simulacion() {
        Random random = new Random();
        List<Equipos> todosEquipos = this.equiposRepository.findAll();
        int cantidadEquipos = todosEquipos.size();
        Equipos nuevoEquipo = new Equipos();
        if(cantidadEquipos<6){
            while(this.equiposRepository.findAll().size()<6){
                nuevoEquipo.setAtaque(random.nextInt(10) + 1);
                nuevoEquipo.setDefensa(random.nextInt(10) + 1);
                nuevoEquipo.setNombre("Equipo "+ (String.valueOf(random.nextInt(100) + 1)));
                this.equiposRepository.save(nuevoEquipo);
                break;
            }

        }
        Posiciones posicion = new Posiciones();
        // equipo 1 vs equipo 2
        posicion.setCodigoEquipo(nuevoEquipo.getCodigoEquipo());
        posicion.setGolesContra(random.nextInt(5) + 1);
        posicion.setGolesFavor(random.nextInt(5) + 1);
        posicion.setEmpates(random.nextInt(6)+1);
        posicion.setGanados(random.nextInt(6)+1);
        posicion.setPerdidos(random.nextInt(6)+1);
        posicion.setPuntos((posicion.getGanados()*3)+posicion.getEmpates());

        return this.posicionesRepository.save(posicion);
    }

    
}
