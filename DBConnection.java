package project_anp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static void main(String[]args) throws ClassNotFoundException{
		//steps to connect java app with db
		//step-1: load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "kavya29-";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
