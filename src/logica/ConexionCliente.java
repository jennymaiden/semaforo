/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import persistencia.Dispositivo;
import presentacion.Modelo;
import static semaforo.testCliente.mostrarTexto;

/**
 *
 * @author cvelez
 */
public class ConexionCliente {

    public String host; //IP del servidor al que me quiero conectar
    public int puerto;
    protected ServerSocket socketServidor; //Socket del servidor
    protected Socket socketCliente; //Socket del cliente
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    final String COMANDO_TERMINACION = "salir()";
    Scanner teclado = new Scanner(System.in);
    public String estado;
    private final Modelo modelo;

    public ConexionCliente(Modelo modelo) {
        this.modelo = modelo;
    }

    

    public void levantarConexion(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
        try {
            socketCliente = new Socket(this.host, this.puerto); //Socket para el cliente en localhost en puerto 1234
            mostrarTexto("Conectado a :" + socketCliente.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepción al levantar conexión: " + e.getMessage());
            System.exit(0);
        }

    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socketCliente.getInputStream());
            bufferDeSalida = new DataOutputStream(socketCliente.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
            System.out.print("[Usted] => ");
            mostrarTexto(s);
            
        } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socketCliente.close();
            mostrarTexto("Conexión terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        } finally {
            System.exit(0);
        }
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Servidor] => " + st);
                //Enviar la señal al modelo
                modelo.leerEstados(st);

                //System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
        }
    }

    public void escribirDatos(String msg) {
        //String entrada = "";
        while (true) {
            System.out.print("[Usted] => ");
            //entrada = teclado.nextLine();
            if (msg.length() > 0) {
                enviar(msg);
            }
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    

}
