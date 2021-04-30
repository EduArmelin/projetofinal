package br.itau.projeto.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.projeto.model.EventModel;

public interface EventRepo extends CrudRepository<EventModel, Integer> {
    //findByStartDateBetween
    public List<EventModel> findByDataEvtBetweenOrderByDataEvt (LocalDate dataInicio, LocalDate dataFim);
}
