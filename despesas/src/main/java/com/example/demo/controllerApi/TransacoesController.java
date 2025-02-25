package com.example.demo.controllerApi;

import com.example.demo.model.Transacoes;
import com.example.demo.repository.TransacoesRepository;
import com.example.demo.service.OrcamentoService;
import com.example.demo.service.TransacoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransacoesController {

    private final TransacoesService transacoesService;
    private final TransacoesRepository transacoesRepository;
    private final OrcamentoService orcamentoService;

    @PostMapping
    public ResponseEntity<Object> salvarTransacao(@RequestBody Transacoes transacoes) {
            transacoesService.salvar(transacoes);
            return ResponseEntity.ok("Transação criado com Sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") String id) {
        transacoesService.deletar(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    // TODO
    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable("id") String id, @RequestBody Transacoes transacoes) {
        transacoesService.atualizar(UUID.fromString(id), transacoes);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Transacoes>> listarTransacoes(Transacoes transacoes) {
        orcamentoService.buscarValorTotalGasto(transacoes);
        return ResponseEntity.ok(transacoesRepository.findAll());
    }


}



