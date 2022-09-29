/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.util.List;
import modelo.Producto;
import modelo.Lote;
import modelo.Almacen;
import modelo.Farmacia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willydmq
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
//	 Lote l = new Lote();
//        l.agregarProducto(new ProductoNoRefrigerado("Acetaminofen", "123456", 25, 1000));
//        l.agregarProducto(new ProductoNoRefrigerado("Dolex", "654321", 25, 2000));
//        l.agregarProducto(new ProductoRefrigerado("Vacuna covid", "98547", 0, 5000));
//        l.mostrarProductos();

	//private List<Producto> productos;
	
	//Arraylist<Producto> producto = new Arraylist<Producto>();
	
	ArrayList<Producto>producto = new ArrayList<Producto>();
	ArrayList<Farmacia>farmacia = new ArrayList<Farmacia>();

	
	Producto p = new Producto("123", "ALCA", 12, 12500) {};
	Lote l = new Lote("5");
	//l.agregarProducto(p);
	Almacen a = new Almacen("159", "FECO", l);
	//a.agregarProducto(p);
	Farmacia f =new Farmacia("145689-8", "YOYO", "Av23-45");
	
	f.agregarAlmacen(a);
	f.agregarProducto("159", p);
	
	//ArrayList<Producto>p1 = new ArrayList<>();
	//List<Producto>Productos;
	
	Producto p1 = new Producto("2356", "GOGO", 15, 20000) {};
	Lote l1 = new Lote("6");
	Almacen a1 = new Almacen("1212", "NOSE", l1);
	Farmacia f1 = new Farmacia("154859-8", "KOKO", "Edifi 45 av 3");
	
	f1.agregarAlmacen(a1);
	f1.agregarProducto("1212", p1);
	//f1.agregarProducto("159", p1);
//
//	producto.add(p);
//	producto.add(p1);
//	farmacia.add(f);
//	farmacia.add(f1);
	
	System.out.println(p.toString());
	System.out.println(l.toString());
	System.out.println(a.toString());
	System.out.println(f.toString());
	System.out.println("-----------------------------");
	System.out.println(p1.toString());
	System.out.println(l1.toString());
	System.out.println(a1.toString());
	System.out.println(f1.toString());
	
    }
    
}
