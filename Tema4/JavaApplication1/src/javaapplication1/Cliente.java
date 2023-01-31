package javaapplication1;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion{
    //Crearemos el constructor por defecto donde llame al constructor por parametro de la conexion
    public Cliente() throws IOException{
        //Le diremos al constructor que seremos un cliente
        super("cliente");
    }
    //Método en el cual iniciaremos y terminaremos la conexion terminaba
    public void startCliente(){
        try {
            //Crearemos el flujo de del servidor al cliente
            salidaServidor = new DataOutputStream(clienteS.getOutputStream());
            //Le enviaremos 2 mensajes
            for (int i = 0; i < 2; i++) {
                salidaCliente.writeUTF("Este mensaje es el: " + i);
            }
            //Cerraremos la conexion con el servidor
            clienteS.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
   
    }
}
