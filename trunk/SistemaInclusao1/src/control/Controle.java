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
		try {
			String q = request.getParameter("q");
			if(q.equalsIgnoreCase("cadastrar"))
				cadastrar(request, response);
			else if(q.equalsIgnoreCase("consultar"))
				consultar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				Integer idade = new Integer(request.getParameter("idade"));
				String cidade = request.getParameter("cidade");
				String estado = request.getParameter("estado");
				
				Pessoa p1 = new Pessoa(null, nome, email, idade);
				
				
				Endereco e1 = new Endereco(null, cidade, estado);
				
				p1.setEndereco(e1);
				
				new PessoaDao().cadastrar(p1);
				
				request.setAttribute("msg", "Cadastrado com sucesso!");
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	protected void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			List<Pessoa> listaPessoa = new PessoaDao().listar();
			
			request.setAttribute("lista", listaPessoa);
	
			request.getRequestDispatcher("listar.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
