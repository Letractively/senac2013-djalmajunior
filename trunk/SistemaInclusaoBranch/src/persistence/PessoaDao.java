package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Endereco;
import entity.Pessoa;

public class PessoaDao extends Dao {

	public void cadastrar(Pessoa p)throws Exception{
		
		open();
		
		/*SO vai gravar efetivamente no banco se receber um commit()*/
		con.setAutoCommit(false);
		
		/*Preparar o Insert na tabela pessoa*/
		stmt = con.prepareStatement("INSERT INTO pessoa VALUES(NULL, ?,?,?)");
		
		/*Passar os dados para o INSERT*/
		stmt.setString(1, p.getNome());
		stmt.setString(2, p.getEmail());
		stmt.setInt(3, p.getIdade());
		
		/*Gravar na tabela pessoa*/
		stmt.execute();
		/*Buscar o ID gerado pelo Banco*/
		rs = stmt.getGeneratedKeys();
		rs.next();
		int chave = rs.getInt(1);
		
		stmt = con.prepareStatement("INSERT INTO endereco VALUES(NULL, ?,?,?)");
		
		stmt.setString(1, p.getEndereco().getCidade());
		stmt.setString(2, p.getEndereco().getEstado());
		stmt.setInt(3, chave);
		
		stmt.execute();
		
		con.commit();
		close();
		
	}
	
	public List<Pessoa> listar()throws Exception{
		open();
		
		stmt = con.prepareStatement("SELECT * FROM pessoa p INNER JOIN endereco e " +
				" ON p.idPessoa = e.id_pessoa");
		
		rs = stmt.executeQuery();
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		while(rs.next()){
			Pessoa p1 = new Pessoa(rs.getInt("idPessoa"), rs.getString("nome"), 
					rs.getString("email"), rs.getInt("idade"));
			Endereco e1 = new Endereco(rs.getInt("idEndereco"), rs.getString("cidade"), 
					rs.getString("estado"));
			p1.setEndereco(e1);
			lista.add(p1);
		}
		
		close();
		return lista;
	}
	
	
	
	
	
	public static void main(String[] args) {
		try{
			Pessoa p1 = new Pessoa(null, "Jose", "jose@gmail.com", 30);
			Endereco e1 = new Endereco(null, "Rio de Janeiro", "RJ");
			p1.setEndereco(e1);
			new PessoaDao().cadastrar(p1);
			System.out.println("Cadastrado com sucesso@");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
