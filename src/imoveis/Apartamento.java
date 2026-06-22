package imoveis;

public class Apartamento extends financiamento {

    private int vagasGaragem;

    //Construtor
    public Apartamento(double valorImovel, int prazoFinanciamentoMeses, double taxaJurosAnual, int vagasGaragem) throws ErrosExceptionFinanciamento {
        super(valorImovel, prazoFinanciamentoMeses, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
    }

    //Polimorfismo
    @Override
    public double calcularPagamentoMensal() {
        double parcelaBase = this.valorImovel / this.prazoFinanciamentoMeses;
        double jurosMensais = (this.valorImovel * (this.taxaJurosAnual / 12.0)) / 100.0;
        double taxaCondominioSimulada = 50.0;
        return parcelaBase + jurosMensais + taxaCondominioSimulada;
    }

    //Getters e Setters
    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }
}