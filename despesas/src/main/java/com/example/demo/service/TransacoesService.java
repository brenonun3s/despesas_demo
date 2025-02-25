package com.example.demo.service;

import com.example.demo.model.Transacoes;
import com.example.demo.model.Usuario;
import com.example.demo.repository.TransacoesRepository;
import com.example.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransacoesService {


    private final TransacoesRepository transacoesRepository;


    public Transacoes salvar(Transacoes transacoes) {
        return transacoesRepository.save(transacoes);
    }

    public void deletar(UUID id){
        transacoesRepository.findById(id);
        if(transacoesRepository.existsById(id)){
            transacoesRepository.deleteById(id);
            System.out.println("Transação deletado com sucesso");
        }
        else{
            System.out.println("Transação não localizada com esse ID!");
        }

    }


    // TODO: TEM QUE MELHORAR A LÓGICA COM ERRO
    public void atualizar(UUID id, Transacoes transacoes) {
        if(transacoesRepository.existsById(id)){
            transacoes.setTipoTransacao(transacoes.getTipoTransacao());
            transacoes.setNomeTransacao(transacoes.getNomeTransacao());
            transacoes.setValor(transacoes.getValor());
            transacoes.setDescricao(transacoes.getDescricao());
            transacoes.setDataMovimentacao(transacoes.getDataMovimentacao());
            transacoesRepository.save(transacoes);
            System.out.println("Transação atualizado com sucesso");
        }
        else{
            System.out.println("Transação não localizado com esse ID!");
        }
    }


}
