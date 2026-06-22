package inicial;

public class rendaFixa extends investimento{
    private double taxaAnual;
    private int anosPassados;

    //Construtor
    public rendaFixa(int id, String banco,String codigo, double valorAplicado, int anosPassados, double taxaAnual) {
        super(id, banco, codigo, valorAplicado);
        this.taxaAnual = taxaAnual;
        this.anosPassados = anosPassados;

    }

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
        return getValorAplicado() * Math.pow((1 + this.taxaAnual), this.anosPassados);

    }
}
