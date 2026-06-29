package imoveis;
public class Casa extends Financiamento {

    private double areaConstruida;

    //Construtor
    public Casa(double valorImovel, int prazoFinanciamentoMeses, double taxaJurosAnual, double areaConstruida) throws ErrosExceptionFinanciamento {
        super(valorImovel, prazoFinanciamentoMeses, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
    }

    //Polimorfismo
    @Override
    public double calcularPagamentoMensal() {
        double parcelaBase = this.valorImovel / this.prazoFinanciamentoMeses;
        double jurosMensais = (this.valorImovel * (this.taxaJurosAnual / 12.0)) / 100.0;
        return parcelaBase + jurosMensais;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }
}