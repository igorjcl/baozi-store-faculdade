package com.igor.baozi_store.service;

import com.igor.baozi_store.dto.PedidoRequest;
import com.igor.baozi_store.model.Cliente;
import com.igor.baozi_store.model.Pedido;
import com.igor.baozi_store.model.Produto;
import com.igor.baozi_store.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    public Pedido criar(PedidoRequest request) {
        Cliente cliente = clienteService.buscarPorId(request.clienteId());
        Produto produto = produtoService.buscarPorId(request.produtoId());
        Pedido pedido = new Pedido(null, cliente, produto, request.quantidade());
        return repository.save(pedido);
    }

    public Pedido atualizar(Long id, PedidoRequest request) {
        Pedido pedido = buscarPorId(id);
        pedido.setCliente(clienteService.buscarPorId(request.clienteId()));
        pedido.setProduto(produtoService.buscarPorId(request.produtoId()));
        pedido.setQuantidade(request.quantidade());
        return repository.save(pedido);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
