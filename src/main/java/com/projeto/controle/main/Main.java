package com.projeto.controle.main;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.controle.classe.Produto;
import com.projeto.controle.classe.ProdutoAlimenticio;
import com.projeto.controle.classe.ProdutoDAO;
import com.projeto.controle.classe.ProdutoVestuario;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Inicializa o EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlePD");

        // Instancia o DAO
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Exemplo de criação de produtos
        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio(
                "Arroz Integral", 5.00, 8.00, "2025-12-01", "Rico em fibras e vitaminas");
        ProdutoVestuario produtoVestuario = new ProdutoVestuario(
                "Camiseta Estampada", 20.00, 40.00, "M", "Azul", "Algodão");

        // Salva os produtos no banco de dados
        produtoDAO.salvar(produtoAlimenticio);
        produtoDAO.salvar(produtoVestuario);

        System.out.println("Produtos salvos com sucesso!");

        // Lista todos os produtos
        System.out.println("\nProdutos cadastrados:");
        List<Produto> produtos = produtoDAO.listarProdutos();
        for (Produto p : produtos) {
            System.out.println("Produto: " + p.getNome() + ", Preço de Custo: " + p.getPrecoCusto() +
                    ", Preço de Venda: " + p.getPrecoVenda() + ", Lucro: " + p.calcularLucro());
        }

        // Atualiza um produto
        Produto produtoParaAtualizar = produtoDAO.buscarPorId(produtoAlimenticio.getId());
        if (produtoParaAtualizar != null) {
            produtoParaAtualizar.setPrecoVenda(9.00); // Atualiza o preço de venda
            produtoDAO.atualizar(produtoParaAtualizar);
            System.out.println("\nProduto atualizado: " + produtoParaAtualizar.getNome() + ", Novo Preço de Venda: " + produtoParaAtualizar.getPrecoVenda());
        }

        // Deleta um produto
        Produto produtoParaDeletar = produtoDAO.buscarPorId(produtoVestuario.getId());
        if (produtoParaDeletar != null) {
            produtoDAO.deletar(produtoParaDeletar.getId());
            System.out.println("\nProduto deletado: " + produtoParaDeletar.getNome());
        }

        // Exibe todos os produtos restantes
        System.out.println("\nProdutos restantes no banco de dados:");
        produtos = produtoDAO.listarProdutos();
        for (Produto p : produtos) {
            System.out.println("Produto: " + p.getNome());
        }

        // Fecha o EntityManager
        produtoDAO.fechar();
    }
}
