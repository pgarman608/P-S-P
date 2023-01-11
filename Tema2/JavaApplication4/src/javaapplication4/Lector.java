/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

public class Lector extends Thread{
    private String nombre;
    private int numLetrasleer;
    private Monitor monitor;
    /**
     * Este es el constructor por parametro del lactor donde vamos a guardar
     * @param nombre - Nombre del Lector
     * @param numLetrasleer - Numero de letras a leer
     * @param monitor - El monitor donde leeremos datos
     */
    public Lector(String nombre, int numLetrasleer, Monitor monitor) {
        this.nombre = nombre;
        this.numLetrasleer = numLetrasleer;
        this.monitor = monitor;
    }
    /**
     * 
     */
    @Override
    public void run() {
        boolean terminar = true;
        String textoLeido = null;
        for (int i = 0; i < numLetrasleer; i++) {
            textoLeido = monitor.leerTexto();
            int tiempo = (int) (Math.random() * (6 - 2)) + 2;
            System.out.println("El lector " + nombre + " a leido " + textoLeido);
            try {
                Thread.sleep(tiempo + 1000);
            } catch (InterruptedException ex) {
                System.out.println("Error de interrupcion en el lector");;
            }
        }
    }
}