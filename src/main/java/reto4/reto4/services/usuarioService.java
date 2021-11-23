package reto4.reto4.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto4.reto4.models.usuario;
import reto4.reto4.repositories.usuarioRepo;

@Service
public class usuarioService {
    @Autowired
    usuarioRepo uRepo;

    public ArrayList<usuario> obtenerUsuarios() {
        return (ArrayList<usuario>) uRepo.findAll();
    }

    public usuario guardarUsuario(usuario user) {
        return uRepo.save(user);
    }

    public ArrayList<usuario> obtenerPorEmail(String email) {
        return uRepo.findByEmail(email);
    }

    public boolean retornarUsuario(String email) {
        if (uRepo.findByEmail(email).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
