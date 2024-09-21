package com.microservice.cadastroproduto.service;

import com.microservice.cadastroproduto.model.entity.Produto;
import com.microservice.cadastroproduto.model.repository.ProdutoRepository;
import com.microservice.cadastroproduto.rest.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado para o ID: " + id));
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto save(Produto produto) {
        validateProduto(produto);
        return repository.save(produto);
    }

    public Produto update(Long id, Produto produto) {
        Produto existingProduto = findById(id);
        updateProdutoData(existingProduto, produto);
        return repository.save(existingProduto);
    }

    public void delete(Long id) {
        Produto produto = findById(id);
        repository.delete(produto);
    }

    private void updateProdutoData(Produto existingProduto, Produto produto) {
        existingProduto.setNome(produto.getNome());
        existingProduto.setQuantidade(produto.getQuantidade());
        existingProduto.setValor(produto.getValor());
    }

    private void validateProduto(Produto produto) {

        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }

    }
}
