/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Dependiente extends Thread{
    private String nombre;
    private Cliente cliente;
    public Dependiente(String nombre, Cliente cliente){
        this.cliente = cliente;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < this.cliente.getCompra().size(); i++) {
            int aux2 = this.cliente.getCompra().get(i);
            int aux = aux2 * 1000;
            try {
                Thread.sleep(aux);
            } catch (InterruptedException ex) {
                Logger.getLogger(Dependiente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("El dependiente " + this.nombre + " ha pasado el producto " + this.cliente.getCompra().get(i)
                    + " del cliente " + this.cliente.getNombre());
        }
    }
}
