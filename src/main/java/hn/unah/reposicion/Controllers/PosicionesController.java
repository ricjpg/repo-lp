package hn.unah.reposicion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.reposicion.Models.Posiciones;
import hn.unah.reposicion.Services.Impl.PosicionesServiceImpl;

@RestController
@RequestMapping("/posiciones")
public class PosicionesController {
    
    @Autowired
    private PosicionesServiceImpl posicionesServiceImpl;


    @GetMapping("/todas")
    public List<Posiciones> obtenerTodas(){
        return this.posicionesServiceImpl.obtenerTodas();
    }

    @GetMapping("/simulacion")
    public Posiciones simulacion(){
        return this.posicionesServiceImpl.simulacion();
    }

}
