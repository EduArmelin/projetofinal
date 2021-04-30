package br.itau.projeto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.itau.projeto.model.UserModel;

/*  "interface" - parecido com abstract porém não crio metodo, porém obrigo que quem 
        referenciar essa classe precisa criar estes metodos
    No caso do Abstract consigo fazer o mesmo informanro abstract dentro do metodo.
*/
//CRUD = create, read, update, delete
public interface UserRepo extends CrudRepository<UserModel,Integer> { 
    public UserModel findByEmail(String email);
    public UserModel findByEmailAndSenha(String email,String senha);
    public UserModel findByEmailOrRacf(String email,String racf);



    //minha propria query
    @Query(value = "select * from itmn_usuario where id = ?1", nativeQuery = true)
    public UserModel procuraUsuario(int id2);
}
