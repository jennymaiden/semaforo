/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.ImageIcon;
import persistencia.Vehicular;

/**
 *
 * @author cvelez
 */
public class Modelo {

    private VistaSimulacion ventanaSimulacion;

    private Vehicular semaforoVechicular;

    public VistaSimulacion getVistaSimulacion() {

        if (ventanaSimulacion == null) {
            ventanaSimulacion = new VistaSimulacion(this);
        }
        return ventanaSimulacion;
    }

    public void iniciar() {
        getVistaSimulacion().setSize(800, 900);
        getVistaSimulacion().setVisible(true);
        getVistaSimulacion().setLocationRelativeTo(null);
    }

    /*
    * Accion de encender o apagar la luz roja
     */
    void accionRojo(boolean accion, int grupo) {

        switch (grupo) {
            case 1:
                if (accion) {
                    getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_img11().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_img11().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }   break;
            case 2:
                if (accion) {
                    getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }   break;
            default:
                if (accion) {
                    getVistaSimulacion().getLbl_grupo3_imageRed().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                    getVistaSimulacion().getLbl_grupo3_imageRed2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grupo3_imageRed().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                    getVistaSimulacion().getLbl_grupo3_imageRed2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
                }   break;
        }
    }

    /*
    * Accion de encender o apagar la luz amarilla
     */
    void accionAmarilla(boolean accion, int grupo) {

        switch (grupo) {
            case 1:
                if (accion) {
                    getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                    getVistaSimulacion().getLbl_img22().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                } else {
                    getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                    getVistaSimulacion().getLbl_img22().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                }   break;
            case 2:
                if (accion) {
                    getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                    getVistaSimulacion().getLbl_grup2_image_yellow1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                    getVistaSimulacion().getLbl_grup2_image_yellow1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
                }   break;
        }
    }

    /*
    * Accion de encender o apagar la luz verde
     */
    void accionVerde(boolean accion, int grupo) {

        switch (grupo) {
            case 1:
                if (accion) {
                    getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_img33().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_img33().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }   break;
            case 2:
                if (accion) {
                    getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }   break;
            default:
                if (accion) {
                    getVistaSimulacion().getLbl_grupo3_imageGreen().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                    getVistaSimulacion().getLbl_grupo3_imageGreen2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
                } else {
                    getVistaSimulacion().getLbl_grupo3_imageGreen().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                    getVistaSimulacion().getLbl_grupo3_imageGreen2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
                }   break;
        }

    }

    /*
    * Accion de apagar todas las luces
     */
    void accionApagarTodo() {

        //Apagar grupo 1
        getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
        getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));

        // Apagar grupo 2
        getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_false.png")));
        getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_false.png")));
        getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));
        getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_false.png")));

        //Desabilitar radiobuttons
        getVistaSimulacion().getBtnRojo().setEnabled(false);
        getVistaSimulacion().getBtnAmarillo().setEnabled(false);
        getVistaSimulacion().getBtnVerde().setEnabled(false);
        
        getVistaSimulacion().getBtnRojo_grup2().setEnabled(false);
        getVistaSimulacion().getBtnAmarillo_grup2().setEnabled(false);
        getVistaSimulacion().getBtnVerde_grup2().setEnabled(false);
    }

    /*
    * Accion de apagar todas las luces
     */
    void accionEncenderTodo() {
        //Apagar grupo 1
        getVistaSimulacion().getLbl_img3().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_img2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
        getVistaSimulacion().getLbl_img1().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));

        // Apagar grupo 2
        getVistaSimulacion().getLbl_grup2_image_green().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup2_image_green_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/green_true.png")));
        getVistaSimulacion().getLbl_grup2_image_yellow().setIcon(new ImageIcon(getClass().getResource("/Imagenes/yellow_true.png")));
        getVistaSimulacion().getLbl_grup2_image_red().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));
        getVistaSimulacion().getLbl_grup2_image_red_2().setIcon(new ImageIcon(getClass().getResource("/Imagenes/red_true.png")));

        //Desabilitar radiobuttons
        getVistaSimulacion().getBtnRojo().setEnabled(true);
        getVistaSimulacion().getBtnAmarillo().setEnabled(true);
        getVistaSimulacion().getBtnVerde().setEnabled(true);
        
        getVistaSimulacion().getBtnRojo().setSelected(true);
        getVistaSimulacion().getBtnAmarillo().setSelected(true);
        getVistaSimulacion().getBtnVerde().setSelected(true);
        
        getVistaSimulacion().getBtnRojo_grup2().setEnabled(true);
        getVistaSimulacion().getBtnAmarillo_grup2().setEnabled(true);
        getVistaSimulacion().getBtnVerde_grup2().setEnabled(true);
        
        getVistaSimulacion().getBtnRojo_grup2().setSelected(true);
        getVistaSimulacion().getBtnAmarillo_grup2().setSelected(true);
        getVistaSimulacion().getBtnVerde_grup2().setSelected(true);
    }
}
