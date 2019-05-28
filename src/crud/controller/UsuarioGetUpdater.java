package crud.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.models.Usuario;
import crud.service.UsuarioService;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
@WebServlet({ "/updateUser" })
public class UsuarioGetUpdater extends HttpServlet  {

	 UsuarioService userService = new UsuarioService();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  RequestDispatcher dp = req.getRequestDispatcher("updateUser.jsp");
	
		try {
			Usuario user = userService.consultar(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("user", user);
			req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
			dp.forward(req, resp);	
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new Usuario();		
		usuario.setId(Integer.parseInt(req.getParameter("id")));
		String nome = req.getParameter("nome");
		usuario.setNome(nome);
		String sobrenome = req.getParameter("sobrenome");
		usuario.setSobrenome(sobrenome);
		String email = req.getParameter("email");
		usuario.setEmail(email);
		String senha = req.getParameter("senha");
		usuario.setSenha(senha);
		try {		
				userService.atualizar(usuario);
				resp.sendRedirect("/crud/index");
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.doPost(req, resp);
	}
}
