package inicial;

public class RendaFixa extends Investimento {
    private double taxaAnual;
    private int anosPassados;

    //Construtor
    public RendaFixa(int id, String banco, String codigo, double valorAplicado, int anosPassados, double taxaAnual) {
        super(id, banco, codigo, valorAplicado);
        this.taxaAnual = taxaAnual;
        this.anosPassados = anosPassados;

    }
    //Getters e Setters
    public double getTaxaAnual() {
        return taxaAnual;
    }

    public void setTaxaAnual(double taxaAnual) {
        this.taxaAnual = taxaAnual;
    }

    public int getAnosPassados() {
        return anosPassados;
    }

    public void setAnosPassados(int anosPassados) {
        this.anosPassados = anosPassados;
    }

    public double calcularValorAtual() {
        return getValorAplicado() * Math.pow((1 + (this.taxaAnual / 100.0)), this.anosPassados);
    }
}
