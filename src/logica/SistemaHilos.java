/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cvelez
 */
public class SistemaHilos  extends Thread{
    
    private String nombre;
    private String msg;

    public SistemaHilos(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        
        SistemaCliente cliente;
        try {
            cliente = new SistemaCliente();
            cliente.startClient(this.nombre);
            System.out.println ("Hola soy el cliente: "+this.nombre);
        } catch (IOException ex) {
            Logger.getLogger(SistemaHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
