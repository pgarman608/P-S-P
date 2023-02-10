package com.example.socket_whatsapp.modelos;

import java.io.Serializable;

public class Datos implements Serializable {
    private String nombre, ip, mensaje;

    public Datos(String nombre, String ip, String mensaje){
        this.nombre = nombre;
        this.ip = ip;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return nombre + "/" + ip + " : " + mensaje;
    }
}
