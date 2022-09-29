/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Willydmq
 */
public class Almacen{
    private String codigo_alm;
    private String nombre_alm;
    private Lote lote;

    public Almacen(String codigo_alm, String nombre_alm, Lote lote) {
	this.codigo_alm = codigo_alm;
	this.nombre_alm = nombre_alm;
	this.lote = lote;
    }
    public Almacen() {
    }
    
    public void agregarProducto(Producto productos){
        this.lote.agregarProducto(productos);
    }

    public String getCodigo_alm() {
	return codigo_alm;
    }

    public void setCodigo_alm(String codigo_alm) {
	this.codigo_alm = codigo_alm;
    }

    public String getNombre_alm() {
	return nombre_alm;
    }

    public void setNombre_alm(String nombre_alm) {
	this.nombre_alm = nombre_alm;
    }

    public Lote getLote() {
	return lote;
    }

    public void setLote(Lote lote) {
	this.lote = lote;
    }

    @Override
    public String toString() {
	return "Almacen{" + 
		"codigo_alm=" + this.getCodigo_alm() + '\'' +
		", nombre_alm=" + this.getNombre_alm() + 
		", lote=" + this.getLote().getId_lot() + '}';
    }
    
    
    
}
