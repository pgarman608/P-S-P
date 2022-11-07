/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;
public class Escritor extends Thread{
    private String Nombre;
    private String texto;
    private String libreta;

    public Escritor(String Nombre, String texto, String libreta) {
        this.Nombre = Nombre;
        this.texto = texto;
        this.libreta = libreta;
    }

    @Override
    public void run() {
        
    }
    
}
