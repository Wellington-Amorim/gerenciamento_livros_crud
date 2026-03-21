package com.as.gerenciamento_livros.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_LIVRO")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(name = "nome_autor")
    private String autor;
    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    public LivroModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
