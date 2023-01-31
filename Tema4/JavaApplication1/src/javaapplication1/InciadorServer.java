package javaapplication1;

import java.io.IOException;

public class InciadorServer {
    public static void main(String[] args) {
        try {
            //Tendremos un main para iniciar el server 
            Servidor servidor = new Servidor();
            System.out.println("Iniciador del servidor");
            servidor.startServer();
        } catch (IOException ex) {
            System.out.println("Error de " + ex.getMessage());
        }
    }
}
