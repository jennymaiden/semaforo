/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semaforo;

import java.io.IOException;
import presentacion.Modelo;

/**
 *
 * @author cvelez
 */
public class Semaforo {
    
    private final Modelo miSemaforo;

    public Semaforo() throws IOException {
        miSemaforo = new Modelo();
        miSemaforo.iniciar();
        miSemaforo.conectarClientes(1);
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Semaforo();
    }
    
}
