package com.mycompany.clases;

public abstract class Descuento {
    private String nombre;
    
    public Descuento(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public abstract double aplicarDescuento(double total);
}
