# so-atv3-ex3

## Sobre o projeto

Exercício 3 da 3ª lista de exercícios da disciplina Sistemas Operacionais I ministrada pelo profº Leandro Colevati

Consiste numa pequena aplicação que usa Threads e Semaphores. A aplicação realiza as seguintes ações:
* cria uma subclasse de Thread chamada ThreadConta;
* simula um caixa eletronico, permitindo que cada conta (ThreadConta) possa realizar saques ou depósitos;
* utiliza dois Semaphores para fazer as seguintes restrições:
    * o caixa pode fazer até duas transações ao mesmo tempo;
    * as transações devem ser de tipos diferentes (não podem ser dois saques ou depósitos ao mesmo tempo);
