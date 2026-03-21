package com.as.gerenciamento_livros.controllers;

import com.as.gerenciamento_livros.models.LivroModel;
import com.as.gerenciamento_livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> listar() {
        List<LivroModel> livros = livroService.listar();
        return ResponseEntity.ok().body(livros);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criar(@RequestBody LivroModel livroModel) {
        LivroModel livro = livroService.criar(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(livroModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<LivroModel> buscarId(@PathVariable Long id) {
        return livroService.buscarId(id);
    }

    @PutMapping("/{id}")
    public LivroModel atualizar(@PathVariable Long id, @RequestBody LivroModel livroModel) {
        return livroService.atualizar(id, livroModel);
    }
}
