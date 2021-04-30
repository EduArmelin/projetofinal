package br.itau.projeto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.projeto.model.EventModel;
import br.itau.projeto.repository.EventRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventRepo repo;

    @GetMapping("/id/{id}") // -> http://localhost:8080/event/id/XX
    public ResponseEntity<EventModel> getEvent(@PathVariable int id){
        EventModel eventoEncontrado = repo.findById(id).orElse(null); //busca pela chave primaria
        //EventModel eventoEncontrado = repo.findByNumSeq(id).orElse(null); //busca pela chave primaria

        if (eventoEncontrado != null) {
            return ResponseEntity.ok(eventoEncontrado);      //status 200 - ok  
        }else {
            return ResponseEntity.notFound().build(); //status 400 - not found
        }
    }

    @PostMapping("/busca") // -> http://localhost:8080/event/busca
    public ResponseEntity <List<EventModel>> evento(@RequestBody ObjectNode objEvent){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicial = LocalDate.parse(objEvent.get("dataI").asText(),fmt);
        LocalDate dataFim = LocalDate.parse(objEvent.get("dataF").asText(),fmt);
        List<EventModel> listData = repo.findByDataEvtBetweenOrderByDataEvt(dataInicial, dataFim);
        if (listData != null) {
            return ResponseEntity.ok(listData);
        }
        return ResponseEntity.notFound().build();
    }

}
