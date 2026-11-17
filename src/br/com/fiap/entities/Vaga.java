
package br.com.fiap.entities;
public class Vaga extends Oportunidade {

    // ATRIBUTOS
    private String empresa;
    private String tipoContrato;
    private Double salario;

    // CONSTRUTOR VAZIO
    public Vaga() {}

    // CONSTRUTOR COMPLETO
    public Vaga(int id, String titulo, String descricao,
                String area, String perfilAlvo, String dataLimite,
                String empresa, String tipoContrato, Double salario) {

        super(id, titulo, descricao, area, perfilAlvo, dataLimite);

        this.empresa = empresa;
        this.tipoContrato = tipoContrato;
        this.salario = salario;
    }

    // MÉTODOS GETTERS E SETTERS
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
