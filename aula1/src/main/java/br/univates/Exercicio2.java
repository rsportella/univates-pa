package br.univates;

/*
 * Exercício 2 - Saudação personalizada
 *
 * Enunciado:
 * Leia o nome do usuário e a sua idade utilizando a classe Entrada.
 * Em seguida, exiba uma mensagem de saudação informando o nome e quantos
 * anos a pessoa terá no próximo ano.
 */
public class Exercicio2 {

    public static void main(String[] args) {
        String nome = Entrada.leiaString("Qual é o seu nome?");
        int idade = Entrada.leiaInt("Qual é a sua idade?");

        System.out.println("Olá, " + nome + "!");
        System.out.println("No próximo ano você terá " + (idade + 1) + " anos.");
    }
}
