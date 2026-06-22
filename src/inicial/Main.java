package inicial;

import imoveis.Casa;
import imoveis.Apartamento;
import imoveis.Terreno;
import imoveis.ErrosExceptionFinanciamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ArrayList<acao> listaAcoes = new ArrayList<>();
        ArrayList<rendaFixa> listaRendaFixa = new ArrayList<>();

        ArrayList<Casa> listaCasas = new ArrayList<>();
        ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
        ArrayList<Terreno> listaTerrenos = new ArrayList<>();

        int opcao = 0;

        //Menu inicial
        while (opcao != 6) {

            try {
                System.out.println("\nSistema Bancário");

                System.out.println("1 - Cadastrar Ação (API)");
                System.out.println("2 - Cadastrar Renda Fixa");
                System.out.println("3 - Simular Financiamento de Casa");
                System.out.println("4 - Simular Financiamento de Apartamento");
                System.out.println("5 - Simular Financiamento de Terreno");
                System.out.println("6 - Sair e Exibir Relatório Geral");
                System.out.print("Escolha uma opção: ");
                opcao = leitor.nextInt();
                leitor.nextLine();

                //Ações
                if (opcao == 1) {
                    System.out.println("\n--- Cadastro de Ação via API ---");
                    System.out.println("Digite o ID(Qualquer número):");
                    int id = leitor.nextInt(); leitor.nextLine();
                    System.out.println("Digite o banco:");
                    String banco = leitor.nextLine();
                    System.out.println("Digite o código (ex: PETR4, VALE3):");
                    String codigo = leitor.nextLine().toUpperCase().trim();
                    System.out.println("Digite o valor aplicado inicial:");
                    double valorAplicado = leitor.nextDouble();
                    System.out.println("Digite a quantidade:");
                    int quantidade = leitor.nextInt(); leitor.nextLine();

                    System.out.println("Buscando cotação em tempo real...");
                    double valorAtual = financeiraAPI.pegarPrecoAtual(codigo);
                    System.out.println("Cotação encontrada: R$ " + valorAtual);

                    acao minhaAcao = new acao(id, banco, codigo, valorAplicado, quantidade, valorAtual);
                    listaAcoes.add(minhaAcao);
                    System.out.println("Cadastro da ação concluído com sucesso!");

                    //Renda Fixa
                } else if (opcao == 2) {
                    System.out.println("\n---Cadastro de Renda Fixa---");
                    System.out.println("Digite o ID(Qualquer número):");
                    int id = leitor.nextInt(); leitor.nextLine();
                    System.out.println("Digite o banco:");
                    String banco = leitor.nextLine();
                    System.out.println("Digite o codigo/nome do título:");
                    String codigo = leitor.nextLine();
                    System.out.println("Digite o valor aplicado inicial:");
                    double valorAplicado = leitor.nextDouble();
                    System.out.println("Digite a quantidade de anos:");
                    int anosPassados = leitor.nextInt();
                    System.out.println("Digite a taxa anual (ex: 10,5):");
                    double taxaAnual = leitor.nextDouble(); leitor.nextLine();

                    rendaFixa minhaRendaFixa = new rendaFixa(id, banco, codigo, valorAplicado, anosPassados, taxaAnual);
                    listaRendaFixa.add(minhaRendaFixa);
                    System.out.println("Renda Fixa cadastrada com sucesso!");

                    //Financiamento de casas
                } else if (opcao == 3) {
                    System.out.println("\n---Simulação de Financiamento: Casa---");
                    System.out.println("Digite o valor do imóvel (R$):");
                    double valor = leitor.nextDouble();
                    System.out.println("Digite o prazo do financiamento (em meses):");
                    int meses = leitor.nextInt();
                    System.out.println("Digite a taxa de juros anual (%):");
                    double taxa = leitor.nextDouble();
                    System.out.println("Digite a área construída (m²):");
                    double area = leitor.nextDouble(); leitor.nextLine();

                    Casa novaCasa = new Casa(valor, meses, taxa, area);
                    listaCasas.add(novaCasa);
                    System.out.println("Simulação de Casa salva com sucesso!");
                    System.out.printf("Valor que irá pagar da parcela Mensal: R$ %.2f\n", novaCasa.calcularPagamentoMensal());

                    //Financiamento de apartamentos
                } else if (opcao == 4) {
                    System.out.println("\n---Simulação de Financiamento: Apartamento---");
                    System.out.println("Digite o valor do imóvel (R$):");
                    double valor = leitor.nextDouble();
                    System.out.println("Digite o prazo do financiamento em meses:");
                    int meses = leitor.nextInt();
                    System.out.println("Digite a taxa de juros anual (%):");
                    double taxa = leitor.nextDouble();
                    System.out.println("Digite o número de vagas de garagem:");
                    int vagas = leitor.nextInt(); leitor.nextLine();

                    Apartamento novoApto = new Apartamento(valor, meses, taxa, vagas);
                    listaApartamentos.add(novoApto);
                    System.out.println("Simulação de Apartamento salva com sucesso!");
                    System.out.printf("Valor da Parcela Mensal (com condomínio): R$ %.2f\n", novoApto.calcularPagamentoMensal());

                    //Financiamento de terrenos
                } else if (opcao == 5) {
                    System.out.println("\n---Simulação de Financiamento: Terreno---");
                    System.out.println("Digite o valor do imóvel (R$):");
                    double valor = leitor.nextDouble();
                    System.out.println("Digite o prazo do financiamento (em meses):");
                    int meses = leitor.nextInt();
                    System.out.println("Digite a taxa de juros anual (%):");
                    double taxa = leitor.nextDouble(); leitor.nextLine();
                    System.out.println("Digite o tipo de zoneamento (Residencial/Comercial):");
                    String zoneamento = leitor.nextLine();

                    Terreno novoTerreno = new Terreno(valor, meses, taxa, zoneamento);
                    listaTerrenos.add(novoTerreno);
                    System.out.println("Simulação de Terreno salva");
                    System.out.printf("Valor da Parcela Mensal (com taxa de risco): R$ %.2f\n", novoTerreno.calcularPagamentoMensal());

                    //Relatórios
                } else if (opcao == 6) {
                    System.out.println("-----Relatório geral-----");
                    System.out.println("\n---Carteira de ações---");
                    for (acao a : listaAcoes) {
                        System.out.println("Ativo: " + a.getCodigo() + " | Total: R$" + a.calcularValorAtual());
                    }

                    System.out.println("\n---Carteira de renda fixa---");
                    for (rendaFixa rf : listaRendaFixa) {
                        System.out.println("Título: " + rf.getCodigo() + " | Total acumulado: R$" + rf.calcularValorAtual());
                    }

                    System.out.println("\n---Simulações de casas---");
                    for (Casa c : listaCasas) {
                        System.out.println("Valor Imóvel: R$" + c.getValorImovel() + " | Parcela: R$" + c.calcularPagamentoMensal());
                    }

                    System.out.println("\n--- Simulações de apartamentos ---");
                    for (Apartamento ap : listaApartamentos) {
                        System.out.println("Valor Imóvel: R$" + ap.getValorImovel() + " | Parcela: R$" + ap.calcularPagamentoMensal());
                    }

                    System.out.println("\n---Simulações de terrenos---");
                    for (Terreno t : listaTerrenos) {
                        System.out.println("Valor Imóvel: R$" + t.getValorImovel() + " | Parcela: R$" + t.calcularPagamentoMensal());
                    }

                    System.out.println("\nEncerrando o projeto...");

                    //Else
                } else {
                    System.out.println("Opção incorreta, selecione uma opção que exista");
                }

                    //Catch
            } catch (ErrosExceptionFinanciamento e) {
                System.out.println("\n[ERRO DE VALIDAÇÃO] " + e.getMessage());
                opcao = 0;
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Entrada Incorreta! Você digitou texto mas precisa ser um número.");
                leitor.nextLine();
                opcao = 0;
            }

        }
    }
}