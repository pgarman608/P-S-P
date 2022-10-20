/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serrperry
 */
public class CCompartido {
    private int tamanio;
    private char[] recurso;
    private int pos;
    private boolean vacio;
    private boolean lleno;
    public CCompartido(){
        this.tamanio = 10;
        this.recurso = new char[10];
        this.vacio = true;
        this.lleno = false;
        this.pos = 1;
    }
    public synchronized void añadirRecuso(char anadir){
        while(lleno == true){
            try {
                wait();
                System.out.println("El vendedor esta esperando");
            } catch (InterruptedException ex) {
                System.out.println("Error de interupcion");;
            }
        }
        vacio = false;
        recurso[pos-1] = anadir;
        pos++;
        if(pos == tamanio){
            lleno = true;
        }
        notify();
    }
    public synchronized void eliminarRecurso(){
        while(vacio == true){
            try {
                wait();
                System.out.println("El comprador esta esperando");
            } catch (InterruptedException ex) {
                System.out.println("Error de interrupcion");
            }
        }
        recurso[pos-1] = ' ';
        pos--;
        if (pos == 1) {
            vacio = true;
        }
        notify();
    }
}
