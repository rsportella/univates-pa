package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 3: Buscando produtos pelo nome digitado pelo usuário.
 * Usa ILIKE (case-insensitive) com PreparedStatement.
 */
public class BuscarProduto {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/loja_avancada";
        String usuario = "postgres";
        String senha = "minhaSenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String termo = Entrada.leiaString("Buscar produto por nome:");

            String sql = "SELECT nome, preco FROM produto WHERE nome ILIKE ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, "%" + termo + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nome") + " - R$ " + rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
