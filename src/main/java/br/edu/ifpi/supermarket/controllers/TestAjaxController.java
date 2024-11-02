package br.edu.ifpi.supermarket.controllers;

import br.edu.ifpi.supermarket.models.User;
import br.edu.ifpi.supermarket.services.EmailService; // Certifique-se de que este serviço está disponível
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class TestAjaxController {

    private List<User> users;
    private final EmailService emailService;

    public TestAjaxController(EmailService emailService) {
        this.users = new ArrayList<>();
        this.emailService = emailService;
    }

    @GetMapping("/exemplo")
    public String exemploAjax() {
        return "exemploAjax";
    }

    @GetMapping("/exemploHTMX")
    public String exemploAjaxHTMX() {
        return "exemploAjaxHTMX";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, @RequestParam String email, Model model) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        users.add(user);
        model.addAttribute("users", users);
        return "fragments/clienteInfo :: informacoes";
    }

    @GetMapping("/check-email")
    @ResponseBody
    public String checkEmailAvailability(@RequestParam("email") String email) {
        boolean emailExists = emailService.isEmailRegistered(email);
        return emailExists ? "<p>Email já cadastrado!</p>" : "<p>Email disponível!</p>";
    }
}
