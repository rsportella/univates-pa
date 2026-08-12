package br.univates;

import java.sql.*;

/**
 * Aula 3 - Bloco 6: Menu completo.
 * Junta cadastrar, listar, atualizar e remover num loop com switch,
 * repetindo até o usuário escolher "Sair". Opera sobre a tabela
 * "produto" do banco "loja_avancada" (criado na aula 2).
 */
public class MenuProdutos {

    static final String URL = "jdbc:postgresql://localhost:5432/loja_avancada";
    static final String USUARIO = "postgres";
    static final String SENHA = "minhaSenha";

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Entrada.leiaInt(
                "1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Remover\n5 - Sair"
            );

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: atualizar(); break;
                case 4: remover(); break;
            }
        } while (opcao != 5);
    }

    static void cadastrar() {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
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

    static void listar() {
        String sql = "SELECT nome, preco FROM produto";
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("nome") + " - R$ " + rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void atualizar() {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            int id = Entrada.leiaInt("ID do produto:");
            double novoPreco = Entrada.leiaDouble("Novo preço:");

            String sql = "UPDATE produto SET preco = ? WHERE id = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setDouble(1, novoPreco);
            pstmt.setInt(2, id);

            int linhas = pstmt.executeUpdate();
            System.out.println(linhas == 0 ? "Produto não encontrado." : "Produto atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void remover() {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
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
