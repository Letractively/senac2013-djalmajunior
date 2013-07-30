package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.PessoaDao;

import entity.Endereco;
import entity.Pessoa;

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
		try{
			
			/*
			 * Buscar a variavel q, que define qual a operaçao executada
			 */
			String q = request.getParameter("q");
			
			if(q.equalsIgnoreCase("cadastrar")){
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				Integer idade = new Integer(request.getParameter("idade"));
				if(nome.equalsIgnoreCase("")){
					/*Adicionar uma mensagem para a variavel msg*/
					request.setAttribute("msg", "Preencha o Campo Nome!");
					/*Redirecionar para a index.jsp levando a mensagem*/
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else if(email.equalsIgnoreCase("")){
					/*Adicionar uma mensagem para a variavel msg*/
					request.setAttribute("msg", "Preencha o Campo Email!");
					/*Redirecionar para a index.jsp levando a mensagem*/
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else if(idade != null){
					/*Adicionar uma mensagem para a variavel msg*/
					request.setAttribute("msg", "Preencha o Campo Idade!");
					/*Redirecionar para a index.jsp levando a mensagem*/
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				/*Resgatar os dados da pessoa no formulario*/
				Pessoa p1 = new Pessoa(null, nome,email,idade);
				
				/*Resgatar os dados da endereco no formulario*/
				Endereco e1 = new Endereco(null, 
						request.getParameter("cidade"), 
						request.getParameter("estado"));
				/*Relacionar os objetos, Endereco e1 é da pessoa p1*/
				p1.setEndereco(e1);
				/*Gravar no banco de dadso*/
				new PessoaDao().cadastrar(p1);
				/*Adicionar uma mensagem para a variavel msg*/
				request.setAttribute("msg", "Cadastrado com sucesso!");
				/*Redirecionar para a index.jsp levando a mensagem*/
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
				
			}else if(q.equalsIgnoreCase("listar")){
				
				/*Executar a consulta para a lista de Pessoas*/
				List<Pessoa> listaPessoa = new PessoaDao().listar();
				/*Adicionar o resultado da consulta em atributo chamado lista*/
				request.setAttribute("lista", listaPessoa);
				/*
				 * Redirecionar para a listar.jsp carregando o atributo lista que 
				 * contem todos os dados obtidos da consulta
				 */
				request.getRequestDispatcher("listar.jsp").forward(request, response);
				
			}else{
				throw new Exception("Ação Invalida!");
			}
			
		}catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
