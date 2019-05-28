package crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.config.SingleConnection;
import crud.models.Usuario;

public class UsuarioService {
	
	private Connection connection;
	
	public UsuarioService() {
		connection = SingleConnection.getConnection();
	}
	public void create(Usuario usuario) throws SQLException {
		String sql = "insert into usuario(nome,sobrenome,email,senha) values (?, ?, ?, ?)";
		try {
			 PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getEmail());
			statement.setString(4, usuario.getSenha());
			statement.execute();
			connection.commit();
		} catch(Exception ex) {
		}
		
	}
	public void atualizar(Usuario usuario) throws SQLException {
		String sql = "update usuario set nome = ?, "
				+ "sobrenome = ?, email = ?, senha = ? where id="+usuario.getId();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getEmail());
			statement.setString(4, usuario.getSenha());
			statement.execute();
			connection.commit();
			} catch (Exception e) {
				connection.rollback();
			}
			
	
	}
	
	public void remover(int id) throws SQLException {
		
		String sql = "delete from usuario where id=" + id + ";";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.commit();
		} catch (Exception e) {
			connection.rollback();
		}
	}
	public Usuario consultar(int id) throws Exception {
		Usuario usuario = new Usuario();
		 String sql = "select * from usuario where id="+id;
		 try {
		 PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {			
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSobrenome(resultSet.getString("sobrenome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));		
			}
				return usuario;
		 } catch(Exception ex) {
			 throw new Exception("não foi possivel consultar esse usuario");
		 }
	}
	  public List<Usuario> listar()  {
		  List<Usuario> listUser = new ArrayList<Usuario>();
		  String sql = "select * from usuario";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(resultSet.getInt("id"));
					usuario.setNome(resultSet.getString("nome"));
					usuario.setSobrenome(resultSet.getString("sobrenome"));
					usuario.setEmail(resultSet.getString("email"));
					usuario.setSenha(resultSet.getString("senha"));
				
					listUser.add(usuario);
					
				}
				return listUser;
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
	    return listUser;
		 }
}
