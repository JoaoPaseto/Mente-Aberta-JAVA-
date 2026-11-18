
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

    //MÉTODOS GETTERS E SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}