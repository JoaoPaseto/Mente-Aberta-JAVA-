package br.com.fiap.entities;

public class Oportunidade {

    // ATRIBUTOS
    private int id;
    private String titulo;
    private String descricao;
    private String area;
    private String perfilAlvo;
    private String dataLimite;

    // CONSTRUTOR VAZIO
    public Oportunidade() {}

    // CONSTRUTOR COMPLETO
    public Oportunidade(int id, String titulo, String descricao,
                        String area, String perfilAlvo,
                        String dataLimite) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.area = area;
        this.perfilAlvo = perfilAlvo;
        this.dataLimite = dataLimite;
    }

    // MÉTODO DE NEGÓCIO - FILTRAR POR ÁREA
    public boolean filtrarPorArea(String areaDesejada) {

        if (areaDesejada == null || areaDesejada.isBlank()) {
            return false;
        }

        String pesquisa = areaDesejada.trim().toLowerCase();

        return getArea() != null &&
                getArea().toLowerCase().contains(pesquisa);
    }

    // MÉTODOS GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPerfilAlvo() {
        return perfilAlvo;
    }

    public void setPerfilAlvo(String perfilAlvo) {
        this.perfilAlvo = perfilAlvo;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }
}
