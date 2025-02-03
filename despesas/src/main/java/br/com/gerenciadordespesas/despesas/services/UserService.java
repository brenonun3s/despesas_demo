package br.com.gerenciadordespesas.despesas.services;

import br.com.gerenciadordespesas.despesas.model.User;
import br.com.gerenciadordespesas.despesas.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Modifying
    public User registerUser(User user) {
        userRepository.save(user);
        return user;
    }


    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            System.out.println("Usuário deletado com sucesso com ID: " + id);
            return "Usuário deletado com sucesso";
        } else {
            System.out.println("Tentativa de deletar usuário que não foi encontrado com ID: " + id); // Adicione logs se necessário
            return "Usuário não encontrado";
        }
    }


    public void updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            userRepository.save(user);
        } else {
            System.out.println("Usuário não encontrado com o ID:" + id + "!");
        }
    }
}


