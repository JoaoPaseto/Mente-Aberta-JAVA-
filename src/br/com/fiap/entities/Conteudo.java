
package br.com.fiap.entities;

public class Conteudo {

    // ATRIBUTOS
    private String titulo;
    private String tema;
    private String descricao;

    // CONSTRUTOR COMPLETO
    public Conteudo(String titulo, String tema, String descricao) {
        this.titulo = titulo;
        this.tema = tema;
        this.descricao = descricao;
    }

    // MÉTODOS GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public String getDescricao() {
        return descricao;
    }
}
