function obterDados(event) {
    event.preventDefault();
    let txtUser = document.getElementById("txtUser").value
    let txtPassword = document.getElementById("txtPassword").value

    let usuario = {
        email: txtUser,
        racf: txtUser,
        senha: txtPassword
    }

    let msg = {
        method: 'POST',
        body: JSON.stringify(usuario),
        headers: {
            'Content-type':'application/json'
        }
    }

    fetch("http://localhost:8080/user/login", msg)
    .then(resp => tratarResposta(resp))

}

function tratarResposta(resposta){
    if(resposta.status == 200) {
        resposta.json().then(res => fazerLogin(res));
    } else {
        document.getElementById("msgError").innerHTML = "Usuário/Senha inválido"
    }
} 

function fazerLogin(user) {
    localStorage.setItem("userLoged", JSON.stringify(user));   
    window.location = "interna.html"
}