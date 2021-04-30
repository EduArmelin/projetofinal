package br.itau.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.projeto.model.UserModel;
import br.itau.projeto.repository.UserRepo;


@RestController //indica que é uma clase controller REST
@CrossOrigin("*") //Aceita requisições de qualquer dominio - CorsConfiguration (explorar)
@RequestMapping("/user") //define o caminho http (http://localhost:8080/user)
public class UserController {
    
    @GetMapping("/test") //define o caminho http (http://localhost:8080/user/test)
    public String teste(){
        return "Usuário ASD";
    }
    @Autowired //injeção de dependencia
    private UserRepo repo;

    @GetMapping("/id/{id}")
    //public User getUser(@PathVariable int id){
        //return usuarioEncontrado;
    public ResponseEntity<UserModel> getUser(@PathVariable int id){
        UserModel usuarioEncontrado = repo.findById(id).orElse(null); //busca pela chave primaria

        if (usuarioEncontrado != null) {
            return ResponseEntity.ok(usuarioEncontrado);      //status 200 - ok  
        }else {
            return ResponseEntity.notFound().build(); //status 400 - not found
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUser(){
        List<UserModel> lista = (List<UserModel>) repo.findAll();
        if (lista != null) {
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel userReceived){
        UserModel userFound = repo.findByEmailOrRacf(userReceived.getEmail(), userReceived.getRacf());
        if (userFound != null) {
            if (userFound.getSenha().equals(userReceived.getSenha())) {
                return ResponseEntity.ok(userFound);
            }
        } 
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/id2/{id2}")
    //public User getUser(@PathVariable int id){
        //return usuarioEncontrado;
    public ResponseEntity<UserModel> getUser2(@PathVariable int id2){
        UserModel usuarioEncontrado2 = repo.procuraUsuario(id2); //busca pela chave primaria

        if (usuarioEncontrado2 != null) {
            return ResponseEntity.ok(usuarioEncontrado2);      //status 200 - ok  
        }else {
            return ResponseEntity.notFound().build(); //status 400 - not found
        }
    }

}
