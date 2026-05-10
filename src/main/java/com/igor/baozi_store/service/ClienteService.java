package com.igor.baozi_store.service;

import com.igor.baozi_store.dto.ClienteRequest;
import com.igor.baozi_store.model.Cliente;
import com.igor.baozi_store.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public Cliente criar(ClienteRequest request) {
        Cliente cliente = new Cliente(null, request.nome(), request.clienteDesde());
        return repository.save(cliente);
    }

    public Cliente atualizar(Long id, ClienteRequest request) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(request.nome());
        cliente.setClienteDesde(request.clienteDesde());
        return repository.save(cliente);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
