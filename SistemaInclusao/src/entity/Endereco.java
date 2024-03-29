package entity;

public class Endereco {
	
	private Integer idEndereco;
	private String cidade;
	private String estado;
	
	/*
	 * Endere�o pertence a uma pessoa
	 */
	private Pessoa pessoa;
	
	public Endereco(Integer idEndereco, String cidade, String estado) {
		this.idEndereco = idEndereco;
		this.cidade = cidade;
		this.estado = estado;
	}


	public Endereco() {

	}


	public Integer getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}

}
