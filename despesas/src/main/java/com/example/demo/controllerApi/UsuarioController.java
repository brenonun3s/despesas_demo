package com.example.demo.controllerApi;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> salvarUsuario(@RequestBody Usuario usuario) {
            usuarioService.salvar(usuario);
            return ResponseEntity.ok("Usuário criado com Sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") String id) {
        usuarioService.deletar(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    // TODO: MELHORAR O METODO
    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        usuarioService.atualizar(UUID.fromString(id), usuario);
        return ResponseEntity.ok().build();
    }

    // TODO: Realizar a lógica desse método
    public void efetuarLogin(){

    }

    // TODO: Realizar a lógica desse método
    public void sair(){

    }
}



