/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.Almacen;

/**
 *
 * @author Willydmq
 */
public class Farmacia {
    private String nit_far;
    private String nombre_far;
    private String direccion_far;
    public List<Almacen> almacenes;

    public Farmacia(String nit_far, String nombre_far, String direccion_far) {
	this.nit_far = nit_far;
	this.nombre_far = nombre_far;
	this.direccion_far = direccion_far;
	this.almacenes = new ArrayList<>();
    }

    public Farmacia(String nit_far, String nombre_far, String direccion_far, List<Almacen> almacenes) {
	this.nit_far = nit_far;
	this.nombre_far = nombre_far;
	this.direccion_far = direccion_far;
	this.almacenes = almacenes;
    }
    
    public Farmacia(Almacen almacen) {
    }

    public Farmacia() {
    }
    
    

    public String getNit_far() {
	return nit_far;
    }

    public void setNit_far(String nit_far) {
	this.nit_far = nit_far;
    }

    public String getNombre_far() {
	return nombre_far;
    }

    public void setNombre_far(String nombre_far) {
	this.nombre_far = nombre_far;
    }

    public String getDireccion_far() {
	return direccion_far;
    }

    public void setDireccion_far(String direccion_far) {
	this.direccion_far = direccion_far;
    }

    public List<Almacen> getAlmacenes() {
	return almacenes;
    }

    public void setAlmacenes(List<Almacen> almacenes) {
	this.almacenes = almacenes;
    }
    
    
      
    public void agregarAlmacen(Almacen almacen){
        this.almacenes.add(almacen);
    }
    
    public void agregarProducto(String codigo_alm,Producto producto){
        for(Almacen almacen:almacenes){
            if(almacen.getCodigo_alm().equals(codigo_alm)){
                almacen.agregarProducto(producto);
            }
        }
    }

    @Override
    public String toString() {
	return "Farmacia{" + 
		"nit_far=" + this.getNit_far() + 
		", nombre_far=" + this.getNombre_far() + 
		", direccion_far=" + this.getDireccion_far() + 
		", almacenes=" + this.getAlmacenes() + '}';
    }
    
    
}
