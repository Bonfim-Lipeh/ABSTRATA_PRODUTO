# Projeto: Controle de Produtos

Este projeto define classes para representar produtos genéricos, produtos alimentícios e produtos de vestuário, além de uma classe de acesso a dados (DAO) para persistir esses produtos em um banco de dados usando JPA (Java Persistence API).

## Classes:

### Produto
A classe base para todos os produtos. Possui atributos comuns como identificador (id), nome, preço de custo e preço de venda.
Inclui o método calcularLucro para calcular a margem de lucro do produto a partir do preço de custo e venda.

ProdutoAlimenticio
Classe filha de Produto que representa produtos alimentícios.
Possui atributos específicos como data de validade e informações nutricionais.

### ProdutoVestuario
Classe filha de Produto que representa produtos de vestuário.
Possui atributos específicos como tamanho, cor e material.
Classe DAO (Data Access Object):

### ProdutoDAO
Esta classe é responsável por realizar operações de persistência em um banco de dados JPA.
Fornece métodos para CRUD (Create, Read, Update, Delete) de produtos.
O método fechar encerra a conexão com o banco de dados.

## Uso:

Para utilizar este projeto, é necessário:

Configurar a conexão com o banco de dados através da unidade de persistência (persistence.xml).
Criar uma instância da classe ProdutoDAO para interagir com os produtos.
Utilizar os métodos CRUD da classe ProdutoDAO para salvar, atualizar, deletar e buscar produtos.
Exemplo:

### Java
// Criar uma instância de ProdutoDAO
ProdutoDAO dao = new ProdutoDAO();

// Criar um produto alimentício
ProdutoAlimenticio alimento = new ProdutoAlimenticio(
    "Arroz", 5.0, 7.50, "10/01/2025", "Fonte de carboidratos"
);

// Salvar o produto no banco de dados
dao.salvar(alimento);

// Buscar um produto pelo id
Produto produtoBuscado = dao.buscarPorId(alimento.getId());

// Fechar a conexão com o banco de dados
dao.fechar();
Use o código com cuidado.

### Considerações:

Este código é um exemplo básico de persistência de dados com JPA.
Dependendo da complexidade do projeto, pode ser necessário implementar funcionalidades adicionais.
É importante seguir boas práticas de desenvolvimento para manter o código limpo e organizado.
Documentação das Classes:

Você também pode encontrar a documentação Javadoc para cada classe dentro do próprio código fonte.

# Autor: [Felipe Bonfim Pontes]
