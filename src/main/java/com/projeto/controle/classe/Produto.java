package com.projeto.controle.classe;

import javax.persistence.*; // Importa o pacote JPA para persistência de dados

@Entity // Anotação para marcar a classe Produto como uma entidade persistente
@Inheritance(strategy = InheritanceType.JOINED) // Anotação para definir estratégia de herança como JOINED
public class Produto {

  @Id // Anotação para marcar o atributo 'id' como identificador primário
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para geração automática do identificador
  private Long id;

  private String nome; // Nome do produto

  private double precoCusto; // Preço de custo do produto

  private double precoVenda; // Preço de venda do produto

  public Produto() {} // Construtor sem argumentos

  public Produto(String nome, double precoCusto, double precoVenda) {
    this.nome = nome;
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
  } // Construtor com argumentos

  // Método para calcular o lucro (preço de venda - preço de custo)
  public double calcularLucro() {
    return precoVenda - precoCusto;
  }

  // Getters e setters para os atributos da classe
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPrecoCusto() {
    return precoCusto;
  }

  public void setPrecoCusto(double precoCusto) {
    this.precoCusto = precoCusto;
  }

  public double getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(double precoVenda) {
    this.precoVenda = precoVenda;
  }
}
