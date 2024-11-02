package br.edu.ifpi.supermarket.services;

import br.edu.ifpi.supermarket.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    private List<User> users;

    public EmailService() {
        this.users = new ArrayList<>();
        // Adicione emails simulados
        users.add(new User("usuario1@exemplo.com"));
        users.add(new User("usuario2@exemplo.com"));
    }

    public boolean isEmailRegistered(String email) {
        // Verifica se o email existe na lista de usuários
        return users.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
