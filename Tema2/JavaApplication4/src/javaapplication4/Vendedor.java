/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author Serrperry
 */
public class Vendedor extends Thread{
    private String nombre;
    private final String RECURSOS = "ABCDEFGHIJKLMN";
    private CCompartido recursos;
    public Vendedor(String nombre, CCompartido recursos){
        this.nombre = nombre;
        this.recursos = recursos;
    }
    @Override
    public void run(){
        int vueltas = (int)((Math.random()*(12 - 1))+1);
        System.out.println(vueltas + "Vendededor");
        for (int i = vueltas; i > 0; i--) {
            char guardar = RECURSOS.charAt((int)((Math.random()*(RECURSOS.length() - 0))+0));
            this.recursos.añadirRecuso(guardar);
            System.out.println("El vendedor " + nombre + "a añadido el producto (" + guardar +")");
        }
        System.out.println(nombre + " ha terminado");
    }
}
