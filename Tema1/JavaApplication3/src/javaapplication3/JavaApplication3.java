/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaApplication3 {

        public static void lanzarSumador(
            File f, String fichResultados) throws IOException {
            String comando;
            comando = "javaapplication3.Sumatorio";
            File directorioSumador;
            directorioSumador = new File(".");
            File fichResultado = new File(fichResultados);
            ProcessBuilder pb;
            pb = new ProcessBuilder("java",
                    comando,
                    String.valueOf(f.getAbsoluteFile()));
            pb.directory(new File(System.getProperty("java.class.path")));
            pb.redirectError(new File("error.txt"));
            pb.redirectOutput(fichResultado);
            Process p = pb.start();
            try {
                p.waitFor();
            } catch (InterruptedException ex) {
                System.out.println("Error de interpcion");;
            }
        }
    public static void main(String[] args) throws IOException,InterruptedException{
        File f1 = new File("rrhh.txt");
        lanzarSumador(f1, "result1.txt");
        File f2 = new File("comercio.txt");
        lanzarSumador(f2, "result2.txt");
        File f3 = new File("contabilidad.txt");
        lanzarSumador(f3, "result3.txt");
        File f4 = new File("gerencia.txt");
        lanzarSumador(f4, "result4.txt");
        File f5 = new File("informatica.txt");
        lanzarSumador(f5, "result5.txt");
        String[] aux = new String[5];
        aux[0] = "result1.txt";
        aux[1] = "result2.txt";
        aux[2] = "result3.txt";
        aux[3] = "result4.txt";
        aux[4] = "result5.txt";
        int fin = result(aux);
        System.out.println(fin);
    }
    private static int result(String[] ficheros){
        int aux = 0;
        for (int i = 0; i < ficheros.length; i++) {
            File f = new File(ficheros[i]);
            try {
                FileReader fr1 = new FileReader(f);
                BufferedReader br = new BufferedReader(fr1);
                aux += Integer.parseInt(br.readLine());
            } catch (FileNotFoundException ex) {
                System.out.println("No se encuentra");
            } catch (IOException ex) {
                System.out.println("Error de IO");
            }
        }
        return aux;
    }
}
