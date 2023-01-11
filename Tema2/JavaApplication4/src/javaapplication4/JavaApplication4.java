package javaapplication4;

import java.io.File;

/**
 * @author Pablo García Manzano
 */
public class JavaApplication4 {
    /**
     * @param args Main
     */
    public static void main(String[] args) {
        //Generamos el fichero que querramos leer y escribir
        File fichero = new File("prueba.txt");
        //Generaremos el monitor con ese fichero
        Monitor monitor = new Monitor(fichero);
        //Gemeraremos los lectores
        Lector lector1 = new Lector("Pablo",5,monitor);
        Lector lector2 = new Lector("Juan",6,monitor);
        Lector lector3 = new Lector("Steve",4,monitor);
        //Generaremos los escritores
        Escritor escritor1 = new Escritor("Elena", "Buenas noches", monitor);
        Escritor escritor2 = new Escritor("Mario", "Buenas noches", monitor);
        //Le pondremos ms prioridad a los lectores y menos a los escritores
        lector1.setPriority(6);
        lector2.setPriority(6);
        lector3.setPriority(6);
        escritor1.setPriority(5);
        escritor2.setPriority(5);
        //Empezaremos a leer y escribir con .start()
        lector1.start();
        lector2.start();
        lector3.start();
        escritor1.start();
        escritor2.start();
    }
}