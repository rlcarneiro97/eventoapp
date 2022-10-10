package com.eventoapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.Models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
    Evento findByCodigo(long codigo);
}
