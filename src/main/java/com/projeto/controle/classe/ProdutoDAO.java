package com.projeto.controle.classe;

import javax.persistence.*;
import java.util.List;

/**
 * Classe DAO (Data Access Object) responsável por realizar as operações de persistência
 * de objetos Produto em um banco de dados utilizando JPA.
 *
 * @author [Felipe Bonfim Pontes]
 * @since [01/12/2024]
 */
public class ProdutoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlePD");
    private EntityManager em = emf.createEntityManager();

    /**
     * Salva um novo produto no banco de dados.
     *
     * @param produto O objeto Produto a ser persistido.
     */
    public void salvar(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    /**
     * Atualiza um produto existente no banco de dados.
     *
     * @param produto O objeto Produto com as informações atualizadas.
     */
    public void atualizar(Produto produto) {
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }

    /**
     * Remove um produto do banco de dados pelo seu ID.
     *
     * @param id O identificador único do produto a ser removido.
     */
    public void deletar(Long id) {
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        } else {
            // Adicionar um log ou lançar uma exceção para indicar que o produto não foi encontrado
            System.out.println("Produto não encontrado para o ID: " + id);
        }
    }

    /**
     * Retorna uma lista com todos os produtos cadastrados.
     *
     * @return Uma lista de objetos Produto.
     */
    public List<Produto> listarProdutos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id O identificador único do produto.
     * @return O objeto Produto encontrado, ou null caso não seja encontrado.
     */
    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    /**
     * Fecha o EntityManager e o EntityManagerFactory para liberar os recursos.
     * Deve ser chamado ao final da aplicação.
     */
    public void fechar() {
        em.close();
        emf.close();
    }
}