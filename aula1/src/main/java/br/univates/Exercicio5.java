package br.univates;

/*
 * Exercício 5 - Confirmação de compra
 *
 * Enunciado:
 * Leia o nome de um produto e o seu preço utilizando a classe Entrada.
 * Depois, pergunte ao usuário (valor booleano) se ele deseja confirmar a
 * compra. Caso confirme, exiba o produto e o preço; caso contrário, exiba
 * uma mensagem informando que a compra foi cancelada.
 */
public class Exercicio5 {

    public static void main(String[] args) {
        String produto = Entrada.leiaString("Qual produto você deseja comprar?");
        double preco = Entrada.leiaDouble("Qual é o preço do produto?");

        boolean confirmar = Entrada.leiaBoolean("Deseja confirmar a compra?");

        if (confirmar) {
            System.out.println("Compra confirmada!");
            System.out.println("Produto: " + produto + " - Preço: R$ " + preco);
        } else {
            System.out.println("Compra cancelada.");
        }
    }
}
