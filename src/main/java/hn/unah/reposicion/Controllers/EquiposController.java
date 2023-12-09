package hn.unah.reposicion.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.reposicion.Models.Equipos;
import hn.unah.reposicion.Services.Impl.EquiposServicesImpl;

@RestController
@RequestMapping("/equipos")
public class EquiposController {
    
    @Autowired
    private EquiposServicesImpl equiposServicesImpl;

    @PostMapping("/crear")
    public Equipos crear(@RequestBody Equipos equipos){
        return this.equiposServicesImpl.crear(equipos);
    }

    @DeleteMapping("/eliminar")
    public String eliminar(@RequestParam(name="codigoEquipo") int codigoEquipo){
        return this.equiposServicesImpl.eliminar(codigoEquipo);
    }

    @GetMapping("/buscar")
    public Equipos buscar(@RequestParam(name="codigoEquipo") int codigoEquipo){
        return this.equiposServicesImpl.buscar(codigoEquipo);
    }
}
