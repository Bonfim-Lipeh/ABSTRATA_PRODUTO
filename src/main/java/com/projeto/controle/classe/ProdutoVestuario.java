package com.projeto.controle.classe;

import javax.persistence.*;

/**
 * Representa um produto de vestuário, que é um tipo específico de produto.
 * Herda da classe `Produto` e adiciona atributos específicos para vestuário.
 */
@Entity
public class ProdutoVestuario extends Produto {

    /**
     * Tamanho do produto de vestuário.
     */
    private String tamanho;

    /**
     * Cor do produto de vestuário.
     */
    private String cor;

    /**
     * Material do produto de vestuário.
     */
    private String material;

    /**
     * Construtor padrão.
     */
    public ProdutoVestuario() {}

    /**
     * Construtor parametrizado para inicializar todos os atributos.
     *
     * @param nome Nome do produto.
     * @param precoCusto Preço de custo do produto.
     * @param precoVenda Preço de venda do produto.
     * @param tamanho Tamanho do produto de vestuário.
     * @param cor Cor do produto de vestuário.
     * @param material Material do produto de vestuário.
     */
    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda); // Chama o construtor da classe pai
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    // Getters e setters para os atributos específicos da classe ProdutoVestuario

    /**
     * Obtém o tamanho do produto de vestuário.
     *
     * @return O tamanho do produto.
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho do produto de vestuário.
     *
     * @param tamanho O novo tamanho do produto.
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Obtém a cor do produto de vestuário.
     *
     * @return A cor do produto.
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor do produto de vestuário.
     *
     * @param cor A nova cor do produto.
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Obtém o material do produto de vestuário.
     *
     * @return O material do produto.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Define o material do produto de vestuário.
     *
     * @param material O novo material do produto.
     */
    public void setMaterial(String material) {
        this.material = material;
    }
}