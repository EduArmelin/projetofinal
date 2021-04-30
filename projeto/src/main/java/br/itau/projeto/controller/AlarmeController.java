package br.itau.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.projeto.model.AlarmeModel;
import br.itau.projeto.repository.AlarmeRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/alarm")
public class AlarmeController {
    @Autowired
    private AlarmeRepo repo;

    @GetMapping("/id/{id}") // -> http://localhost:8080/alarm/id/XX
    public ResponseEntity<AlarmeModel> getEvent(@PathVariable int id){
        AlarmeModel alarmeEncontrado = repo.findById(id).orElse(null); //busca pela chave primaria
        //EventModel eventoEncontrado = repo.findByNumSeq(id).orElse(null); //busca pela chave primaria

        if (alarmeEncontrado != null) {
            return ResponseEntity.ok(alarmeEncontrado);      //status 200 - ok  
        }else {
            return ResponseEntity.notFound().build(); //status 400 - not found
        }
    }

    @GetMapping("/all") // -> http://localhost:8080/alarm/all
    public ResponseEntity<List<AlarmeModel>> getAllAlarmes(){
        List<AlarmeModel> lista = (List<AlarmeModel>) repo.findAll();
        if (lista != null) {
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
