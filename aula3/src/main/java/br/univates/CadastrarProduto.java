package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 2: Cadastrando dados.
 * Pede nome e preço ao usuário (via Entrada) e insere um produto novo
 * na tabela "produto" do banco "loja_avancada" (criado na aula 2),
 * usando PreparedStatement.
 */
public class CadastrarProduto {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/loja_avancada";
        String usuario = "postgres";
        String senha = "minhaSenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String nome = Entrada.leiaString("Nome do produto:");
            double preco = Entrada.leiaDouble("Preço do produto:");

            String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setDouble(2, preco);
            pstmt.executeUpdate();

            System.out.println("Produto cadastrado: " + nome);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
