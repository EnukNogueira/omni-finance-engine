# Sistema Bancário Integrado 

Este é o projeto desenvolvido por mim para a disciplina de Programação Orientada a Objetos (Java). A proposta inicial da faculdade pedia um simulador de financiamento imobiliário, mas eu decidi ir além e integrar um pilar completo de gerenciamento de investimentos com consumo de dados reais do mercado de ações.

O projeto une as regras obrigatórias solicitadas ao longo do semestre com funcionalidades avançadas, servindo como uma carteira financeira pessoal simulada.

---

##  Funcionalidades Principais

### 1. Simulador de Financiamento de Imóveis (Escopo da Faculdade)
O sistema calcula o valor da parcela mensal com base no valor do imóvel, prazo (em meses) e taxa de juros anual, aplicando regras de negócio específicas (Polimorfismo) para cada tipo:
* **Casa:** Considera a área construída.
* **Apartamento:** Embuti uma taxa fixa simulando o condomínio e registra vagas de garagem.
* **Terreno:** Aplica uma taxa de acréscimo de 2% baseada no risco de infraestrutura e aceita zoneamento (comercial/residencial).

### 2. Painel de Investimentos (Meu Diferencial)
* **Ações:** O sistema solicita o código do ativo (ex: `PETR4`, `VALE3`) e busca o preço da cotação **em tempo real**.
* **Renda Fixa:** Permite cadastrar títulos (CDB, Tesouro) informando o tempo de aplicação e a taxa de juros compostos anual para projetar o patrimônio acumulado.

---

## Conceitos de OO e Java Aplicados

Para cobrir a grade das atividades formativas e somativas da faculdade, o código foi estruturado usando:
* **Classes Abstratas:** A classe `financiamento` foi definida como abstrata, servindo de molde para as subclasses de imóveis.
* **Herança:** Reutilização de atributos e construtores (`super`) das classes mães para as classes filhas (`Casa`, `Apartamento`, `Terreno`, `acao`, `rendaFixa`).
* **Polimorfismo:** Sobrescrita de métodos (`@Override`) para que cada ativo ou imóvel calcule seus valores de forma única.
* **Encapsulamento:** Uso de modificadores de acesso (`private` e `protected`) e métodos getters/setters.
* **Packages (Pacotes):** Separação organizada das responsabilidades do sistema (como o pacote `imoveis`).
* **Coleções (`ArrayList`):** Manipulação dinâmica de múltiplos objetos na memória RAM.
* **Tratamento de Exceções:** * Captura de erros de digitação (`InputMismatchException`).
  * Criação de uma exceção própria (`ErrosExceptionFinanciamento`) para travar regras de negócio (ex: impedir que o valor do imóvel seja negativo ou zero).
* **Integração com API Externa:** Uso de chamadas HTTP nativas e da biblioteca **Gson** para ler e converter os dados JSON da cotação de ações.

---

##  Tecnologias Utilizadas

* **Linguagem:** Java 24
* **IDE:** IntelliJ IDEA
* **Bibliotecas Extras:** Google Gson (para conversão do JSON da API)
