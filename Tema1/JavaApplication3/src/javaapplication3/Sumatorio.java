/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author 
 */
public class Sumatorio {
    public static int getResultadoFichero(File nombreFichero) {
            int numeros = 0;
            File f1 = nombreFichero;
            FileReader fr1;
            try {
                fr1 = new FileReader(f1);
                int num = fr1.read();
                while(num != -1){
                    if (num != 13 && num != 10) {
                        numeros += Integer.parseInt(""+(char) num);
                    }
                    num = fr1.read();
                }
            } catch (IOException ex) {
                System.out.println("Error de I/O");
            }
            return numeros;
        }
    public static void main(String[] args) {
        File f = new File(String.valueOf(args[0]));
        int num = getResultadoFichero(f);
        System.out.println(num);
        System.out.flush();
    }
}

