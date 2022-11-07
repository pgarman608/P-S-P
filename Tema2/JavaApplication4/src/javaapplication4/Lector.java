/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;
public class Lector extends Thread{
    private String Nombre;
    private int numLetrasleer;

    public Lector(String Nombre, int numLetrasleer) {
        this.Nombre = Nombre;
        this.numLetrasleer = numLetrasleer;
    }

    @Override
    public void run() {
        
    }
    
}
