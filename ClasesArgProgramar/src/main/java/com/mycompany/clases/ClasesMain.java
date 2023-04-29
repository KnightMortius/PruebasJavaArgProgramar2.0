package com.mycompany.clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasesMain {
    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("items.txt");
        Scanner entrada = new Scanner(archivo);
        Carrito carrito = new Carrito();
        entrada.nextLine();
        
        while (entrada.hasNextLine()) {
            String linea = entrada.nextLine();
            String[] campos = linea.split(" ");
            
            int cantidad = Integer.parseInt(campos[0]);
            double precio = Double.parseDouble(campos[1]);
            String nombre = campos[2];
            
            Producto producto = new Producto(nombre, precio);
            ItemCarrito item = new ItemCarrito(producto, cantidad);
            
            carrito.agregarItem(item);
        }
        double precioTotal = carrito.getTotal();
        System.out.println("El precio total del carrito es: " + precioTotal);
        
        DescuentoMonto descontarMonto = new DescuentoMonto("Descuento de $50", 50);
        System.out.println("Se le descuenta un monto de $50 pesos y le quedaria: " + descontarMonto.aplicarDescuento(precioTotal));
        
        double precioFinal = descontarMonto.aplicarDescuento(precioTotal);
    
        DescuentoPorcentaje descontarPorcentaje = new DescuentoPorcentaje("Descuento del 10%", 10);
        System.out.println("Se le descontara un 10% del precio actual mas el monto de 50$ y quedaria: " + descontarPorcentaje.aplicarDescuento(precioFinal));
    }
}
