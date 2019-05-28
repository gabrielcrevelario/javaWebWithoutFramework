package crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.models.Usuario;
import crud.service.UsuarioService;

@WebServlet({ "/index" })
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsuarioService userService = new UsuarioService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> listUser = userService.listar();
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		if(action.equalsIgnoreCase("delete")) {
			try {
				userService.remover(Integer.parseInt(id));
				resp.sendRedirect("/crud/index");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		   try {		
		        Usuario user = userService.consultar(Integer.parseInt( req.getParameter("id")));
		        req.setAttribute("user",user);
		        
		       RequestDispatcher view =  req.getRequestDispatcher("/index.jsp");
		       view.forward(req, resp);
		        			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		}
		   }

	}
	
	 private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
	            throws Exception {
	        int id = Integer.parseInt( req.getParameter("id"));
	        Usuario user = userService.consultar(id);
	        RequestDispatcher dispatcher = req.getRequestDispatcher("updateUser");
	       
	        req.setAttribute("user", user);
	        dispatcher.forward(req, resp);
	 
	    }
	 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		String nome = req.getParameter("nome");
		usuario.setNome(nome);
		String sobrenome = req.getParameter("sobrenome");
		usuario.setSobrenome(sobrenome);
		String email = req.getParameter("email");
		usuario.setEmail(email);
		String senha = req.getParameter("senha");
		usuario.setSenha(senha);
		try {
				userService.create(usuario);
				resp.sendRedirect("/crud/index");
		
				
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.doPost(req, resp);
	}

}
