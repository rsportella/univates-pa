# Aula 3 — Java + PostgreSQL na prática

Projeto Maven com os exemplos completos usados na Aula 3 de Programação
Avançada. Os slides mostram apenas trechos curtos de cada arquivo — o
código completo e funcional está aqui, seguindo a mesma estrutura do
projeto da aula1 (`package br.univates`).

Todos os exemplos usam a tabela `produto` do banco `loja_avancada`,
criado na aula 2.

## Arquivos (`src/main/java/br/univates/`)

- `Entrada.java` — classe utilitária fornecida para capturar dados do usuário via caixas de diálogo (JOptionPane).
- `CadastrarProduto.java` — Bloco 2: insere um produto pedindo nome e preço.
- `CadastrarVarios.java` — Bloco 2: cadastra vários produtos em loop, com `leiaBoolean` controlando a repetição.
- `ListarProdutos.java` — Bloco 3: lista todos os produtos com `SELECT` + `ResultSet`.
- `BuscarProduto.java` — Bloco 3: busca produtos pelo nome digitado, usando `ILIKE`.
- `AtualizarProduto.java` — Bloco 4: atualiza o preço de um produto pelo ID.
- `RemoverProduto.java` — Bloco 5: remove um produto, sempre com confirmação (`leiaBoolean`) antes do `DELETE`.
- `MenuProdutos.java` — Bloco 6: programa completo, juntando as quatro operações num menu com `switch` e loop.
- `ValidacaoExemplo.java` — Bloco 8: exemplo mínimo de validação de campos com a biblioteca [Apache Commons Validator](https://commons.apache.org/proper/commons-validator/) (`EmailValidator` e `GenericValidator`), útil como referência para o desafio da semana.

## Antes de rodar

1. Ajuste `url`, `usuario` e `senha` em cada arquivo para os dados do seu PostgreSQL local (o driver e a biblioteca de validação já estão no `pom.xml`).
2. Confirme que o banco `loja_avancada` e a tabela `produto` (criados na aula 2) existem.
3. Compile e rode com Maven, por exemplo:

   ```
   mvn compile
   mvn exec:java -Dexec.mainClass=br.univates.CadastrarProduto
   mvn exec:java -Dexec.mainClass=br.univates.MenuProdutos
   ```

   (o `exec.mainClass` no `pom.xml` já aponta para `MenuProdutos` por padrão.)

## Desafio da semana

O desafio (Sistema de Cadastro de Clientes, sobre a tabela `cliente` que já
existe no banco `loja_avancada`) não tem gabarito aqui de propósito — é
para os alunos construírem do zero, reaproveitando os padrões destes
arquivos. Antes de gravar (`cadastrar`/`atualizar`), validem o e-mail e o
nome com o Apache Commons Validator — ver `ValidacaoExemplo.java`.
