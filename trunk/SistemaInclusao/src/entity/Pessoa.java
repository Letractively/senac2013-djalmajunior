package entity;

public class Pessoa {
	
	private Integer idPessoa;
	private String nome;
	private String email;
	private Integer idade;
	
	/*
	 * Pessoa tem um endereço
	 */
	private Endereco endereco;
	
	public Pessoa(Integer idPessoa, String nome, String email, Integer idade) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}


	public Pessoa() {
	}


	public Integer getIdPessoa() {
		return idPessoa;
	}


	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", email="
				+ email + ", idade=" + idade + "]";
	}

}
