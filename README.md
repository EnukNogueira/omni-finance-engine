# Omni Finance Engine

Sistema financeiro backend em Java que integra simulação de financiamento imobiliário e gestão de investimentos com cotações de ativos em tempo real.

---

## Sobre o projeto

O Omni Finance Engine nasceu de um trabalho acadêmico na PUCPR (Programação Orientada a Objetos em Java), mas foi expandido além do escopo original. Enquanto a proposta da disciplina pedia apenas um simulador de financiamento imobiliário, o projeto evoluiu para incluir um painel completo de investimentos com consumo de dados reais do mercado financeiro.

O resultado é um sistema de linha de comando que funciona como uma carteira financeira pessoal simulada, cobrindo tanto imóveis quanto renda variável e renda fixa.

---

## Funcionalidades

### Simulador de Financiamento Imobiliário

Calcula parcelas mensais com base no valor do imóvel, prazo e taxa de juros anual. Cada tipo de imóvel aplica regras de negócio próprias via polimorfismo:

- **Casa** — considera a área construída no cálculo
- **Apartamento** — embute taxa de condomínio e registra vagas de garagem
- **Terreno** — aplica acréscimo de 2% por risco de infraestrutura; aceita zoneamento comercial ou residencial

### Painel de Investimentos

- **Ações** — busca a cotação atual de qualquer ativo brasileiro (ex: `PETR4`, `VALE3`) via API em tempo real
- **Renda Fixa** — projeta patrimônio acumulado em CDB ou Tesouro com base em taxa de juros composta e prazo de aplicação

---

## Conceitos de POO aplicados

| Conceito | Aplicação no projeto |
|---|---|
| Classes Abstratas | `Financiamento` como molde para os tipos de imóvel |
| Herança | `Casa`, `Apartamento`, `Terreno`, `Acao`, `RendaFixa` estendem as classes base |
| Polimorfismo | `@Override` em cada subclasse para cálculos específicos |
| Encapsulamento | Atributos `private`/`protected` com getters e setters |
| Packages | Separação de responsabilidades por pacotes (`imoveis`, etc.) |
| Coleções | `ArrayList` para manipulação dinâmica de múltiplos objetos |
| Exceções personalizadas | `ErrosExceptionFinanciamento` valida regras de negócio (ex: impede valor de imóvel negativo ou zero) |
| Integração com API | Chamadas HTTP nativas + Gson para consumo e parsing do JSON de cotações |

---

## Tecnologias utilizadas

- **Java 24**
- **Google Gson** — conversão de JSON da API de cotações
- **IntelliJ IDEA**

---

## Como executar

```bash
# Clone o repositório
git clone https://github.com/EnukNogueira/omni-finance-engine.git
cd omni-finance-engine

# Compile e execute via IntelliJ IDEA ou linha de comando
# Certifique-se de ter o Gson no classpath
javac -cp gson-*.jar src/**/*.java
java -cp .:gson-*.jar Main
```

---

## Estrutura do projeto

```
src/
├── imoveis/
│   ├── Financiamento.java      # Classe abstrata base
│   ├── Casa.java
│   ├── Apartamento.java
│   └── Terreno.java
├── investimentos/
│   ├── Acao.java
│   └── RendaFixa.java
└── Main.java
```

---

## Autor

**Enuk Nogueira** — Desenvolvedor focado em Engenharia de Dados e Automação de Processos

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/enuknogueira/)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/EnukNogueira)
