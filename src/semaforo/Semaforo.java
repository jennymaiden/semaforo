/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semaforo;

import java.io.IOException;
import presentacion.Modelo;
import presentacion.cliente2.Modelo2;
import presentacion.cliente3.Modelo3;

/**
 *
 * @author cvelez
 */
public class Semaforo {
    
    private final Modelo miSemaforo;
    private final Modelo2 miSemaforo2;
    private final Modelo3 miSemaforo3;

    public Semaforo() throws IOException {
        miSemaforo = new Modelo();
        miSemaforo.iniciar();
        miSemaforo2 = new Modelo2();
        miSemaforo2.iniciar();
        miSemaforo3 = new Modelo3();
        miSemaforo3.iniciar();      
        miSemaforo.conectarClientes(1);
        miSemaforo2.conectarClientes(2);
        miSemaforo3.conectarClientes(3);
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Semaforo();
    }
    
}
