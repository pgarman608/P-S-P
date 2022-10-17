
package javaapplication3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Pablo García Manzano y Alvaro García Ruiz
 */
public class JavaApplication3 {
    //Creamos un metodo para lanzar el sumador
        public static void lanzarSumador(
            File f, String fichResultados) throws IOException {
            String comando;
            //Tomamos el nombre del sumatorio
            comando = "javaapplication3.Sumatorio";
            File directorioSumador;
            //Sacamos la ruta del sumatorio
            directorioSumador = new File(".");
            File fichResultado = new File(fichResultados);
            ProcessBuilder pb;
            //Declaramos un ProcessBuilder 
            pb = new ProcessBuilder("java",
                    comando,
                    String.valueOf(f.getAbsoluteFile()));
            pb.directory(new File(System.getProperty("java.class.path")));
            //Redirigimos los errores a un fichero que mostrara los errores
            pb.redirectError(new File("error.txt"));
            //Redirigimos la salida a un fichero que mostrara los resultados
            pb.redirectOutput(fichResultado);
            //Inicializamos un proceso con el inicio  del ProcessBuilder
            Process p = pb.start();
            try {
                //Tendremos Que esperar a que los proceso terminen para hacer
                //hacer utilziar sus resultados
                p.waitFor();
            } catch (InterruptedException ex) {
                System.out.println("Error de interpcion");
            }
        }
    public static void main(String[] args){
        //Elegiremos los ficheros donde queremos sumar su contenido
        File f1 = new File("rrhh.txt");
        File f2 = new File("comercio.txt");
        File f3 = new File("contabilidad.txt");
        File f4 = new File("gerencia.txt");
        File f5 = new File("informatica.txt");
        try {
            //Iniciaremos los lanzadores con los ficheros anteriores y donde vamos
            //a sacar los resultados
            lanzarSumador(f1, "result1.txt");
            lanzarSumador(f2, "result2.txt");
            lanzarSumador(f3, "result3.txt");
            lanzarSumador(f4, "result4.txt");
            lanzarSumador(f5, "result5.txt");
        } catch (IOException ex) {
            System.out.println("Error de I/0");
        }
        //Tomamos los archivos y los metemos en un array para utilizar el metodo result
        String[] resultados = new String[5];
        resultados[0] = "result1.txt";
        resultados[1] = "result2.txt";
        resultados[2] = "result3.txt";
        resultados[3] = "result4.txt";
        resultados[4] = "result5.txt";
        //Pasaremos el array de resultados (String) y recogeremos el resultado
        int fin = result(resultados);
        System.out.println("El resultado final es: " + fin);
    }
    //Metodo para sacar el resultado de la suma de un array de ficheros
    private static int result(String[] ficheros){
        //Auxiliar tomado para sumar
        int resultf = 0;
        //Tendremos un for con el limite  del array de String de los parametros
        for (int i = 0; i < ficheros.length; i++) {
            //Crearemos un puntero a un fichero del array 
            File f = new File(ficheros[i]);
            try {
                //Crearemos un Filereader y un bufferedreader para leer lineas
                //del fichero
                FileReader fr1 = new FileReader(f);
                BufferedReader br = new BufferedReader(fr1);
                //Leeremos una linea, se la sumamos al aux pasandolo a int
                resultf += Integer.parseInt(br.readLine());
                //Cerraremos el filereader y bufferedreader
                fr1.close();
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("No se encuentra");
            } catch (IOException ex) {
                System.out.println("Error de IO");
            }
        }
        return resultf;
    }
}