package br.com.gerenciadordespesas.despesas.services;

import br.com.gerenciadordespesas.despesas.model.Transaction;
import br.com.gerenciadordespesas.despesas.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService () {}

    public Transaction registrerTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public String deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return "Usuário deletado com sucesso";
        } else {
            System.out.println("Tentativa de deletar transação que não foi encontrado com ID: " + id); // Adicione logs se necessário
            return "Transação não encontrado";
        }
    }

    public void updateTransaction(Long id, Transaction transaction) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.save(transaction);
        }
        else {
            System.out.println("Transação não encontrado com o ID:" + id + "!");
        }
    }


    public List<Transaction> findAllTransactions(){
        try {
            return transactionRepository.findAll();
        } catch (Exception e) {
            System.err.println("Erro ao buscar transações: " + e.getMessage());
            return Collections.emptyList();
        }
    }

}
