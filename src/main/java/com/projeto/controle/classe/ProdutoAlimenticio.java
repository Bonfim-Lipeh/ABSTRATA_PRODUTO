package com.projeto.controle.classe;

import javax.persistence.*;

@Entity // Indica que a classe é uma entidade persistente
public class ProdutoAlimenticio extends Produto { // Herda da classe Produto

    private String dataValidade; // Data de validade do produto alimentício
    private String informacoesNutricionais; // Informações nutricionais do produto alimentício

    public ProdutoAlimenticio() {} // Construtor padrão

    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
        super(nome, precoCusto, precoVenda); // Chama o construtor da classe pai
        this.dataValidade = dataValidade;
        this.informacoesNutricionais = informacoesNutricionais;
    }

    // Getters e setters para os atributos específicos da classe ProdutoAlimenticio
    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getInformacoesNutricionais() {
        return informacoesNutricionais;
    }

    public void setInformacoesNutricionais(String informacoesNutricionais) {
        this.informacoesNutricionais = informacoesNutricionais;
    }
}