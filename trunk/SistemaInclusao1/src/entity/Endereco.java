package entity;

public class Endereco {

	private Integer idEndereco;
	private String cidade;
	private String estado;
	
	/*
	 * Endereco PERTENCE a UMA PESSOA
	 */
	private Pessoa pessoa;
	
	public Endereco(Integer idEndereco, String cidade, String estado) {
		super();
		this.idEndereco = idEndereco;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Endereco() {
		super();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}
	
	
	
}
