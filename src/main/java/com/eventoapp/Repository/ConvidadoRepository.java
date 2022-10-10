package com.eventoapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.Models.Convidado;
import com.eventoapp.Models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);

}
