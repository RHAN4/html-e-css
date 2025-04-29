package com.senai.javaApi.service;

import com.senai.javaApi.model.Usuario;
import com.senai.javaApi.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> ListarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuario ja cadastrado.");
        }
        return usuarioRepository.save(usuario);
    }
}