package br.univates;

/*
 * Exercício 4 - Par ou ímpar
 *
 * Enunciado:
 * Leia um número inteiro informado pelo usuário utilizando a classe Entrada
 * e informe na tela se esse número é par ou ímpar.
 */
public class Exercicio4 {

    public static void main(String[] args) {
        int numero = Entrada.leiaInt("Digite um número inteiro:");

        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é PAR.");
        } else {
            System.out.println("O número " + numero + " é ÍMPAR.");
        }
    }
}
