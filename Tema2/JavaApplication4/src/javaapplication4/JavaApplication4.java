package javaapplication4;
/**
 * @author usuario
 */
public class JavaApplication4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CCompartido cc = new CCompartido();
        
        Vendedor v1 = new Vendedor("Pedro",cc);
        Comprador c1 = new Comprador("Pablo", cc);
        
        v1.start();
        c1.start();
    }
}   