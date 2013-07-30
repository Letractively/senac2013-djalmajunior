package cotrol;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.PessoaDAO;
import entity.Endereco;
import entity.Pessoa;


@WebServlet({ "/Controle", "/CadastrarPessoa", "/ListarPessoa" })
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Controle() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			/*
			 * Buscar a variavel q, que define qual a operação executada
			 */
			String q = request.getParameter("q");
			
			if(q.equalsIgnoreCase("cadastrar")){
				
				/*
				 * Recuperando os dados da pessoa no formulário
				 */
				Pessoa p1 = new Pessoa(null, 
						request.getParameter("nome"),
						request.getParameter("email"),
						new Integer(request.getParameter("idade")));
				
				/*
				 * Recuperando os dados do endereço no formulário
				 */
				Endereco e1 = new Endereco(null,
						request.getParameter("cidade"),
						request.getParameter("estado"));
				
				/*
				 * fazendo o relacionamento de Pessoa com Endereço
				 */
				p1.setEndereco(e1);
				
				/*
				 * Gravar no banco de dados
				 */
				new PessoaDAO().cadastrar(p1);
				/*
				 * Setando o valor da MSG que está sendo recuperada no index
				 */
				request.setAttribute("msg", "Cadastrado com Sucesso");
				/*
				 * Jogando a variável de msg na requisição para a index.jsp
				 */
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else if(q.equalsIgnoreCase("listar")){
				/*
				 * Executar a consulta para a lista de Pessoa
				 */
				List<Pessoa> listarPessoa = new PessoaDAO().listar();
				/*
				 * Adicionar o resultado da consulta em atributo chamado lista
				 */
				request.setAttribute("lista", listarPessoa);
				/*
				 * Redirecionar para a listar.jsp carregando o atributo lista que 
				 * contemtodos os dados obtidos da consulta
				 */
				request.getRequestDispatcher("listar.jsp").forward(request, response);
			}else{
				throw new Exception("Ação Inválida!");
			}
			
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}

}
