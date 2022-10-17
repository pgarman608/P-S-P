
package javaapplication3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Pablo García Manzano y Alvaro García Ruiz
 */
public class Sumatorio {
    //Metodo que nos da la suma de los valores dentro de un fichero
    public static int getResultadoFichero(File nombreFichero) {
            int numeros = 0;
            File f1 = nombreFichero;
            FileReader fr1 = null;
            try {
                fr1 = new FileReader(f1);
                int num = fr1.read();
                //Leemos numeros hasta que se acaben
                while(num != -1){
                    if (num != 13 && num != 10) {
                        //Pasamos el valor a char para aislar los numeros y despues a int para almavenarlo
                        numeros += Integer.parseInt(""+(char) num);
                    }
                    num = fr1.read();
                }
            } catch (IOException ex) {
                System.out.println("Error de I/O");
            }
        try {
            //Cerraremos el FileReader
            fr1.close();
        } catch (IOException ex) {
            System.out.println("Error de I/O");
        }
            return numeros;
        }
    public static void main(String[] args) {
        //Leeremos el String anteriormente pasado por parametro y lo convertiremos
        //en un cursor
        File f = new File(String.valueOf(args[0]));
        //Pasaremos ese fichero como parametro del getresultadoFichero y 
        //devolveremos el resultado en int del metodo
        int num = getResultadoFichero(f);
        //El numero anterior lo escribiremos por pantalla
        System.out.println(num);
        System.out.flush();
    }
}