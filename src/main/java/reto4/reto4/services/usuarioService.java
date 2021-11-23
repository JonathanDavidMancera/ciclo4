package reto4.reto4.services;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<usuario> validarUsuario(String email, String password) {
        return uRepo.findByEmailAndPassword(email, password);
    }

    public usuario autenticarUsuario(String email, String password) {
        Optional<usuario> user = uRepo.findByEmailAndPassword(email, password);

        if (user.isEmpty()) {
            return new usuario(email, password,  "NO DEFINIDO");
        } else {
            return user.get();
        }
    }
}
