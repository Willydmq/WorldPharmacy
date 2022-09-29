/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Willydmq
 */
//import com.mysql.cj.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.PreparedStatement;
import java.util.ArrayList;
//import java.util.Iterator;
//import javax.swing.JOptionPane;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;
import modelo.Conectar;
import modelo.Conexion;
import modelo.Producto;
import modelo.Lote;
import vista.LoteFormulario;

public class LoteControl {

    private Conexion conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private Connection con = null;
//    private PreparedStatement ps = null;
//    private Lote l;
    //private Producto p;
    private LoteFormulario lf;
    private Producto producto = new Producto() {
    };
    private Lote lote = new Lote();

    public void listarLote(JComboBox box) {
	ArrayList<Lote> listaLote = new ArrayList();
	DefaultComboBoxModel value;
	Statement st = null;
	Connection con = null;
	ResultSet rs = null;
	Conectar conec = new Conectar();

	try {
	    con = conec.getConnection();
	    st = con.createStatement();
	    rs = st.executeQuery("SELECT producto.nombre_pro, producto.id_pro, (SELECT lote.id_lot FROM lote WHERE lote.id_pro = producto.id_pro) "
		    + "AS id_lot FROM producto ORDER BY nombre_pro;");
	    value = new DefaultComboBoxModel();
	    value.removeAllElements();
	    value.addElement("Seleccione un Producto");
//	    box.removeAllItems();
//	    box.addItem("Seleccionar un Producto");
	    while (rs.next()) {
//		value.addElement(rs.getString("nombre_pro"));
//		value.addAll(listaProducto);
		//value.addElement(new Producto(rs.getString("nombre_pro"), rs.getString("id_pro")) {});
		value.addElement(new Lote(rs.getString("nombre_pro"), rs.getString("id_pro"), rs.getString("id_lot")));
//		value.addElement(new Producto(rs.getString("nombre_pro")) {
//		});
	    }
	    box.setModel(value);

	} catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	} catch (Exception ex) {
	    System.out.println(ex.getMessage());
	} finally {
	    try {
		st.close();
		rs.close();
		conec.desconectar();
	    } catch (Exception ex) {
	    }
	}//return listaProducto;
    }

//    public ArrayList<Producto> listarLote(JComboBox<Producto> jcbNombre, String nombre_pro) {
//	conn = new Conexion();
//	con = conn.getCon();
//	ArrayList<Producto> listaLote = new ArrayList();
//	String sql = "select id_pro, nombre_pro from producto Where id_pro = :id_pro";
//	try {
//	    stm = conn.getCon().createStatement();
//	    rs = stm.executeQuery(sql);
//	    while (rs.next()) {
//		Producto producto = new Producto() {
//		};
//		producto.setId_pro(rs.getString("id_pro"));
//		listaLote.add(producto);
//
//	    }
//	    rs.close();
//	} catch (SQLException e) {
//	    System.out.println("Error consulta" + e);
//	}
//	return listaLote;
//
//    }
//    public ArrayList<Producto> listarProducto(String nombre_pro) {
//	ArrayList<Producto> listaProducto = new ArrayList();
//	conn = new Conexion();
//	String sql = "SELECT * FROM producto WHERE nombre_pro = "+nombre_pro;
//	
//	try {
//	    stm = conn.getCon().createStatement();
//	    rs = stm.executeQuery(sql);
//	    Producto p = null;
//	    while (rs.next()) {
//		p = new Producto() {};
//		p.setId_pro(rs.getString("id_pro"));
//		listaProducto.add(p);
//	    }
//	    rs.close();
//	} catch (SQLException e) {
//	    System.out.println("Error consulta"+e);
//	}
//	return listaProducto;
//    }
//    public ArrayList<Producto> listarProducto() {
//	conn = new Conexion();
//	con = conn.getCon();
//	ArrayList<Producto> listaProducto = new ArrayList();
//	String sql = "SELECT * FROM producto";
//
//	try {
//	    stm = conn.getCon().createStatement();
//	    rs = stm.executeQuery(sql);
//	    while (rs.next()) {
//		Producto producto = new Producto() {
//		};
//		producto.setNombre_pro(rs.getString("nombre_pro"));
//		listaProducto.add(producto);
//
//	    }
//	    rs.close();
//	} catch (SQLException e) {
//	    System.out.println("Error consulta" + e);
//	}
//	return listaProducto;
//    }
//    public String listarLote(JComboBox nombre_pro, String id_pro) {
//	String mensaje = "";
//	DefaultComboBoxModel value;
//	Conexion conn = new Conexion();
//	PreparedStatement ps = null;
//	Connection con = null;
//	ResultSet rs = null;
//	//String sql = "SELECT id_pro FROM producto WHERE id_pro = ?";
//	try {
//	    con = conn.getCon();
//	    ps = con.prepareStatement("SELECT id_pro FROM producto WHERE id_pro = ?");
//	    ps.setString(1, id_pro);
//	    //rs = stm.executeQuery(sql);
//	    rs = ps.executeQuery();
//	    value = new DefaultComboBoxModel();
//	    nombre_pro.setModel(value);
//	    while (rs.next()) {
//		
//		value.addElement(new Producto(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)) {
//		});
//	    }
//	} catch (SQLException ex) {
//	    System.out.println("Error consulta try" + ex);
//	} finally {
//	    try {
//		ps.close();
//		rs.close();
//		con.close();
//	    } catch (Exception ex) {
//		System.out.println("Error consulta" + ex);
//	    }
//	}
//	return mensaje;
//    }
    
        public String agregarLote(String id_pro, String id_lot){
        String mensaje = "";
        conn = new Conexion();
        String sql = "SELECT * FROM lote WHERE id_lot = " + id_lot;
        try {
            stm = conn.getCon().createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()){
                mensaje = "Lote YA existe";
            }
            else{
                sql = "INSERT INTO lote(id_pro,id_lot) VALUES ('"+id_pro+"','"+id_lot+"')";
                stm = conn.getCon().createStatement();
                stm.executeUpdate(sql);
                mensaje = "Lote agregado";
            }
        } catch (SQLException e) {
        }
        return mensaje;
    }
