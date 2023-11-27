/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;
import javax.swing.JFrame;
import vista.dlgInicioSesion;

/**
 *
 * @author 
 */
public class Control {
    public boolean sesionActiva;
    
    public void inicioSesion(JFrame frame){
        dlgInicioSesion dlgIS;
        
        dlgIS = new dlgInicioSesion(frame, true);
        
        return;
    }
    
    public boolean estaSesionActiva() {
        return sesionActiva;
    }
    
}
