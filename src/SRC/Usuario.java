package SRC;

abstract class Usuario implements Autenticavel {
    protected String nome;
    protected String endereco;
    protected String contato;
    protected String senha;

    public Usuario(String nome, String endereco, String contato, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

	public Object getNumeroApartamento() {
		
		return null;
	}    
}