//
    public String eliminarLote(JTextField id_lot) {
	String mensaje = "";
	//lote.setId_lot(Integer.parseInt(id_lot.getText()));
	conn = new Conexion();
	String sql = "SELECT * FROM lote WHERE id_lot = " + id_lot;
	try {
	    stm = conn.getCon().createStatement();
	    rs = stm.executeQuery(sql);
	    if (rs.next()) {
		sql = "UPDATE lote SET id_lot = '"+""+"' WHERE (id_lot = '"+id_lot+"')";
		stm = conn.getCon().createStatement();
		stm.executeUpdate(sql);
		mensaje = "El lote ha sido eliminada";
	    } else {
		mensaje = "El lote NO existe";
	    }
	} catch (SQLException e) {
	    mensaje = "ERROR";
	}
	return mensaje;
    }
	
    public String modificarProducto(String id_pro, String id_lot) {
	String mensaje = "";
	conn = new Conexion();
	try {
	    stm = conn.getCon().createStatement();
	    String sql = "UPDATE lote SET id_lot = '" + id_lot + "'";
	    System.out.println(sql);
	    if (!stm.execute(sql)) {
		mensaje = "Lote ha sido modificado";
	    } else {
		mensaje = "Problema al modificar información";
	    }

	} catch (SQLException e) {
	    System.out.println(e);
	    mensaje = "ERROR";
	}
	return mensaje;
    }
    
//    public void cargarCombo(JComboBox nombre_pro) {
//	DefaultComboBoxModel combo = new DefaultComboBoxModel();
//	nombre_pro.setModel(combo);
//	String mensaje = "";
//	conn = new Conexion();
//	Lote lote = new Lote();
//	try {
//	    String sql = "SELECT nombre_pro FROM producto";
//	    stm = conn.getCon().createStatement();
//	    rs = stm.executeQuery(sql);
//	    while (rs.next()) {
//		Producto producto = new Producto() {};
//		producto.setNombre_pro(rs.getString("nombre_pro"));
//		lote.agregarProducto(producto);
//		combo.addElement(producto.getNombre_pro());
//		mensaje = "Exito";
//	    }
//	} catch (Exception e) {
//	    System.out.println("no fue exitosa " + e);
//	}
//    }
//    public void cargarCombo(JComboBox nombre_pro) {
//	DefaultComboBoxModel combo = new DefaultComboBoxModel();
//	nombre_pro.setModel(combo);
//	String mensaje = "";
//	conn = new Conexion();
//	try {
//	    String sql = "SELECT nombre_pro FROM producto ORDER BY nombre_pro";
//	    stm = conn.getCon().createStatement();
//	    rs = stm.executeQuery(sql);
//	    combo.addElement("Seleccione Producto");
//	    while (rs.next()) {
//		Producto producto = new Producto() {
//		};
//		producto.setNombre_pro(rs.getString("nombre_pro"));
//		combo.addElement(producto.getNombre_pro());
//		mensaje = "Exito";
//	    }
//	} catch (Exception e) {
//	    System.out.println("no fue exitosa " + e);
//	}
//    }
}
