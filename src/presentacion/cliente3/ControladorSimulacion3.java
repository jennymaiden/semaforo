/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.cliente3;

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
public class ControladorSimulacion3 implements ActionListener {

    private final VistaSimulacion3 simulacion3;
    private final Modelo3 modelo3;

    public ControladorSimulacion3(VistaSimulacion3 vista) {
        this.simulacion3 = vista;
        this.modelo3 = vista.getModelo();
    }

    public Modelo3 getModelo() {
        return modelo3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton) {
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if (radioButton == simulacion3.getBtnRojo()) {
                getModelo().accionRojo(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion3.getBtnAmarillo()) {
                getModelo().accionAmarilla(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion3.getBtnVerde()) {
                getModelo().accionVerde(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion3.getBtnRojo_grup2()) {
                getModelo().accionRojo(radioButton.isSelected(), 2);
            } else if (radioButton == simulacion3.getBtnAmarillo_grup2()) {
                getModelo().accionAmarilla(radioButton.isSelected(), 2);
            } else if (radioButton == simulacion3.getBtnVerde_grup2()) {
                getModelo().accionVerde(radioButton.isSelected(), 2);
            }
        } else if (e.getSource() instanceof JButton) {
            JButton btnButton = (JButton) e.getSource();
            if (btnButton == simulacion3.getBtn_off()){
                getModelo().accionApagarTodo();
            } else if (btnButton == simulacion3.getBtn_on()) {
                getModelo().accionEncenderTodo();
            }
        }
    }


}
