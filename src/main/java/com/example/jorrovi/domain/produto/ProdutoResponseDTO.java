package com.example.jorrovi.domain.produto;

public record ProdutoResponseDTO(Long id, String nome, String descricao, Integer preco, Integer qtde) {
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQtde());
    }
}
