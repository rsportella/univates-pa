package br.univates;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.GenericValidator;

/**
 * Aula 3 - Bloco 8: exemplo mínimo de validação de campos com a
 * biblioteca Apache Commons Validator (dependência no pom.xml).
 *
 * Mostra como validar um e-mail e um nome ANTES de gravar no banco —
 * útil no desafio da semana (cadastro de clientes), mas também vale
 * para qualquer INSERT/UPDATE que dependa de dados digitados pelo
 * usuário.
 */
public class ValidacaoExemplo {

    public static void main(String[] args) {
        String nome = Entrada.leiaString("Nome do cliente:");
        String email = Entrada.leiaString("E-mail do cliente:");

        if (GenericValidator.isBlankOrNull(nome)) {
            System.out.println("Nome inválido: não pode ficar em branco.");
            return;
        }

        if (!EmailValidator.getInstance().isValid(email)) {
            System.out.println("E-mail inválido: " + email);
            return;
        }

        System.out.println("Nome e e-mail válidos — pode seguir para o INSERT/UPDATE.");
    }
}
