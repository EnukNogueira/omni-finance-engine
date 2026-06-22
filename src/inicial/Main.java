package inicial;

public class Main {
    public static void main(String[] args) {
    acao minhaAcao = new acao(1, "Banco do Brasil","BBAS3",5000.0,100,55.55);

    rendaFixa meuCdb = new rendaFixa(2,"Itau","CDB_ITAU",10000.0, 2, 0.10);

    System.out.println("---Relatório de investimentos---");
    System.out.println("Ativo: " + minhaAcao.getCodigo() +" Valor atual: R$" + minhaAcao.calcularValorAtual());
    System.out.println("Renda fixa: " + meuCdb.getCodigo()+ " Valor atual: R$" + meuCdb.calcularValorAtual());
    }
}