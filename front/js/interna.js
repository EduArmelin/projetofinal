function validaLogin() {
    let userTxt=localStorage.getItem("userLoged");
    if (!userTxt) {
        //forçando ir para a pagina principal se não estiver logado.
        window.location = "index.html";
    }
    let user = JSON.parse(userTxt);
    //document.getElementById("fotoUser").innerHTML = "<img src= \"" +user.linkFoto+"\">";
    document.getElementById("fotoUser").innerHTML = `<img src= "${user.linkFoto}">`
    document.getElementById("dadosUser").innerHTML = `Usuário: <b>${user.nome}</b><br>RACF: <b>${user.racf}</b> <br>`
}
function logout() {
    localStorage.removeItem("userLoged");
    window.location = "index.html";
}
function buscarUsuarios(){
    fetch("http://localhost:8080/user/all")
        .then(res=> tratarRetorno(res));
}
function tratarRetorno(retorno){
    if (retorno.status == 200) {
        retorno.json().then(res => exibirUsuarios(res));
    }else{
        document.getElementById("usuarios").innerHTML="Nenhum usuário cadastrado.";
    }
}
function exibirUsuarios(lista){
    let tabela = `<table class="table" table-sm><tr><th>Nome</th><th>E-mail</th></tr>`;
    for (i=0;i< lista.length;i++){
        tabela += `<tr><td>${lista[i].name}</td><td>${lista[i].email}</td></tr>`
    }    
    tabela += `</table>`;
    document.getElementById("usuarios").innerHTML=tabela;
}