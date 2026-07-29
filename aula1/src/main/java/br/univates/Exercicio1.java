package br.univates;

/*
 * Exercício 1 - Soma de dois números inteiros
 *
 * Enunciado:
 * Leia dois números inteiros informados pelo usuário utilizando a classe
 * Entrada e exiba na tela o resultado da soma entre eles.
 */
public class Exercicio1 {

    public static void main(String[] args) {
        int a = Entrada.leiaInt("Digite o primeiro número inteiro:");
        int b = Entrada.leiaInt("Digite o segundo número inteiro:");

        int soma = a + b;

        System.out.println(a + " + " + b + " = " + soma);
    }
}
