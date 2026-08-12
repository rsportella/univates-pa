package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 5: Removendo um produto, sempre com confirmação
 * antes de executar o DELETE.
 */
public class RemoverProduto {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/loja_avancada";
        String usuario = "postgres";
        String senha = "minhaSenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            int id = Entrada.leiaInt("ID do produto a remover:");
            boolean confirma = Entrada.leiaBoolean(
                "Tem certeza que deseja remover o produto " + id + "?"
            );

            if (confirma) {
                String sql = "DELETE FROM produto WHERE id = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, id);
                int linhas = pstmt.executeUpdate();
                System.out.println(linhas > 0 ? "Removido." : "Não encontrado.");
            } else {
                System.out.println("Operação cancelada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
