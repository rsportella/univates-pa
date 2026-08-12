package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 2: Cadastrando vários produtos em loop.
 * Usa leiaBoolean para perguntar, a cada volta, se o usuário quer
 * cadastrar mais um produto na tabela "produto".
 */
public class CadastrarVarios {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/loja_avancada";
        String usuario = "postgres";
        String senha = "minhaSenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            boolean continuar = true;
            while (continuar) {
                String nome = Entrada.leiaString("Nome:");
                double preco = Entrada.leiaDouble("Preço:");

                pstmt.setString(1, nome);
                pstmt.setDouble(2, preco);
                pstmt.executeUpdate();

                continuar = Entrada.leiaBoolean("Cadastrar outro?");
            }
            System.out.println("Cadastro finalizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
