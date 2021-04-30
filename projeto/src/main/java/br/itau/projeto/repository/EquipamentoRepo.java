package br.itau.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.itau.projeto.model.EquipamentoModel;

public interface EquipamentoRepo extends CrudRepository<EquipamentoModel, Integer> {
    //public EquipamentoModel findByHostname(String hostname);
}
