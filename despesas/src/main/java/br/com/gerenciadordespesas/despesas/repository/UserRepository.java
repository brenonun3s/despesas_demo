package br.com.gerenciadordespesas.despesas.repository;

import br.com.gerenciadordespesas.despesas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}
