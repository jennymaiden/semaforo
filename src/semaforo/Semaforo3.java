/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semaforo;

import java.io.IOException;
import presentacion.cliente3.Modelo3;

/**
// *
 * @author cvelez
 */
public class Semaforo3 {
    
    private final Modelo3 miSemaforo3;
    
    
    public Semaforo3() throws IOException{

        this.miSemaforo3 = new Modelo3();
        miSemaforo3.iniciar();
        //miSemaforo3.conectarClientes(1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Semaforo3();
    }
}
