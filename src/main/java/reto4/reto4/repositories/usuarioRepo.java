package reto4.reto4.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reto4.reto4.models.usuario;

@Repository
public interface usuarioRepo extends CrudRepository<usuario, Integer> {
    public abstract ArrayList<usuario> findByEmail(String email);
}
