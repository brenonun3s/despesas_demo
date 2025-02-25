package com.example.demo.service;

import com.example.demo.model.Orcamento;
import com.example.demo.model.Transacoes;
import com.example.demo.repository.OrcamentoRepository;
import com.example.demo.repository.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final TransacoesService transacoesService;
    private final TransacoesRepository transacoesRepository;

    //TODO: MELHORAR CLASSE
    // TODO: <MELHORAR LÓGICA DO CÓDIGO DESSE MÉTODO>
    public void removerDespesa(UUID id) {
        transacoesService.deletar(id);
    }

    // TODO: <MELHORAR LÓGICA DO CÓDIGO DESSE MÉTODO>
    public List<Float> buscarValorTotalGasto(Transacoes transacoes) {
        List<Float> valorGastoTotal = new ArrayList<>();
        List<Transacoes> listaTransacoes = transacoesRepository.findByValorAndTipoTransacao(transacoes.getValor(), transacoes.getTipoTransacao());
        for (Transacoes transacao : listaTransacoes) {
            if (transacao.getTipoTransacao().equals("GASTO")) {
                valorGastoTotal.add(transacao.getValor());

            }
        }
        return valorGastoTotal;
    }

    // TODO: <MELHORAR LÓGICA DO CÓDIGO DESSE MÉTODO>
    public List<Float> buscarValorGanhos(Transacoes transacoes, Orcamento orcamento) {
        List<Float> valorGanhoTotal = new ArrayList<>();
        List<Transacoes> listaTransacoes = transacoesRepository.findByValorAndTipoTransacao(transacoes.getValor(), transacoes.getTipoTransacao());
        for (Transacoes transacao : listaTransacoes) {
            if (transacao.getTipoTransacao().equals("GANHO")) {
                valorGanhoTotal.add(transacao.getValor());
                orcamentoRepository.save(orcamento);

            }
        }
        return valorGanhoTotal;

    }

    // TODO: <PENSAR NA LOGICA DE IMPLEMENTAÇÃO>
    /*public List<Float> calcularValorOrcamento(Orcamento orcamento, Transacoes transacoes) {
        List<Float> valorOrcamento = new ArrayList<>();
        orcamentoRepository.findAll();
        for(Orcamento orcamento : )

     */
}

