package org.ebac.gerenciadorProdutos.repository;

import org.ebac.gerenciadorProdutos.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    Page<Produto> findByNome(@Param("nome") String nome, Pageable pageable);

    Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
