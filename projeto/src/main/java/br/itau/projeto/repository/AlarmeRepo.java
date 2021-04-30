package br.itau.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.itau.projeto.model.AlarmeModel;

public interface AlarmeRepo extends CrudRepository<AlarmeModel, Integer> {
    
}
