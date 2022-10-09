/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author cvelez
 */
public class SistemaCliente extends ConexionCliente{

//    public SistemaCliente() throws IOException{super("localhost", 1234, "cliente");} //Se usa el constructor para cliente de ConexionCliente
//
//    
//    public Socket socket;
//    private DataInputStream datosEntrada;
//    private DataOutputStream datosSalida;
//
//    public void startClient(String nombreCliente) //Método para iniciar el cliente
//    {
//        try
//        {
//            //capturar los flujos
//            datosEntrada = new DataInputStream(cs.getInputStream());
//            
//            //Flujo de datos hacia el servidor
//            salidaServidor = new DataOutputStream(cs.getOutputStream());
//            salidaServidor.writeUTF(nombreCliente);
////            //Se enviarán dos mensajes
////            for (int i = 0; i < 2; i++)
////            {
////                //Se escribe en el servidor usando su flujo de datos
////                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
////            }
//            
//            //Se obtiene el flujo entrante desde el cliente
//            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
//
//            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
//            {
//                //Se muestra por pantalla el mensaje recibido
//                System.out.println("Cliente: "+mensajeServidor);
//            }
//
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public void endCliente () throws IOException {
//         cs.close();//Fin de la conexión
//    }
//    
//    public void enviarMensaje (String msg) {
//    
//    }
//    
//    public String recibirMensaje () {
//        return "";
//    }

}
