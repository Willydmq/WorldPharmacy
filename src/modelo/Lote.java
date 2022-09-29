/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willydmq
 */
public class Lote extends Producto {
    private List<Producto> productos;
    private String id_lot;
    private Producto pro = new Producto() {
    };

    public Lote(String id_lot) {
	this.id_lot = id_lot;
	this.productos = new ArrayList<>();
	
    }   

    public Lote(String id_lot, List<Producto> productos) {
	this.id_lot = id_lot;
	this.productos = productos;
	
    }

    public Lote(String nombre_pro,String id_pro, String id_lot) {
	super(nombre_pro, id_pro);
	//super(id_pro);
	this.id_lot = id_lot;
    }
    
    

    public Lote() {
    }
    
    

//    public Lote(){
//	this.productos = new ArrayList<Producto>();
//	this.id_lot = id_lot;
//    }
//    public Lote(){
//        productos = new ArrayList<>();
//    }
    
//    public void agregarProducto(Producto producto){
//        productos.add(producto);
//    }
    
    public void agregarProducto(Producto productos) {
        this.productos.add(productos);
    }
    
    public void mostrarProductos(){
        for(Producto producto:productos){
            System.out.println(producto);
        }
    }

    public List<Producto> getProductos() {
	return productos;
    }

    public void setProductos(List<Producto> productos) {
	this.productos = productos;
    }

    public String getId_lot() {
	return id_lot;
    }

    public void setId_lot(String id_lot) {
	this.id_lot = id_lot;
    }

    public Producto getPro() {
	return pro;
    }

    public void setPro(Producto pro) {
	this.pro = pro;
    }
    

//    @Override
//    public String toString() {
//	return "Lote{" + 
//		"productos=" + this.getProductos() + 
//		", id_lot=" + this.getId_lot() + '}';
//    }
    
//        @Override
//    public String toString() {
//	return pro.getNombre_pro();
//
//    }
}
