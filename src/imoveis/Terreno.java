package imoveis;

public class Terreno extends Financiamento {

    private String tipoZoneamento;

    // Construtor
    public Terreno(double valorImovel, int prazoFinanciamentoMeses, double taxaJurosAnual, String tipoZoneamento) throws ErrosExceptionFinanciamento {
        super(valorImovel, prazoFinanciamentoMeses, taxaJurosAnual);
        this.tipoZoneamento = tipoZoneamento;
    }

    //Polimorfismo
    @Override
    public double calcularPagamentoMensal() {
        double parcelaBase = this.valorImovel / this.prazoFinanciamentoMeses;
        double jurosMensais = (this.valorImovel * (this.taxaJurosAnual / 12.0)) / 100.0;
        return (parcelaBase + jurosMensais) * 1.02;
    }

    //Getters e Setters
    public String getTipoZoneamento() {
        return tipoZoneamento;
    }

    public void setTipoZoneamento(String tipoZoneamento) {
        this.tipoZoneamento = tipoZoneamento;
    }
}