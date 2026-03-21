package com.as.gerenciamento_livros.services;

import com.as.gerenciamento_livros.models.LivroModel;
import com.as.gerenciamento_livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> listar() {
        return livroRepository.findAll();
    }

    public LivroModel criar(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public Optional<LivroModel> buscarId(Long id) {
        return livroRepository.findById(id);
    }

    public LivroModel atualizar(Long id, LivroModel livroModel) {
        LivroModel model = livroRepository.findById(id).get();
        model.setTitulo(livroModel.getTitulo());
        model.setAutor(livroModel.getAutor());
        model.setAnoPublicacao(livroModel.getAnoPublicacao());
        return livroRepository.save(model);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
