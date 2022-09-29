/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Willydmq
 */
public abstract class Producto {

    private String id_pro;
    private String nombre_pro;
    private double temperatura_pro;
    private double valorBase_pro;
    private double costo = 0;

    public Producto(String id_pro, String nombre_pro, double temperatura_pro, double valorBase_pro) {
	this.id_pro = id_pro;
	this.nombre_pro = nombre_pro;
	this.temperatura_pro = temperatura_pro;
	this.valorBase_pro = valorBase_pro;
    }

    public Producto(String nombre_pro, String id_pro) {
	this.id_pro = id_pro;
	this.nombre_pro = nombre_pro;
    }

    public Producto(String nombre_pro) {
	this.nombre_pro = nombre_pro;
    }

//    public Producto(String id_pro) {
//	this.id_pro = id_pro;
//    }

    public Producto() {
    }

    public double calcularCostoDeAlmacenamiento() {
	if (temperatura_pro < 0) {
	    costo = valorBase_pro * 0.1;
	} else {
	    costo = valorBase_pro * 0.2;
	}
	return costo;
    }

    public String getId_pro() {
	return id_pro;
    }

    public void setId_pro(String id_pro) {
	this.id_pro = id_pro;
    }

    public String getNombre_pro() {
	return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
	this.nombre_pro = nombre_pro;
    }

    public double getTemperatura_pro() {
	return temperatura_pro;
    }

    public void setTemperatura_pro(double temperatura_pro) {
	this.temperatura_pro = temperatura_pro;
    }

    public double getValorBase_pro() {
	return valorBase_pro;
    }

    public void setValorBase_pro(double valorBase_pro) {
	this.valorBase_pro = valorBase_pro;
    }

    @Override
    public String toString() {
	return nombre_pro;
//        return "Producto{" + 
//                "id_pro=" + this.getId_pro() + '\'' +
//                ", nombre_pro=" + this.getNombre_pro() + '\'' +
//                ", temperatura_pro=" + this.getTemperatura_pro() + '\'' +
//                ", valorBase_pro=" + this.getValorBase_pro() + '}';
    }

//    @Override
//    public String toString() {
//	return this.id_pro;
//    }
    
}

