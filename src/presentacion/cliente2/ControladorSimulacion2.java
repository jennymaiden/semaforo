/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.cliente2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Estudiantes
 */
public class ControladorSimulacion2 implements ActionListener {

    private final VistaSimulacion2 simulacion2;
    private final Modelo2 modelo2;

    public ControladorSimulacion2(VistaSimulacion2 vista) {
        this.simulacion2 = vista;
        this.modelo2 = vista.getModelo();
    }

    public Modelo2 getModelo() {
        return modelo2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton) {
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if (radioButton == simulacion2.getBtnRojo()) {
                getModelo().accionRojo(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion2.getBtnAmarillo()) {
                getModelo().accionAmarilla(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion2.getBtnVerde()) {
                getModelo().accionVerde(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion2.getBtnRojo_grup2()) {
                getModelo().accionRojo(radioButton.isSelected(), 2);
            } else if (radioButton == simulacion2.getBtnAmarillo_grup2()) {
                getModelo().accionAmarilla(radioButton.isSelected(), 2);
            } else if (radioButton == simulacion2.getBtnVerde_grup2()) {
                getModelo().accionVerde(radioButton.isSelected(), 2);
            }
        } else if (e.getSource() instanceof JButton) {
            JButton btnButton = (JButton) e.getSource();
            if (btnButton == simulacion2.getBtn_off()){
                getModelo().accionApagarTodo();
            } else if (btnButton == simulacion2.getBtn_on()) {
                getModelo().accionEncenderTodo();
            }
        }
    }


}
