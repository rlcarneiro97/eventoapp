package com.eventoapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.Models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
    Usuario findByLogin(String login);  
}
