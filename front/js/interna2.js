function validaLogin() {
    let userTxt=localStorage.getItem("userLoged");
    if (!userTxt) {
        //forçando ir para a pagina principal se não estiver logado.
        window.location = "index.html";
    }
    let user = JSON.parse(userTxt);
}
function buscarRelatorios() {
    //event.preventDefault();
    let txtDataI = document.getElementById("txtDataI").value
    let txtDataF = document.getElementById("txtDataF").value

    let eventos = {
        dataI: txtDataI,
        dataF: txtDataF
    }
    let msg = {
        method: 'POST',
        body: JSON.stringify(eventos),
        headers: {'Content-type':'application/json'}
    }
    fetch("http://localhost:8080/event/busca", msg)
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
    let tabela = `<table class="table" table-sm><tr><th>Data</th><th>Equipamento</th><th>Evento</th></tr>`;
    for (i=0;i< lista.length;i++){
        let dataAtual = new Date(lista[i].dataEvt).toLocaleDateString("pt-BR", { timeZone: 'UTC' })
        tabela += `<tr><td>${dataAtual}</td><td>${lista[i].equipamento.hostname}</td><td>${lista[i].alarme.descricao}</td></tr>`
    }    
    tabela += `</table>`;
    document.getElementById("relatorios").innerHTML=tabela;
}
function logout() {
    localStorage.removeItem("userLoged");
    window.location = "index.html";
}