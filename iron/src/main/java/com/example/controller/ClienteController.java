package com.example.controller;

import com.example.model.Cliente;
import com.example.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/clientes")

public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", repository.findAll());
        model.addAttribute("novoCliente", new Cliente());
        return "lista-clientes";
    }

    @PostMapping
    public String adicionarCliente(@ModelAttribute Cliente novoCliente) {
        repository.save(novoCliente);
        return "redirect:/clientes";
    }


}
