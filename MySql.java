package Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MySql {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	final private String host = "localhost:3306/prueba";
	final private String usuario = "pedro";
	final private String contraseña = "123";
	
	/*
	 * Pre:---
	 * Post: En este método crea le da el valor a connection y statement para que 
	 * se puedan utilizar en el resto de métodos.
	 */
	public void cargarBase() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + host + "?"
					+ "user=" + usuario + "&password=" + contraseña );
			statement = connection.createStatement();	
			}
		catch(Exception e) {
			throw e;
		}
	}
	
	/*
	 * Pre:---
	 * Post: En este método se recibe una letra, una palabra y una linea y las añade a 
	 * a la base de datos a través de un insert into y preparedStatement.
	 */
	public void añadir(String letra, String palabra, int linea) throws Exception{
		try {
			preparedStatement = connection.prepareStatement("insert into registro("
					+ "letra, palabra, linea) values(?, ?, ?)");
			preparedStatement.setString(1, letra);
			preparedStatement.setString(2, palabra);
			preparedStatement.setInt(3, linea);
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			throw e;
		}
	}
}