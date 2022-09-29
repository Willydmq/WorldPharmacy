/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Willydmq
 */
public class Conectar {
    //private static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "Familia$0323";
    private static final String url = "jdbc:mysql://localhost:3306/mercado";
    public Connection con = null;

    public Conectar() {
	//conn = null;
	try {
	    Class.forName(driver);
	    con = DriverManager.getConnection(url, user, password);
	    if (con != null) {
		System.out.println("Conexion establecida...");
		
	    }
	} catch (ClassNotFoundException | SQLException ex) {
	    System.out.println("Error al conectar "+ ex);
	}catch (Exception ex) {
	    System.out.println("Error al conectar "+ ex);
	}
    }
    
    public Connection getConnection(){
	return con;
    }
    
    public void desconectar(){
	con = null;
	if (con == null) {
	    System.out.println("Conexion terminada..");
	    
	}
    }
    
    
    
}
