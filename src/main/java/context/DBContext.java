package context;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
	private final String serverName = "localhost";
	private final String dbName = "ShoppingDB";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123";
	
	public Connection getConnection() throws Exception{
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName + ";encrypt=false";
		if(instance == null || instance.trim().isEmpty()) {
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";encrypt=false";
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,userID,password);
	}
	// test connected to Database
	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
		}
	}

}
