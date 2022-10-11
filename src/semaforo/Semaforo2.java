/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semaforo;

import java.io.IOException;
import presentacion.cliente2.Modelo2;

/**
 *
 * @author cvelez
 */
public class Semaforo2 {
    
    private final Modelo2 miSemaforo2;

    public Semaforo2() throws IOException{

        this.miSemaforo2 = new Modelo2();
        miSemaforo2.iniciar();
        //miSemaforo2.conectarClientes(1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Semaforo2();
    }
}
