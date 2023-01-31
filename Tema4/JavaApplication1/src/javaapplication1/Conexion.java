
package javaapplication1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    //Tendremos el puerto donde realizaremos la conexion
    private final int PUERTO = 4411;
    //Tendremos el host para la conexion
    private final String HOST = "localhost";
    //Mensaje entrante al server
    protected String mensajeS;
    //Sockets del servidor y del cliente
    protected ServerSocket serverS;
    protected Socket clienteS;
    //El flujo de datos del server con el cliente y del cliente con el servidor
    protected DataOutputStream  salidaServidor, salidaCliente;
    //Tendremos un constructor con un parametro con un string con el *tipo*
    public Conexion(String tipo) throws IOException{
        //El tipo metido por parametro es para saber que queremos hacer un 
        //servidor con cliente o solo el cliente
        if (tipo.equalsIgnoreCase("servidor")) {
            //Se creara un socket para el servidor cogiendo el puerto
            serverS = new ServerSocket(PUERTO);
            //Se creara un socket con el cliente
            clienteS = new Socket();
        }else{
            //Crearemos un socket cliente con el host con el puerto
            clienteS  = new Socket(HOST, PUERTO);
        }
    }
}
