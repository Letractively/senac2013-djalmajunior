package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Endereco;
import entity.Pessoa;

public class PessoaDAO extends DAO {
	
	public void cadastrar(Pessoa p) throws Exception{
		//abrir conexão
		open();
		
		con.setAutoCommit(false); //- ele grava apenas pra sessão....apenas confirma a sessão se der commit no final
		
		//Preparar conexão para inserção de pessoa
		stmt = con.prepareStatement("INSERT INTO pessoa VALUES(NULL, ?, ?, ?)");
		
		//passar os parâmetros para o insert
		stmt.setString(1, p.getNome());
		stmt.setString(2, p.getEmail());
		stmt.setInt(3, p.getIdade());
		
		//gravar no banco
		stmt.execute();
		
		//buscar o id gerado pelo Banco
		
		rs = stmt.getGeneratedKeys();
		
		rs.next();
		
		int chave = rs.getInt(1);
		
		stmt = con.prepareStatement("INSERT INTO endereco VALUES(NULL, ?, ?, ?)");
		
		stmt.setString(1, p.getEndereco().getCidade());
		stmt.setString(2, p.getEndereco().getEstado());
		stmt.setInt(3, chave);
		
		stmt.execute();
		
		//confirmar inserção no banco
		con.commit();
		close();
	}
	
	public List<Pessoa> listar() throws Exception{
		open();
		
		stmt = con.prepareStatement("SELECT * FROM pessoa p INNER JOIN endereco e ON p.idPessoa = e.id_pessoa ");
		
		rs = stmt.executeQuery();
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		while(rs.next()){
			Pessoa p1 = new Pessoa(rs.getInt("idPessoa"), rs.getString("nome"), rs.getString("email"), rs.getInt("idade"));
			Endereco e1 = new Endereco(rs.getInt("idEndereco"), rs.getString("cidade"), rs.getString("estado"));
			
			p1.setEndereco(e1);
			
			lista.add(p1);
		}
		
		close();
		return lista;
	}

}
