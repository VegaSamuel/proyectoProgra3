/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import back.Juego;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class HUD {
    private Juego juego;
    
    private int[] xcorazones;
    
    public HUD(Juego juego) {
        this.juego = juego;
    }
    
    private void llenarXCorazones() {
        for (int i = 0; i < xcorazones.length; i++) {
            if(i == 0) {
                xcorazones[i] = 10;
            }else {
                xcorazones[i] = xcorazones[i-1] + 90;
            }
        }
    }
    
    public void dibujarCorazones(Graphics2D g) {
        this.xcorazones = new int[juego.getJugador().getVida()];
        this.llenarXCorazones();
        
        for (int x : xcorazones) {
            ImageIcon corazon = new ImageIcon(getClass().getResource("/Multimedia/corazon.png"));
            g.drawImage(corazon.getImage(), x, 25, 90, 90, null);
        }
    }
}
