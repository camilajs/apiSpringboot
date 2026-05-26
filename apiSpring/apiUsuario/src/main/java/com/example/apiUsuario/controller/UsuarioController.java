package com.example.apiUsuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiUsuario.entity.Usuario;
import com.example.apiUsuario.service.UsuarioService;

@CrossOrigin("*")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/nome")
    public String texto(){
        return "Camila";
    }

    @GetMapping("/usuarios")
    public List<Usuario> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping("/usuarios")
    public Usuario inserirUsuario(@RequestBody Usuario usuario){
        return service.salvar(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletarUsuario(@PathVariable Long id){
        service.deletar(id);
    }

}
