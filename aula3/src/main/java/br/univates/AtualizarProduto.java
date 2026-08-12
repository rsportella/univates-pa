package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 4: Atualizando o preço de um produto existente.
 * Confere o retorno de executeUpdate() para saber se o ID existia.
 */
public class AtualizarProduto {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/loja_avancada";
        String usuario = "postgres";
        String senha = "minhaSenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            int id = Entrada.leiaInt("ID do produto:");
            double novoPreco = Entrada.leiaDouble("Novo preço:");

            String sql = "UPDATE produto SET preco = ? WHERE id = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setDouble(1, novoPreco);
            pstmt.setInt(2, id);

            int linhas = pstmt.executeUpdate();
            if (linhas == 0) {
                System.out.println("Produto não encontrado.");
            } else {
                System.out.println("Produto atualizado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
