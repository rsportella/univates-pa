package br.univates;

/*
 * Exercício 3 - Média de duas notas
 *
 * Enunciado:
 * Leia duas notas (valores fracionários) de um aluno utilizando a classe
 * Entrada. Calcule e exiba a média aritmética das notas, informando também
 * se o aluno foi aprovado (média maior ou igual a 7,0) ou reprovado.
 */
public class Exercicio3 {

    public static void main(String[] args) {
        double nota1 = Entrada.leiaDouble("Digite a primeira nota:");
        double nota2 = Entrada.leiaDouble("Digite a segunda nota:");

        double media = (nota1 + nota2) / 2;

        System.out.println("Média: " + media);

        if (media >= 7.0) {
            System.out.println("Situação: Aprovado");
        } else {
            System.out.println("Situação: Reprovado");
        }
    }
}
