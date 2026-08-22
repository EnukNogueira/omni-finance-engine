# Omni Finance Engine

Sistema financeiro desenvolvido em Java para praticar Programação Orientada a Objetos, regras de negócio, tratamento de exceções e integração com APIs.

O projeto começou como um trabalho acadêmico de POO na PUCPR e foi expandido para incluir simulação de financiamentos e consultas de cotações de ativos.

---

## Sobre o projeto

O sistema possui dois módulos principais:

- Simulação de financiamento imobiliário
- Consulta e simulação de investimentos

A parte de financiamento possui diferentes tipos de imóveis, cada um com suas próprias regras de cálculo.

O módulo de investimentos permite consultar cotações de ações através de uma API externa e realizar projeções de renda fixa utilizando juros compostos.

---

## Funcionalidades

### Financiamento imobiliário

- Simulação de financiamento
- Cálculo de parcelas
- Diferentes regras para cada tipo de imóvel
- Validação dos dados de entrada

Tipos disponíveis:

- Casa
- Apartamento
- Terreno

### Investimentos

- Consulta de cotação de ações
- Integração com API externa
- Leitura e conversão de dados JSON
- Projeção de investimentos em renda fixa
- Cálculo utilizando juros compostos

---

## Conceitos de Java aplicados

- [x] Programação Orientada a Objetos
- [x] Classes e objetos
- [x] Classes abstratas
- [x] Herança
- [x] Polimorfismo
- [x] Encapsulamento
- [x] Sobrescrita de métodos
- [x] Coleções com `ArrayList`
- [x] Tratamento de exceções
- [x] Exceções personalizadas
- [x] Organização em packages
- [x] Consumo de API
- [x] Manipulação de JSON

---

## Estrutura do projeto

- `src/imoveis/` — classes relacionadas aos financiamentos
- `src/investimentos/` — classes relacionadas aos investimentos
- `src/Main.java` — execução principal da aplicação

Principais classes:

- `Financiamento.java`
- `Casa.java`
- `Apartamento.java`
- `Terreno.java`
- `Acao.java`
- `RendaFixa.java`

---

## Tecnologias utilizadas

- **Java 24**
- **Google Gson** — conversão dos dados JSON
- **API de cotações** — obtenção de informações de ativos
- **IntelliJ IDEA** — desenvolvimento

---

## Como executar

Clone o repositório:

```bash
git clone https://github.com/EnukNogueira/omni-finance-engine.git
cd omni-finance-engine
```

Abra o projeto no IntelliJ IDEA e configure a biblioteca Gson utilizada pelo projeto.

Depois, execute a classe `Main`.

---

## Objetivo do projeto

O objetivo principal foi colocar em prática os conceitos de Programação Orientada a Objetos estudados durante a graduação e expandir o projeto além do exercício inicial proposto.

O projeto também serviu para praticar integração entre uma aplicação Java e uma API externa.

---

## Autor

**Enuk Nogueira**

Estudante de Big Data e Inteligência Analítica pela PUCPR, com foco em Análise de Dados e Ciência de Dados.

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/enuknogueira/)

[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/EnukNogueira)
