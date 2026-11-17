package br.com.fiap.entities;

public class Curso extends Oportunidade {

    // ATRIBUTOS
    private int cargaHoraria;
    private String modalidade;
    private boolean gratuito;

    // CONSTRUTOR VAZIO
    public Curso() {}

    // CONSTRUTOR COMPLETO
    public Curso(int id, String titulo, String descricao,
                 String area, String perfilAlvo, String dataLimite,
                 int cargaHoraria, String modalidade, boolean gratuito) {

        super(id, titulo, descricao, area, perfilAlvo, dataLimite);

        this.cargaHoraria = cargaHoraria;
        this.modalidade = modalidade;
        this.gratuito = gratuito;
    }

    // MÉTODOS GETTERS E SETTERS
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    // MÉTODO DE NEGÓCIO - VERIFICAR GRATUIDADE
    public String verificarGratuidade() {
        if (gratuito) {
            return "Este curso é gratuito.";
        } else {
            return "Este curso não é gratuito.";
        }
    }
}
