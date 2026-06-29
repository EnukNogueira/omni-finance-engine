package inicial;

public abstract class Investimento {
        private int id;
        private String banco;
        private String codigo;
        private double valorAplicado;

        //construtor principal
        public Investimento(int id, String banco, String codigo, double valorAplicado) {
            this.id = id;
            this.banco = banco;
            this.codigo = codigo;
            this.valorAplicado = valorAplicado;
        }
        //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(double valorAplicado) {
        this.valorAplicado = valorAplicado;
    }
}


