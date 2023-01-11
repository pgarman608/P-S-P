/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

public class Escritor extends Thread{
    private String nombre;
    private String texto;
    private Monitor monitor;
    /**
     * Este es el constructor por parametro del escritor donde vamos a guardar
     * @param nombre - Nombre del Escritor
     * @param texto - Texto que vamos a escribir
     * @param monitor - El Monitor que usaremos para escribir en el fichero
     */
    public Escritor(String nombre, String texto, Monitor monitor) {
        this.nombre = nombre;
        this.texto = texto;
        this.monitor = monitor;
    }
    /**
     * Este metodo sobreEscrito de la clase Thread llamado run que nos permite
     * generar un hilo.
     * En este hilo tendrémos que escribir el texto entero en un fichero.
     * Para ello tendremos que llamar al metodo del monitor llamado escribirTexto
     */
    @Override
    public void run() {
        //Este bucle dara vueltas haste un total del numero de letras del texto
        for (int i = 0; i < texto.length(); i++) {
            //Generaremos un numero random entre el 3 y el 1
            int tiempo = (int) (Math.random() * (4 - 1)) + 1;
            //Guardaremos el string con la parte que nos interese en una array de caracteres 
            char[] letras = texto.substring(0,i+1).toCharArray();
            //Llamaremos al metodo escribirTexto que le pasaremos por parametro 
            //el array de caracteres
            monitor.escribirTexto(letras);
            //Le pondremos un tiempo de espera que este entre 1 y 3 segundos
            try {
                Thread.sleep(tiempo + 1000);
            } catch (InterruptedException ex) {
            System.out.println("Error de interrupcion del escritor");
            }
            //Sacaremos por pantalla que ha escrito el escritor y su nombre
            System.out.println("El Escritor " + nombre + " ha escrito " + texto.substring(0,i+1));
        }
    }
}
