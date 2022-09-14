/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Estudiantes
 */
public class ControladorSimulacion implements ActionListener {

    private final VistaSimulacion simulacion;
    private final Modelo modelo;

    public ControladorSimulacion(VistaSimulacion vista) {
        this.simulacion = vista;
        this.modelo = vista.getModelo();
    }

    public Modelo getModelo() {
        return modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton) {
            JRadioButton radioButton = (JRadioButton) e.getSource();
            if (radioButton == simulacion.getBtnRojo()) {
                getModelo().accionRojo(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion.getBtnAmarillo()) {
                getModelo().accionAmarilla(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion.getBtnVerde()) {
                getModelo().accionVerde(radioButton.isSelected(), 1);
            } else if (radioButton == simulacion.getBtnRojo_grup2()) {
                getModelo().accionRojo(radioButton.isSelected(), 2);
            } else if (radioButton == simulacion.getBtnAmarillo_grup2()) {
                getModelo().accionAmarilla(radioButton.isSelected(), 2);
            } else if (radioButton == simulacion.getBtnVerde_grup2()) {
                getModelo().accionVerde(radioButton.isSelected(), 2);
            }
        } else if (e.getSource() instanceof JButton) {
            JButton btnButton = (JButton) e.getSource();
            if (btnButton == simulacion.getBtn_off()){
                getModelo().accionApagarTodo();
            } else if (btnButton == simulacion.getBtn_on()) {
                getModelo().accionEncenderTodo();
            }
        }
    }

}
