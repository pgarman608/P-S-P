package com.example.socket_whatsapp.controladores;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socket_whatsapp.R;
import com.example.socket_whatsapp.modelos.Datos;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {


    private EditText nombreDes;
    private EditText ipDes;
    private EditText nombreYo;
    private EditText ipYO;
    private EditText mensaje;
    private TextView txtbox;
    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nombreDes = (EditText) findViewById(R.id.nombreDes);
        this.ipDes = (EditText) findViewById(R.id.ipDes);
        this.nombreYo = (EditText) findViewById(R.id.nombreYO);
        this.ipYO = (EditText) findViewById(R.id.ipYO);
        this.mensaje = (EditText) findViewById(R.id.mensaje);
        this.enviar = (Button) findViewById(R.id.enviar);
        this.txtbox = (TextView) findViewById(R.id.txtBox);

        this.ipYO.setText(getUserIpAddress());
        Interconexion interconexion = new Interconexion();
        interconexion.setRunUI(new Runnable() {
            @Override
            public void run() {
                txtbox.append("\n " + interconexion.getMensaje());
            }
        });
        interconexion.startRun();
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datos datosMandar = new Datos(nombreYo.getText().toString(),ipYO.getText().toString(),mensaje.getText().toString());
                Interconexion.exportar(datosMandar,ipDes.getText().toString(),MainActivity.this);
            }
        });
    }

    private String getUserIpAddress(){
        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);

        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }

}
/****Thread hiloServer = new Thread(new Runnable() {
@Override
public void run() {
interconexion.run();
}
});*/