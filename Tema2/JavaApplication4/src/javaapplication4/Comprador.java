/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author Serrperry
 */
public class Comprador extends Thread{
    private String nombre;
    private CCompartido recursos;

    public Comprador(String nombre, CCompartido recursos) {
        this.nombre = nombre;
        this.recursos = recursos;
    }
    @Override
    public void run(){
        int vueltas = (int)((Math.random()*(12 - 1))+1);
        System.out.println(vueltas + " comprador ");
        for (int i = vueltas; i > 0; i--) {
            this.recursos.eliminarRecurso();
            System.out.println("El comprador " +nombre+ " ha recogido su producto");
        }
        System.out.println(nombre + " ha terminado");
    }
}
