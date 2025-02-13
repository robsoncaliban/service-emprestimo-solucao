# 🌐 Serviço de Análise de Empréstimos

Este repositório contém a implementação de um serviço para determinar quais modalidades de empréstimo um cliente pode obter, com base em critérios como idade, salário e localização. Esta solução foi desenvolvida como resposta ao desafio proposto pela comunidade Backend Brasil.

## ✨ Desafio Original

O problema original está descrito no seguinte repositório:
[Desafio de Empréstimos - Backend Brasil](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md)

## 📚 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Validation** (para validação de entrada de dados)

## ⚖️ Regras de Negócio

O serviço analisa três tipos de empréstimos e decide quais estão disponíveis para um cliente com base nas seguintes regras:

- **Empréstimo Pessoal**
  - Disponível para salários **≤ R$ 3.000**.
  - Disponível para salários entre **R$ 3.000 e R$ 5.000**, se o cliente tiver menos de 30 anos e residir em **SP**.

- **Empréstimo Consignado**
  - Disponível para salários **≥ R$ 5.000**.

- **Empréstimo com Garantia**
  - Disponível para salários **≤ R$ 3.000**.
  - Disponível para salários entre **R$ 3.000 e R$ 5.000**, se o cliente tiver menos de 30 anos e residir em **SP**.

## 📈 Exemplo de Requisição

### Requisição

```json
{
  "nome": "Ana Souza",
  "cpf": "987.654.321-00",
  "idade": 27,
  "salario": 4000.00,
  "localidade": "SP"
}
```

### Resposta

```json
{
    "nomeCliente": "Ana Souza",
    "emprestimos": [
        {
            "tipo": "PESSOAL",
            "taxaJuros": 4
        },
        {
            "tipo": "COM_GARANTIA",
            "taxaJuros": 2
        }
    ]
}
```

## 📈 Arquitetura e Padrão Utilizado

Para manter a flexibilidade e escalabilidade das regras de negócio, utilizei o **padrão Chain of Responsibility**. Esse padrão permite que cada tipo de empréstimo seja validado de forma independente e encadeada, facilitando a adição de novas regras no futuro sem modificar a estrutura principal do sistema.

A estrutura da solução é dividida em:
- **Controllers**: Responsáveis pelo recebimento das requisições HTTP.
- **Services & Handlers**: Contêm a lógica de negócio e a aplicação do Chain of Responsibility.
- **Entities & DTOs**: Definição de objetos para transporte de dados.

## 🔧 Melhorias Futuras
- Implementação de um banco de dados para persistência de histórico.
- Documentação via Swagger.

---

🚀 **Desenvolvido por [Robson Batista](https://github.com/robsoncaliban)**


