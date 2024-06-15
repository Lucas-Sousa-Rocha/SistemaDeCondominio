package SRC;

class Debito {
    private String descricao;
    private double valor;
    private String numeroApartamento;

    public Debito(String descricao, double valor, String numeroApartamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.numeroApartamento = numeroApartamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }
    
}
