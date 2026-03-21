package com.as.gerenciamento_livros.repositories;

import com.as.gerenciamento_livros.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
