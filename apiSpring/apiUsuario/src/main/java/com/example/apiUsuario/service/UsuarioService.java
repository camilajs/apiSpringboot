package com.example.apiUsuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.apiUsuario.entity.Usuario;
import com.example.apiUsuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    private BCryptPasswordEncoder pwdEncoder;

    public UsuarioService(){
        this.pwdEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> buscarTodos(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id){
        Usuario u = repository.findById(id)
            .orElseThrow(() -> 
                new IllegalArgumentException("O usuário nao foi encontrado."));
        return u;
    }

    public Usuario salvar(Usuario usuario){
        if(usuario.getEmail() == null || usuario.getSenha() == null)
            throw new IllegalArgumentException("Os campos devem ser preenchidos.");

        String encoder = this.pwdEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);

        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Usuario u = buscarPorId(id);
        if(usuario.getEmail() != null)
            u.setEmail(usuario.getEmail());
        if(usuario.getSenha() != null){
            String encoder = this.pwdEncoder.encode(usuario.getSenha());
            u.setSenha(encoder);
        }
        return repository.save(u);
    }

    public void deletar(Long id){
        Usuario u = buscarPorId(id);
        if(u == null)
            throw new IllegalArgumentException("Usuário não encontrado");

        repository.delete(u);
    }


}
