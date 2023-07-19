package com.example.jorrovi.domain.produto;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "produtos")
@Entity(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Integer preco;
    private Integer qtde;
    public Produto(ProdutoRequestDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.preco = data.preco();
        this.qtde = data.qtde();
    }
}
