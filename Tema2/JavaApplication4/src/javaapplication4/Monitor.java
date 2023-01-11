
package javaapplication4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Monitor {
    private boolean vacio;
    public File archivo;
    private int escritor;
    private FileReader fileR;
    private BufferedReader bufferedR;
    private FileWriter fileW;
    private int lector;
    /**
     * ste es el constructor por parametro del monitor donde vamos a guardar
     * @param archivo En donde vamos a leer y escribir el texto
     */
    public Monitor(File archivo) {
        this.archivo = archivo;
        this.vacio = true;
        escritor = 0;
        lector = 0;
    }
    /**
     * En este metodo escribiremos el array de char introducido por parametro
     * en el fichero anteriormente seleccionado
     * @param letras El array de caracteres que introducimos en el texto
     */
    public synchronized void escribirTexto(char[] letras){
        //Comprobamos que ningun escritor este escribiendo
        if (escritor == 0) {
            //Decimos que el escritor esta escribiendo
            escritor = 1;
            try {
                //Tendremos un fileWriter para escribir en el codigo
                this.fileW = new FileWriter(archivo);
                //Escribimos el array de char
                fileW.write(letras);
                //Cerramos el filewriter
                fileW.close();
                //Le decimos que ya no hay nadie escribiendo
                escritor = 0;
            } catch (IOException ex) {
                System.out.println("Error de I/O en escribirTexto()");
            }
        }else{
            //Si hay algien escribiendo que espere a que lo llamen
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error de interrupcion en escribirTexto()");
            }
        }
        //Si el archivo no esta vacio pondremos vacio en false
        if (archivo.length()>0) { 
           vacio = false;
        }
        //Notificamos a los demas hilos
        notify();
    }
    /**
     * En este metodo leeremos el texto introducido en el fichero anteriormente
     * guardado
     * @return Devolveremos el texto leido
     */
    public synchronized String leerTexto(){
        //Tendremos un textoLeido y un textoTemp para comprobar errores
        String textoLeido = "";
        String textoTemp = "";
        //Tendremos una variable en la queguardaremos el numero de bits del archivos
        long tamanio = archivo.length();
        //Este sout es muy necesario para que no de errores, no me preguntes porque ni como lo se
        //pero gracias a este sout funciona mejor
        System.out.println("");
        //Comprobaremos que el escritor no esta escribiendo , que no tengamos ningun lector leyendo
        //a la vez que otro y que no este vacio
        if (tamanio>0 && escritor == 0 && !vacio && lector == 0 && fileW != null) {
            //Le diremos que hay un lector leyendo
            lector = 1;
            try{
                //Tendremos un filereader y un bufferedReader para leer lineas del 
                //fichero
                this.fileR = new FileReader(archivo);
                this.bufferedR = new BufferedReader(fileR);
                //Leeremos la linea y la guardaremos en el textoTemp
                textoTemp = bufferedR.readLine();
                //Cerramos los lectores
                bufferedR.close();
                fileR.close();
                //Diremos que no hay ningun lector leyendo
                lector = 0;
                //Comprobaremos que el texto leido no es nul ni esta vacio
                if (textoTemp != null && !textoTemp.equals("")) {
                    //Guardaremos el textoTemp en textoLeido
                    textoLeido = textoTemp;
                }else{
                    //Esperaremos a que otro hilo nos llame
                    wait();
                }  
            } catch (FileNotFoundException ex) {
                System.out.println("Error de fichero no encontrado");
            } catch (IOException ex) {
                System.out.println("Error de IO en LeerTexto");
            } catch (InterruptedException ex) {
                System.out.println("Error de interupcion de leertexto");;
            }
        }else{
            try {
                //Esperaremos a que otro hilo nos llame
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error de interrupcion en leerTexto()");
            }
        }
        //Devolveremos el textoLeido;
        return textoLeido;
    }
}
