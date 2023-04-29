package com.mycompany.clases;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;
    
    public Carrito() {
        this.items = new ArrayList<>();
    }

    public Carrito(List<ItemCarrito> items) {
        this.items = items;
    }
    
    public void agregarItem(ItemCarrito item) {
        items.add(item);
    }
    
    public void eliminarItem(ItemCarrito item) {
        items.remove(item);
    }
    
    public double getTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getTotal();
        }
        return total;
    }
}
