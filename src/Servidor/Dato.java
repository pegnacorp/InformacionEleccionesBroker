/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author user
 */
public class Dato {
    private String nombre;
    private int cantidad;

    public Dato(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
