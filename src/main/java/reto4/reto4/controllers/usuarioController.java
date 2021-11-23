package reto4.reto4.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto4.reto4.models.usuario;
import reto4.reto4.services.usuarioService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class usuarioController {
    
    @Autowired
    usuarioService uService;

    /**
     * Este método retorna un ArrayList con todos los usuarios registrados 
     * @return
     */
    @GetMapping("/all")
    public ArrayList<usuario> obteneUsuarios() {
        return uService.obtenerUsuarios();
    }

    /**
     * Este método retorna un objeto de usuarioService, como parámetro se pasa un objeto de usuario "user" 
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public usuario guardarUsuario(@RequestBody usuario user) {
        return uService.guardarUsuario(user);
    }

    /**
     * Este método retorna si el usuario existe, implementa el método retornarUsuario de la clase usuarioService que se encarga de verificar si el objeto que devuelve está vacio 
     * @param email
     * @return
     */
    @GetMapping(path = "/{email}")
    public boolean obtenerPorEmail(@PathVariable("email") String email) {
        boolean ok = uService.retornarUsuario(email);

        if (ok) {
            return true;
        } else {
            return false;
        }
    }
}
