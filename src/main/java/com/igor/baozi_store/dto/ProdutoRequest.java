package com.igor.baozi_store.dto;

import java.math.BigDecimal;

public record ProdutoRequest(String nome, BigDecimal preco, Boolean estoque) {
}
