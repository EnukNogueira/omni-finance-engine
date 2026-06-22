package inicial;
//Classe Filha
public class acao extends investimento{
    private int quantidade;
    private double precoAtual;

    public acao(int id, String banco,String codigo, double valorAplicado, int quantidade, double precoAtual) {
        super(id, banco, codigo, valorAplicado);

        //variaveis
        this.quantidade = quantidade;
        this.precoAtual = precoAtual;

    }
    //Getters e Setters
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }
    public double calcularValorAtual(){
        return this.precoAtual* this.quantidade;
    }
}
