package br.univates;

/*
 * Exercício 6 - Estatísticas de uma sequência de números
 *
 * Enunciado:
 * Pergunte ao usuário quantos números ele deseja informar (N).
 * Em seguida, leia os N números inteiros utilizando a classe Entrada.
 * Ao final, exiba:
 *   - a soma de todos os números;
 *   - a média dos valores informados;
 *   - o maior e o menor número digitado.
 */
public class Exercicio6 {

    public static void main(String[] args) {
        int quantidade = Entrada.leiaInt("Quantos números você deseja informar?");

        // Garante que pelo menos um número seja lido
        while (quantidade < 1) {
            quantidade = Entrada.leiaInt("Valor inválido. Informe uma quantidade maior que zero:");
        }

        int soma = 0;
        int maior = 0;
        int menor = 0;

        for (int i = 1; i <= quantidade; i++) {
            int numero = Entrada.leiaInt("Digite o número " + i + " de " + quantidade + ":");

            soma = soma + numero;

            // No primeiro número, ele é ao mesmo tempo o maior e o menor
            if (i == 1) {
                maior = numero;
                menor = numero;
            } else {
                if (numero > maior) {
                    maior = numero;
                }
                if (numero < menor) {
                    menor = numero;
                }
            }
        }

        double media = (double) soma / quantidade;

        System.out.println("Soma: " + soma);
        System.out.println("Média: " + media);
        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
    }
}
