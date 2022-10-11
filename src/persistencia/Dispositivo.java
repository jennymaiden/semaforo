/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author cvelez
 */
public abstract class Dispositivo {
    
    public String idGrupo;
    public boolean luz_verde;
    public boolean luz_amarilla;
    public boolean luz_roja;

    public Dispositivo() {
    }

    public Dispositivo(String idGrupo, boolean luz_verde, boolean luz_amarilla, boolean luz_roja) {
        this.idGrupo = idGrupo;
        this.luz_verde = luz_verde;
        this.luz_amarilla = luz_amarilla;
        this.luz_roja = luz_roja;
    }

    public void apagar() {
        this.luz_roja = false;
        this.luz_amarilla = false;
        this.luz_verde = false;
    }
    
    public void encender() {
        this.luz_roja = true;
        this.luz_amarilla = true;
        this.luz_verde = true;
    }
    
    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    
   
    
    public boolean isLuz_verde() {
        return luz_verde;
    }

    public void setLuz_verde(boolean luz_verde) {
        this.luz_verde = luz_verde;
    }

    public boolean isLuz_amarilla() {
        return luz_amarilla;
    }

    public void setLuz_amarilla(boolean luz_amarilla) {
        this.luz_amarilla = luz_amarilla;
    }

    public boolean isLuz_roja() {
        return luz_roja;
    }

    public void setLuz_roja(boolean luz_roja) {
        this.luz_roja = luz_roja;
    }

    
}
