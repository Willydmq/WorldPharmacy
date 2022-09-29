/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Willydmq
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private Connection con;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost:3306";
    private static final String DB = "mercado";
    private static final String URL = "jdbc:mysql://" + HOST + "/" + DB;
    private static final String USERNAME = "root";
    private static final String PASSWORD ="Familia$0323";
    
    public Conexion(){
        try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }
    
    public Connection getCon(){
        return con;
    }
    
    public void desconectar(){
        try{
            if(con !=null){
                con.close();
                System.out.println("La desconexion fue exitosa");
            }
        }catch(Exception excepcion){
            System.out.println("Ha ocurrido un error al desconectar " + excepcion.getMessage());
        }
    }
}
