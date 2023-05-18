package locadora.classes;

public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	private String cpf;
    private int id;

    public Cliente(String nome, String telefone, String endereco, String cpf, int id) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
		this.id = id;
	}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
