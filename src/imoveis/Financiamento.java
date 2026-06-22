package imoveis;

public abstract class Financiamento {

    protected double valorImovel;
    protected int prazoFinanciamentoMeses;
    protected double taxaJurosAnual;


    public Financiamento(double valorImovel, int prazoFinanciamentoMeses, double taxaJurosAnual) throws ErrosExceptionFinanciamento {

        if (valorImovel <= 0) {
            throw new ErrosExceptionFinanciamento("O valor do imóvel deve ser maior que zero");
        }
        if (prazoFinanciamentoMeses <= 0) {
            throw new ErrosExceptionFinanciamento("O financiamento deve ser de pelo menos 1 mês dentro do prazo");
        }

        this.valorImovel = valorImovel;
        this.prazoFinanciamentoMeses = prazoFinanciamentoMeses;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    //Getters e Setters
    public double getValorImovel() {
        return valorImovel;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public int getPrazoFinanciamentoMeses() {
        return prazoFinanciamentoMeses;
    }

    public void setPrazoFinanciamentoMeses(int prazoFinanciamentoMeses) {
        this.prazoFinanciamentoMeses = prazoFinanciamentoMeses;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }
}
