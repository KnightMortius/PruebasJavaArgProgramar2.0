package com.mycompany.clases;

public class DescuentoMonto extends Descuento {
    private double monto;
    
    public DescuentoMonto(String nombre, double monto) {
        super(nombre);
        this.monto = monto;
    }
    
    @Override
    public double aplicarDescuento(double total) {
        return total - monto;
    }
}
