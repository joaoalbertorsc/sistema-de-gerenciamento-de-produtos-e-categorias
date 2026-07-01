package org.ebac.gerenciadorProdutos.repository;

import org.ebac.gerenciadorProdutos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
