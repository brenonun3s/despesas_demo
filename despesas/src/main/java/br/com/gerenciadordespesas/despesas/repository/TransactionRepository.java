package br.com.gerenciadordespesas.despesas.repository;

import br.com.gerenciadordespesas.despesas.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findById(long id);

    Transaction findByNameTransaction(String nameTransaction);

}
