package com.mycompany.clases;

public class DescuentoPorcentaje extends Descuento {
    private double porcentaje;
    
    public DescuentoPorcentaje(String nombre, double porcentaje) {
        super(nombre);
        this.porcentaje = porcentaje;
    }
    
    @Override
    public double aplicarDescuento(double total) {
        return total * (1 - porcentaje/100);
    } 
}
