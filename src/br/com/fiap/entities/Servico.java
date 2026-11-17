package br.com.fiap.entities;

public class Servico extends Oportunidade {

    // ATRIBUTOS
    private String instituicao;
    private Endereco endereco;
    private String horarioAtendimento;

    // CONSTRUTOR VAZIO
    public Servico() {
    }

    // CONSTRUTOR COMPLETO
    public Servico(
            int id, String titulo, String descricao,
            String area, String perfilAlvo, String dataLimite,
            String instituicao, Endereco endereco, String horarioAtendimento) {

        super(id, titulo, descricao, area, perfilAlvo, dataLimite);

        this.instituicao = instituicao;
        this.endereco = endereco;
        this.horarioAtendimento = horarioAtendimento;
    }

    // MÉTODOS GETTERS E SETTERS
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }
}
