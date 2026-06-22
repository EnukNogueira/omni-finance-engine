package inicial;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ArrayList<acao> listaAcoes = new ArrayList<>();
        ArrayList<rendaFixa> listaRendaFixa = new ArrayList<>();

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- Sistema de Investimentos ---");
            System.out.println("1 - Cadastrar Ação");
            System.out.println("2 - Cadastrar Renda Fixa");
            System.out.println("3 - Sair e Exibir Relatório Geral");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            if (opcao == 1) {
                System.out.println("\n--- Cadastro de Ação via API ---");
                System.out.println("Digite o ID");
                int id = leitor.nextInt();
                leitor.nextLine();

                System.out.println("Digite o banco");
                String banco = leitor.nextLine();

                System.out.println("Digite o codigo (ex: PETR4, VALE3, ITUB4)");
                String codigo = leitor.nextLine().toUpperCase().trim();

                System.out.println("Digite o valor applied inicial");
                double valorAplicado = leitor.nextDouble();

                System.out.println("Digite a quantidade");
                int quantidade = leitor.nextInt();
                leitor.nextLine();

                System.out.println("Buscando cotação em tempo real na B3 via API...");
                double valorAtual = financeiraAPI.pegarPrecoAtual(codigo);
                System.out.println("Cotação atual encontrada: R$ " + valorAtual);

                acao minhaAcao = new acao(id, banco, codigo, valorAplicado, quantidade, valorAtual);
                listaAcoes.add(minhaAcao);
                System.out.println("Ação cadastrada com sucesso!");

            } else if (opcao == 2) {
                System.out.println("\n--- Cadastre a Renda Fixa ---");

                System.out.println("Digite o ID (Qualquer número)");
                int id = leitor.nextInt();
                leitor.nextLine();

                System.out.println("Digite o banco");
                String banco = leitor.nextLine();

                System.out.println("Digite o codigo/nome do título (ex: CDB, Tesouro)");
                String codigo = leitor.nextLine();

                System.out.println("Digite o valor aplicado inicial");
                double valorAplicado = leitor.nextDouble();

                System.out.println("Digite a quantidade de anos passados");
                int anosPassados = leitor.nextInt();

                System.out.println("Digite a taxa anual (ex: 10,5 para 10.5%)");
                double taxaAnual = leitor.nextDouble();
                leitor.nextLine();

                rendaFixa minhaRendaFixa = new rendaFixa(id, banco, codigo, valorAplicado, anosPassados, taxaAnual);
                listaRendaFixa.add(minhaRendaFixa);
                System.out.println("Renda Fixa cadastrada com sucesso!");

            } else if (opcao == 3) {
                System.out.println("\n-- Relatório Geral dos Investimentos ---");

                System.out.println("\n---AÇÕES--- ");
                for (acao minhaAcao : listaAcoes) {
                    System.out.println("Ativo: " + minhaAcao.getCodigo() + " | Valor total em carteira: R$" + minhaAcao.calcularValorAtual());
                }

                System.out.println("\n---RENDA FIXA---");
                for (rendaFixa rf : listaRendaFixa) {
                    System.out.println("Título: " + rf.getCodigo() + " | Valor total acumulado: R$" + rf.calcularValorAtual());
                }

                System.out.println("\nSaindo do sistema financeiro...");

            } else {
                System.out.println("Opção errada, selecione uma disponivel!");
            }
        }
    }
}
