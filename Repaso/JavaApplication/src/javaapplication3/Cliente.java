/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Cliente {
    private String nombre;
    private ArrayList<Integer> compra;
    public Cliente(String nombre,ArrayList<Integer> compra){
        this.nombre = nombre;
        this.compra = compra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getCompra() {
        return compra;
    }

    public void setCompra(ArrayList<Integer> compra) {
        this.compra = compra;
    }
    
}
