package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(UUID id){
        usuarioRepository.findById(id);
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            System.out.println("Usuario deletado com sucesso");
        }
        else{
            System.out.println("Usuário não localizado com esse ID!");
        }

    }


    // TEM QUE CONSERTAR ESSA CLASSE -> NÃO ATUALIZA
    public void atualizar(UUID id, Usuario usuario) {
        if(usuarioRepository.existsById(id)){
            usuario.setEmail(usuario.getEmail());
            usuario.setNome(usuario.getNome());
            usuarioRepository.save(usuario);
            System.out.println("Usuario atualizado com sucesso");
        }
        else{
            System.out.println("Usuário não localizado com esse ID!");
        }
    }
}
