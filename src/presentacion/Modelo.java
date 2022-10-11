/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import logica.ConexionCliente;
import org.json.JSONArray;
import org.json.JSONObject;

import persistencia.Dispositivo;
import persistencia.Vehicular;
import semaforo.Semaforo;

/**
 *
 * @author cvelez
 */
public class Modelo {

    private VistaSimulacion ventanaSimulacion;
    private List<Dispositivo> listSemaforos;

    private ConexionCliente cliente;

    public VistaSimulacion getVistaSimulacion() {

        if (ventanaSimulacion == null) {
            ventanaSimulacion = new VistaSimulacion(this);
        }
        return ventanaSimulacion;
    }

    public void iniciar() {
        getVistaSimulacion().setSize(1000, 600);
        getVistaSimulacion().setVisible(true);
        getVistaSimulacion().setLocationRelativeTo(null);
        iniciarSemaforos();
    }

    public void iniciarSemaforos() {
        listSemaforos = new ArrayList<Dispositivo>();
        
        listSemaforos.add(new Vehicular("1", false, false, false));
        listSemaforos.add(new Vehicular("4", false, false, false));
        listSemaforos.add(new Vehicular("21", false, false, false));
        listSemaforos.add(new Vehicular("24", false, false, false));
    }

    public void iniciarCliente() {
        if (cliente == null) {
            cliente = new ConexionCliente(this);
        }

        cliente.ejecutarConexion("localhost", 5050);
        //cliente.enviar("Cliente1");
        //cliente.setEstado(getEstado());
    }

