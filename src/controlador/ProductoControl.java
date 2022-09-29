/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Willydmq
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Producto;

public class ProductoControl {
    private Conexion conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private Producto p;
    
    public ArrayList<Producto> listarProducto(){
        ArrayList<Producto> listaProducto =new ArrayList();
        conn = new Conexion();
        String sql = "SELECT * FROM producto ORDER BY id_pro";
        try {
            stm = conn.getCon().createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Producto producto = new Producto(rs.getString("id_pro"),rs.getString("nombre_pro"),rs.getDouble("temperatura_pro"),
			rs.getDouble("valorBase_pro")) {};
                listaProducto.add(producto);
            }
        } catch (SQLException e) {
        }
        return listaProducto;
    }
    
    public String agregarProducto(String id_pro,String nombre_pro,String temperatura_pro,String valorBase_pro){
        String mensaje = "";
        conn = new Conexion();
        String sql = "SELECT * FROM producto WHERE id_pro = " + id_pro;
        try {
            stm = conn.getCon().createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()){
                mensaje = "Producto YA existe";
            }
            else{
                sql = "INSERT INTO producto(id_pro,nombre_pro,temperatura_pro,valorBase_pro) VALUES ('"+id_pro+"','"+nombre_pro+"',"
			+ "'"+temperatura_pro+"','"+valorBase_pro+"')";
                stm = conn.getCon().createStatement();
                stm.executeUpdate(sql);
                mensaje = "Producto agregado";
            }
        } catch (SQLException e) {
        }
        return mensaje;
    }
    
    public String eliminarProducto (String id_pro){
        String mensaje = "";
        conn = new Conexion();
        String sql = "SELECT * FROM producto WHERE id_pro = " + id_pro;
        try {
            stm = conn.getCon().createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()){
                sql = "DELETE FROM producto WHERE id_pro = " + id_pro;
                stm = conn.getCon().createStatement();
                stm.executeUpdate(sql);
                mensaje = "El producto ha sido eliminada";
            }
            else{
                mensaje = "El producto NO existe";
            }
        } catch (SQLException e) {
        }
        return mensaje;
    }
    //will aqui cambie  el tipo de dato de los parametros 
//    public String modificarProducto(String id_pro,String nombre_pro,double temperatura_pro,double valorBase_pro){
//        String mensaje = "";
//        conn = new Conexion(); 
//        try {
//            stm = conn.getCon().createStatement();   
//            String sql = "UPDATE producto SET nombre_pro = '" + nombre_pro 
//                        + "', temperatura_pro = " + temperatura_pro 
//                        + ", valorBase_pro = " +valorBase_pro 
//                        + " WHERE codigo_edi = '" + id_pro+"'";
//            if(stm.execute(sql)){
//                mensaje = "Producto ha sido modificada";
//            }else{
//                mensaje = "Problema al modificar información";
//            }
//            
//        } catch (SQLException e) {
//        }
//        return mensaje;
//    }
    
    public String modificarProducto(String id_pro,String nombre_pro,double temperatura_pro,double valorBase_pro){
        String mensaje = "";
        conn = new Conexion(); 
        try {
            stm = conn.getCon().createStatement();
            String sql = "UPDATE producto SET nombre_pro = '" + nombre_pro 
                        + "', temperatura_pro = " + temperatura_pro 
                        + ", valorBase_pro = " +valorBase_pro 
                        + " WHERE id_pro = '" + id_pro +"'";
            System.out.println(sql);
            if(!stm.execute(sql)){
                mensaje = "Producto ha sido modificado";
            }else{
                mensaje = "Problema al modificar información";
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return mensaje;
    }
}
