package org.ebac.gerenciadorProdutos.service;

import org.ebac.gerenciadorProdutos.entity.Produto;
import org.ebac.gerenciadorProdutos.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
    }

    @Transactional
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Page<Produto> findAll(int page, int size) {
        return produtoRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Produto> buscarPorNome(String nome, int page, int size, String direction) {
        Sort sort = Sort.by("nome");
        sort = "desc".equalsIgnoreCase(direction) ? sort.descending() : sort.ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return produtoRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }
}