    /**
     * 0	APAGADO 1	ROJO 2	AMARILLO 3	VERDE 4	ROJO-AMARILLO 5	PEATON CORRIENDO 6
     * AMARILLO INTERMITENTE
     */
    public void leerEstados(String mensaje) {
        JSONArray jsonArray = new JSONArray(mensaje);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            // Leer por grupos
            int senal = object.getInt("senal");
            int idGrupo = object.getInt("idGrupo");
            pintarEstados(senal,idGrupo);

        }
        //enviar respuesta
        cliente.enviar(getEstado());
    }

    public void pintarEstados(int senal, int grupo) {

        switch (senal) {
            case 0: //Apagado
                accionApagarTodo();
                break;
            case 1: // Rojo
                accionRojo(true, grupo);
                accionAmarilla(false, grupo);
                accionVerde(false, grupo);
                break;
            case 2: // Amarillo
                accionAmarilla(true, grupo);
                
                accionRojo(false, grupo);
                accionVerde(false, grupo);
                break;
            case 3: //Verde
                accionVerde(true, grupo);
                
                accionRojo(false, grupo);
                accionAmarilla(false, grupo);
                break;
            case 4: // ROJO-AMARILLO
                accionRojo(true, grupo);
                accionAmarilla(true, grupo);
                break;
            case 5: // PEATON CORRIENDO verdeIntermitente
                verdeIntermitente(grupo);
                accionRojo(false, grupo);
                accionAmarilla(true, grupo);
                break;
            case 6: // AMARILLO INTERMITENTE
                accionRojo(false, grupo);
                amarrilloIntermitente( grupo);
                accionVerde(false, grupo);
                break;
        }
    }

    public String getEstado() {
        // Validar cuantos grupos tengo
        JSONArray jsonArray = new JSONArray();
        for (Dispositivo dispositivo : listSemaforos) {
            JSONObject json = new JSONObject();
            json.put("idGrupo", dispositivo.getIdGrupo());
            json.put("Rojo", (dispositivo.isLuz_roja() ? "Activo" : "Apagada"));
            json.put("Amarillo", (dispositivo.isLuz_amarilla() ? "Activo" : "Apagada"));
            json.put("Verde", (dispositivo.isLuz_verde() ? "Activo" : "Apagada"));
            jsonArray.put(json);
        }

        return jsonArray.toString();
    }

    /*
    * Accion de encender o apagar la luz roja
     */
    void accionRojo(boolean accion, int grupo) {

        switch (grupo) {
            case 1:
                Dispositivo dispositivo = listSemaforos.get(0);
                dispositivo.setLuz_roja(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_img11().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_img11().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }
                listSemaforos.set(0, dispositivo);
                break;
            case 4:
                Dispositivo dispositivo2 = listSemaforos.get(1);
                dispositivo2.setLuz_roja(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }
                listSemaforos.set(1, dispositivo2);
                break;
            case 21:
                Dispositivo dispositivo3 = listSemaforos.get(2);
                dispositivo3.setLuz_roja(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup3_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_grup3_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup3_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_grup3_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }
                listSemaforos.set(2, dispositivo3);
                break;
            case 24:
                Dispositivo dispositivo4 = listSemaforos.get(3);
                dispositivo4.setLuz_roja(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup4_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_grup4_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup4_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_grup4_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }
                listSemaforos.set(3, dispositivo4);
                break;
        }
    }

    /*
    * Accion de encender o apagar la luz amarilla
     */
    void accionAmarilla(boolean accion, int grupo) {

        switch (grupo) {
            case 1:
                Dispositivo dispositivo = listSemaforos.get(0);
                dispositivo.setLuz_amarilla(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                    getVistaSimulacion().getLbl_img22().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                } else {
                    getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                    getVistaSimulacion().getLbl_img22().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                }
                listSemaforos.set(0, dispositivo);
                break;
            case 4:
                Dispositivo dispositivo2 = listSemaforos.get(1);
                dispositivo2.setLuz_amarilla(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                    getVistaSimulacion().getLbl_grup2_image_yellow1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                    getVistaSimulacion().getLbl_grup2_image_yellow1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                }
                listSemaforos.set(1, dispositivo2);
                break;
        }
    }

    void amarrilloIntermitente(int grupo) {

        TimerTask timerTask = new TimerTask() {

            int tiempo = 0;
            int contador = 0;

            public void run() {
                // Aquí el código que queremos ejecutar.
                //System.out.println("segundo "+segundo);
                if (contador < 10) {
                    switch (tiempo) {
                        case 0:
                            //Enviar primer grupo de conexion
                            accionAmarilla(true, grupo);
                            break;
                        case 2:
                            //Enviar cambio
                            accionAmarilla(false, grupo);
                            tiempo = 0;
                            contador++;
                            break;

                    }
                } else {
                    cancel();
                }

                tiempo++;
            }
        };
        Timer timer = new Timer();
        // Dentro de 0 milisegundos avísame cada 1000 milisegundos
        timer.scheduleAtFixedRate(timerTask, 0, 500);
    }

    /*
    * Accion de encender o apagar la luz verde
     */
    void accionVerde(boolean accion, int grupo) {

        switch (grupo) {
            case 1:
                Dispositivo dispositivo = listSemaforos.get(0);
                dispositivo.setLuz_verde(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_img33().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_img33().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }
                listSemaforos.set(0, dispositivo);
                break;
            case 4:
                Dispositivo dispositivo2 = listSemaforos.get(1);
                dispositivo2.setLuz_verde(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }
                listSemaforos.set(1, dispositivo2);
                break;
            case 21:
                Dispositivo dispositivo3 = listSemaforos.get(2);
                dispositivo3.setLuz_verde(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup3_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_grup3_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup3_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_grup3_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }
                listSemaforos.set(2, dispositivo3);
                break;
            case 24:
                Dispositivo dispositivo4 = listSemaforos.get(3);
                dispositivo4.setLuz_verde(accion);
                if (accion) {
                    getVistaSimulacion().getLbl_grup4_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_grup4_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup4_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_grup4_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }
                listSemaforos.set(3, dispositivo4);
                break;

        }

    }

    public void verdeIntermitente(int grupo) {

        TimerTask timerTask = new TimerTask() {
            int cicloConexion = 14; // 14 segundos dura el ciclo de conexion
            int tiempo = 0;
            int contador = 0;

            public void run() {
                // Aquí el código que queremos ejecutar.
                //System.out.println("segundo "+segundo);
                if (contador < 10) {
                    switch (tiempo) {
                        case 0:
                            //Enviar primer grupo de conexion
                            accionVerde(true, grupo);
                            break;
                        case 2:
                            //Enviar cambio
                            accionVerde(false, grupo);
                            tiempo = 0;
                            contador++;
                            break;

                    }
                } else {
                    cancel();
                }

                tiempo++;
            }
        };
        Timer timer = new Timer();
        // Dentro de 0 milisegundos avísame cada 1000 milisegundos
        timer.scheduleAtFixedRate(timerTask, 0, 500);
    }

    /*
    * Accion de apagar todas las luces
     */
    void accionApagarTodo() {

        //Apagar grupo 1
        Dispositivo dispositivo = listSemaforos.get(0);
        dispositivo.apagar();
        listSemaforos.set(0, dispositivo);
        getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
        getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
        getVistaSimulacion().getLbl_img33().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_img22().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
        getVistaSimulacion().getLbl_img11().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));

        // Apagar grupo 2
        Dispositivo dispositivo2 = listSemaforos.get(1);
        dispositivo2.apagar();
        listSemaforos.set(1, dispositivo2);
        getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
        getVistaSimulacion().getLbl_grup2_image_yellow1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
        getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
        getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));

        // Apagar grupo 3
        Dispositivo dispositivo3 = listSemaforos.get(2);
        dispositivo3.apagar();
        listSemaforos.set(2, dispositivo3);
        getVistaSimulacion().getLbl_grup3_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup3_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup3_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
        getVistaSimulacion().getLbl_grup3_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));

        // Apagar grupo 4
        Dispositivo dispositivo4 = listSemaforos.get(3);
        dispositivo4.apagar();
        listSemaforos.set(3, dispositivo4);
        getVistaSimulacion().getLbl_grup4_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup4_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup4_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
        getVistaSimulacion().getLbl_grup4_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));

        cliente.enviar("error");
    }

    /*
    * Accion de apagar todas las luces
     */
    void accionEncenderTodo() {
        //Encender grupo 1
        Dispositivo dispositivo = listSemaforos.get(0);
        dispositivo.encender();
        listSemaforos.set(0, dispositivo);
        getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
        getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));

        // Encender grupo 2
        Dispositivo dispositivo2 = listSemaforos.get(1);
        dispositivo2.encender();
        listSemaforos.set(1, dispositivo2);
        getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
        getVistaSimulacion().getLbl_grup2_image_yellow1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
        getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
        getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));

        // Encender grupo 3
        Dispositivo dispositivo3 = listSemaforos.get(2);
        dispositivo3.encender();
        listSemaforos.set(2, dispositivo3);
        getVistaSimulacion().getLbl_grup3_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup3_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup3_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
        getVistaSimulacion().getLbl_grup3_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));

        // Encender grupo 4
        Dispositivo dispositivo4 = listSemaforos.get(3);
        dispositivo4.encender();
        listSemaforos.set(3, dispositivo4);
        getVistaSimulacion().getLbl_grup4_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup4_image_green_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup4_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
        getVistaSimulacion().getLbl_grup4_image_red_1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
    }
}
