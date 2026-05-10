package com.igor.baozi_store.dto;

import java.time.LocalDate;

public record ClienteRequest(String nome, LocalDate clienteDesde) {
}
