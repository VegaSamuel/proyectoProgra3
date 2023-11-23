/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import back.Juego;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author atrap
 */
public class game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mission Zombie");
        Juego juego = new Juego();
        frame.add(juego);
        frame.setSize(1920, 1080);
        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true) {
            if(juego.isJuegoFinalizado()) {
                
            } else {
                juego.getNina().seguirJugador();
                juego.getFondo().cambiarFondo();
                juego.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
