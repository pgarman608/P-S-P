package com.example.socket_whatsapp.controladores;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.socket_whatsapp.modelos.Datos;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.ClosedFileSystemException;
import java.util.logging.LogRecord;

public class Interconexion implements Runnable {
    private static final int PORT = 1234;

    private static Socket socket;
    private static ObjectOutputStream paqueteria_salida;
    private static ObjectInputStream paqueteria_entrada;

    private Runnable run;

    private String mensaje;
    private Handler handler;

    public Interconexion(){
        this.mensaje = "";
        handler = new Handler();

    }

    public static void exportar(Datos datos, String ip, Context context){
        Thread hiloExportar = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socketEnviar = new Socket(ip, PORT);
                    ObjectOutputStream paqueteria = new ObjectOutputStream(socketEnviar.getOutputStream());
                    paqueteria.writeObject(datos);
                    socketEnviar.close();
                    Log.i("Exportar", "run: Exportacion exitosa");
                }catch (Exception ex) {
                    ex.printStackTrace();
                    Log.i("Exportar", "run: Error al exportar "+ ex.getMessage());
                }
            }
        });
        hiloExportar.start();
    }
    public void setRunUI(Runnable run){
        this.run = run;
    }
    public void startRun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    ServerSocket serverSocket = new ServerSocket(PORT);
                    int cont = 1;
                    while (true){
                        Socket cliente = serverSocket.accept();
                        Log.i("asd", "run: " + cont);
                        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                        Datos datosEntrada = (Datos) flujoEntrada.readObject();
                        mensaje = datosEntrada.toString();
                        handler.post(run);
                        cliente.close();
                        flujoEntrada.close();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }).start();

    }
    @Override
    public void run() {

        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            Log.i("asd", "run: ");
            while (true){
                Socket cliente = serverSocket.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                Datos datosEntrada = (Datos) flujoEntrada.readObject();
                mensaje = datosEntrada.toString();
                handler.post(run);
                flujoEntrada.close();
                cliente.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
