package br.univates;

/*
 * Exercício 7 - Caixa eletrônico (saque com cédulas)
 *
 * Enunciado:
 * Leia um valor inteiro de saque informado pelo usuário utilizando a classe
 * Entrada. Calcule e exiba a menor quantidade possível de cédulas para
 * compor esse valor, considerando as cédulas de 100, 50, 20, 10, 5, 2 e 1.
 * Ao final, pergunte (valor booleano) se o usuário deseja realizar um novo
 * saque; enquanto a resposta for verdadeira, o programa deve se repetir.
 */
public class Exercicio7 {

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            int valor = Entrada.leiaInt("Digite o valor do saque (somente inteiros):");

            while (valor <= 0) {
                valor = Entrada.leiaInt("Valor inválido. Digite um valor maior que zero:");
            }

            int[] cedulas = {100, 50, 20, 10, 5, 2, 1};
            int restante = valor;

            System.out.println("Saque de R$ " + valor + ":");

            for (int i = 0; i < cedulas.length; i++) {
                int quantidade = restante / cedulas[i];
                restante = restante % cedulas[i];

                if (quantidade > 0) {
                    System.out.println("  " + quantidade + " cédula(s) de R$ " + cedulas[i]);
                }
            }

            continuar = Entrada.leiaBoolean("Deseja realizar um novo saque?");
        }

        System.out.println("Operação encerrada. Obrigado!");
    }
}
