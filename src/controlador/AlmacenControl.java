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
import modelo.Almacen;
import modelo.Producto;

public class AlmacenControl {
    private Conexion conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private Almacen a;
    private Producto p;
    
//    public ArrayList<Almacen> listarProducto(){
//        ArrayList<Almacen> listaProducto =new ArrayList();
//        conn = new Conexion();
//        String sql = "SELECT * FROM almacen ORDER BY id_pro";
//        try {
//            stm = conn.getCon().createStatement();
//            rs = stm.executeQuery(sql);
//            while(rs.next()){
//                Almacen producto = new Almacen(rs.getString("codigo_alm"),rs.getString("nombre_alm"),rs.getArray("id_pro"));
//                listaProducto.add(producto);
//            }
//        } catch (SQLException e) {
//        }
//        return listaProducto;
//    }
    
}
