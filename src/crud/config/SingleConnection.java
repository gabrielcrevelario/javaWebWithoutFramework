package crud.config;


import java.sql.Connection;
import java.sql.DriverManager;


public class SingleConnection {
	 private static String url = "jdbc:mysql://localhost:3306/crud?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 private static String password = "";
	 private static String user = "root";
	 private static Connection connection = null;
	     
	    static {
	    	connectar();
	    }
	    public SingleConnection() {
		  connectar();
		}
	    
	  private static void connectar() {
	    	try {
	    		if(connection == null)	{
	    			Class.forName("com.mysql.jdbc.Driver");
	    			connection = DriverManager.getConnection(url, user, password);
	    			connection.setAutoCommit(false);
	    		}
	    		
	    	} catch(Exception ex) {
	    		throw new RuntimeException("Não foi possivel estabelecer a conexão");
	    	}
	    }
	
	public static Connection getConnection() {
		return connection;
	}
   
		

}
