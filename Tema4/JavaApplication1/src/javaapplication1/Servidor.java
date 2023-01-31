package javaapplication1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//Extenderemos de la clase anteriormente generada de la conexion
public class Servidor extends Conexion{
    //Constructor por defecto
    public Servidor() throws IOException{
        //LLamaremos a la clase Conexion y a su constructor por el parametro tipo
        super("servidor");
    }
    //Tendremos un metodo en el cual iniciaremos el Servidor
    public void startServer(){
        
        try {
            //Lanzaremos una texto en cual diremos al usuario que estaremos esperando la conexion
            System.out.println("Esperando...");
            //Le diremos al cliente que el servidor a empezado y esperaremos una conexion con el cliente
            clienteS = serverS.accept();
            //El flujo de datos de cliente al servidor lo inicalizaremos
            salidaCliente = new DataOutputStream(clienteS.getOutputStream());
            //Escribiremos un mensaje al usuario diciendo que la peticion a sido recibida y aceptada
            salidaCliente.writeUTF("Peticion recivida y aceptada");
            //Leeremos el flujo entrante del cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteS.getInputStream()));
            while ((mensajeS = entrada.readLine()) != null) {
                //Se mostrara por pantalla el mensaje enviado del cliente
                System.err.println(mensajeS);
            }
            //Terminaremos la conexion con un mensaje
            System.out.println("Fin de la conexión");
            //Cerrarmos la conexion
            serverS.close();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
