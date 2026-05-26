const formulario = document.querySelector("form");

const nome = document.querySelector(".nome");
const email = document.querySelector(".email");
const senha = document.querySelector(".senha");

const btn_cadastrar = document.querySelector(".btn_cadastrar");

function cadastrar(data){
    fetch("http://localhost:8080/usuarios", {
        headers: {
            'Content-Type': 'application/json'
        }, 
        method: 'POST',
        body: JSON.stringify(data)
    })
    .then(res => res.json())
    .then(data=> console.log(data))
    .catch(function(res) {console.log(res)})
}

function limpar(){
    nome.value = '';
    email.value = '';
    senha.value = '';
}

formulario.addEventListener("submit", function(event){
    event.preventDefault();

    const dados ={
        nome: nome.value,
        email: email.value,
        senha: senha.value
    }
    cadastrar(dados);
    limpar();
})

