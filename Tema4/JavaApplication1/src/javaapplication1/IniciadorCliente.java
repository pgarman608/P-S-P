
package javaapplication1;

import java.io.IOException;
public class IniciadorCliente {
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            System.out.println("Iniciar el cliente");
            cliente.startCliente();
        } catch (IOException ex) {
            System.out.println("Error de " + ex.getMessage());
        }
        
    }
}
