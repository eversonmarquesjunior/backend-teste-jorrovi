package com.example.jorrovi.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequestDTO(
        Long id,
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotNull Integer preco,
        @NotNull Integer qtde) {}
