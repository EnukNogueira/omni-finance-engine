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

        ArrayList<Acao> listaAcoes = new ArrayList<>();
        ArrayList<RendaFixa> listaRendaFixa = new ArrayList<>();

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
                    double valorAtual = FinanceiraAPI.pegarPrecoAtual(codigo);
                    System.out.println("Cotação encontrada: R$ " + valorAtual);

                    Acao minhaAcao = new Acao(id, banco, codigo, valorAplicado, quantidade, valorAtual);
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

                    RendaFixa minhaRendaFixa = new RendaFixa(id, banco, codigo, valorAplicado, anosPassados, taxaAnual);
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

                    //Financiamento de terrains
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

                    //Relatórios e Persistência das Simulações
                } else if (opcao == 6) {
                    System.out.println("-----Relatório geral-----");
                    System.out.println("\n---Carteira de ações---");
                    for (Acao a : listaAcoes) {
                        System.out.println("Ativo: " + a.getCodigo() + " | Total: R$" + a.calcularValorAtual());
                    }

                    System.out.println("\n---Carteira de renda fixa---");
                    for (RendaFixa rf : listaRendaFixa) {
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

                     //Criação do arquivo TXT
                    try {
                        java.io.FileWriter fw = new java.io.FileWriter("financiamentos.txt");
                        java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);

                        for (Casa c : listaCasas) {
                            bw.write("Casa;" + c.getValorImovel() + ";" + c.getPrazoFinanciamentoMeses() + ";" + c.getTaxaJurosAnual() + ";" + c.getAreaConstruida());
                            bw.newLine();
                        }
                        for (Apartamento ap : listaApartamentos) {
                            bw.write("Apartamento;" + ap.getValorImovel() + ";" + ap.getPrazoFinanciamentoMeses() + ";" + ap.getTaxaJurosAnual() + ";" + ap.getVagasGaragem());
                            bw.newLine();
                        }
                        for (Terreno t : listaTerrenos) {
                            bw.write("Terreno;" + t.getValorImovel() + ";" + t.getPrazoFinanciamentoMeses() + ";" + t.getTaxaJurosAnual() + ";" + t.getTipoZoneamento());
                            bw.newLine();
                        }
                        bw.close();
                        System.out.println("\n[INFO] Dados gravados em 'financiamentos.txt' com sucesso!");

                        System.out.println("\nComprovante de leitur do arquivo txt");
                        java.io.FileReader fr = new java.io.FileReader("financiamentos.txt");
                        java.io.BufferedReader br = new java.io.BufferedReader(fr);
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            System.out.println("Linha lida do arquivo: " + linha);
                        }
                        br.close();

                    } catch (java.io.IOException e) {
                        System.out.println("[ERRO] Falha ao manipular o arquivo de texto: " + e.getMessage());
                    }

                      //Serialização do ArrayLis
                    try {
                        ArrayList<Object> todasSimulacoes = new ArrayList<>();
                        todasSimulacoes.addAll(listaCasas);
                        todasSimulacoes.addAll(listaApartamentos);
                        todasSimulacoes.addAll(listaTerrenos);

                        java.io.FileOutputStream fos = new java.io.FileOutputStream("financiamentos.ser");
                        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos);
                        oos.writeObject(todasSimulacoes);
                        oos.close();
                        System.out.println("\n[INFO] Criação de aquivo TXT foi um sucesso em 'financiamentos.ser'!");

                        System.out.println("\n--- Comprovante de leitura do arquivo serializado ---");
                        java.io.FileInputStream fis = new java.io.FileInputStream("financiamentos.ser");
                        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis);

                        @SuppressWarnings("unchecked")
                        ArrayList<Object> listaRecuperada = (ArrayList<Object>) ois.readObject();
                        ois.close();

                        System.out.println("Total de financiamentos deserializados com sucesso: " + listaRecuperada.size());

                    } catch (Exception e) {
                        System.out.println("[ERRO] Falhou " + e.getMessage());
                    }

                    System.out.println("\nEncerrando o projeto...");

                    //Else
                } else {
                    System.out.println("Opção incorreta, selecione uma opção que exista");
                }

                //Catch do menu
            } catch (ErrosExceptionFinanciamento e) {
                System.out.println("\n[ERRO!!!!] " + e.getMessage());
                opcao = 0;
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO!!!!] Tem que ser um número não um texto...");
                leitor.nextLine();
                opcao = 0;
            }
        }
    }
}