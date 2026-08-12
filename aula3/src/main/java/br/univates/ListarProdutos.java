package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 3: Listando todos os produtos do banco.
 * executeQuery + while(rs.next()) para percorrer o ResultSet.
 */
public class ListarProdutos {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/loja_avancada";
        String usuario = "postgres";
        String senha = "minhaSenha";

        String sql = "SELECT nome, preco FROM produto";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                System.out.println(nome + " - R$ " + preco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
