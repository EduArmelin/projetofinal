function validaLogin() {
    let userTxt=localStorage.getItem("userLoged");
    if (!userTxt) {
        //forçando ir para a pagina principal se não estiver logado.
        window.location = "index.html";
    }
    let user = JSON.parse(userTxt);
}
function buscarAlertas() {
    //event.preventDefault();
    fetch("http://localhost:8080/alarm/all")
    .then(resp => tratarRetorno(resp))
}
function tratarRetorno(retorno){
    console.log("retorno")
    if (retorno.status == 200) {
        retorno.json().then(res => exibirEventos(res));
    }else {
        document.getElementById("msgError").innerHTML="Nenhum evento foi encontrado.";
    }
}
function exibirEventos(lista){
    console.log(lista)
    let tabela = `<table class="table" table-sm><tr><th>Alerta</th><th>Descrição</th></tr>`;
    for (i=0;i< lista.length;i++){
        tabela += `<tr><td>${lista[i].nome}</td><td>${lista[i].descricao}</td></tr>`
    }    
    tabela += `</table>`;
    document.getElementById("alertas").innerHTML=tabela;
}
function logout() {
    localStorage.removeItem("userLoged");
    window.location = "index.html";
}