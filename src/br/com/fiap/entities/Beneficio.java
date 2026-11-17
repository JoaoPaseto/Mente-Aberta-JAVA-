package br.com.fiap.entities;

public class Beneficio extends Oportunidade {

    // ATRIBUTOS
    private String orgaoResponsavel;
    private String requisitos;
    private String documentosNecessarios;

    // CONSTRUTOR VAZIO
    public Beneficio() {}

    // CONSTRUTOR COMPLETO
    public Beneficio(int id, String titulo, String descricao,
                     String area, String perfilAlvo, String dataLimite,
                     String orgaoResponsavel, String requisitos,
                     String documentosNecessarios) {

        super(id, titulo, descricao, area, perfilAlvo, dataLimite);

        this.orgaoResponsavel = orgaoResponsavel;
        this.requisitos = requisitos;
        this.documentosNecessarios = documentosNecessarios;
    }

    // MÉTODO DE NEGÓCIO - VERIFICAR REQUISITO DE RENDA
    public String verificarRequisito(double renda, double rendaMaxima) {
        if (renda <= rendaMaxima) {return "Atende ao critério informado.";}
        else {return "Não atende ao critério de renda informado.";}
    }

    // MÉTODO DE NEGÓCIO - LISTAR DOCUMENTOS
    public String listarDocumentos() {
        return "Documentos necessários: " + documentosNecessarios;
    }

    // MÉTODOS GETTERS E SETTERS
    public String getOrgaoResponsavel() {
        return orgaoResponsavel;
    }

    public void setOrgaoResponsavel(String orgaoResponsavel) {
        this.orgaoResponsavel = orgaoResponsavel;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getDocumentosNecessarios() {
        return documentosNecessarios;
    }

    public void setDocumentosNecessarios(String documentos) {
        this.documentosNecessarios = documentos;
    }
}
