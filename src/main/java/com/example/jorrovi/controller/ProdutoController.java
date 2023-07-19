package com.example.jorrovi.controller;

import com.example.jorrovi.domain.produto.Produto;
import com.example.jorrovi.domain.produto.ProdutoRepository;
import com.example.jorrovi.domain.produto.ProdutoRequestDTO;
import com.example.jorrovi.domain.produto.ProdutoResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProdutoResponseDTO> getAll(){
        List<ProdutoResponseDTO> produtoList = repository.findAll().stream().map(ProdutoResponseDTO::new).toList();
        return produtoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public List<ProdutoResponseDTO> findById(@PathVariable Long id){
        List<ProdutoResponseDTO> produtoList = repository.findById(id).stream().map(ProdutoResponseDTO::new).toList();
        return produtoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduto(@RequestBody @Valid ProdutoRequestDTO data){
        Produto produtoData = new Produto(data);
        repository.save(produtoData);
        return;
    }

   @PutMapping
   @Transactional
    public ResponseEntity updateProduto(@RequestBody @Valid ProdutoRequestDTO data){
         Optional<Produto> optionalProduto = repository.findById(data.id());
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(data.nome());
            produto.setDescricao(data.descricao());
            produto.setPreco(data.preco());
            produto.setQtde(data.qtde());
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduto(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
