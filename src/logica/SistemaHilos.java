/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

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
        
//        ConexionCliente cliente = new ConexionCliente();
//        cliente.ejecutarConexion("localhost", 5050, nombre);
        
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
