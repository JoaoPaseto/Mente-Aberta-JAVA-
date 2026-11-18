
package br.com.fiap.entities;

public class Usuario {

    // ATRIBUTOS
    private String nome;
    private String email;
    private String cpf;

    // CONSTRUTOR VAZIO
    public Usuario() {
    }

    // CONSTRUTOR COMPLETO
    public Usuario(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    // MÉTODOS GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
