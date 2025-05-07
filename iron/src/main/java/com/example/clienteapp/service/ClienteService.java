package com.example.clienteapp.service;

import com.example.clienteapp.model.Cliente;
import com.example.clienteapp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void salvar(Cliente cliente) {
        repo.save(cliente);
    }
}
