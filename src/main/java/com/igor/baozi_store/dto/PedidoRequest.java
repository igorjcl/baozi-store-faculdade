package com.igor.baozi_store.dto;

public record PedidoRequest(Long clienteId, Long produtoId, Integer quantidade) {
}
