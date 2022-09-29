/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class ProductoNoRefrigerado extends Producto{

    public ProductoNoRefrigerado(String id_pro, String nombre_pro, double temperatura_pro, double valorBase_pro) {
	super(id_pro, nombre_pro, temperatura_pro, valorBase_pro);
    }
    
    

    @Override
    public double calcularCostoDeAlmacenamiento() {
        double costo = 0;
        costo = getValorBase_pro() * 110/100;
        return costo;
        //return super.calcularCostoDeAlmacenamiento(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
