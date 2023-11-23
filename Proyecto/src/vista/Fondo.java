/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import back.Juego;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ruben
 */
public class Fondo {
    private Juego juego;
    private String dir;
    private int level;
    private String[] dirs = {"/Multimedia/Fondo1.jpg", "/Multimedia/Fondo2.jpg"};
    
    public Fondo(Juego juego) {
        this.juego = juego;
        this.level = 0;
        this.dir = dirs[0];
    }

    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.dir));
        g.drawImage(image.getImage(), 0, 0, 1920, 1080, null);
    }

    public void cambiarFondo() {
        if(juego.getJugador().getX() >= 1900) {
            if((level+1) <= dirs.length) {
                level++;
                ponerFondo(level);
                juego.getJugador().setX(100);
                juego.getNina().setX(90);
            }
        }else if(juego.getJugador().getX() <= 100) {
            if((level-1) == 0) {
                level--;
                ponerFondo(level);
                juego.getJugador().setX(1900);
                juego.getNina().setX(1890);
            }
        }
    }
    
    private void ponerFondo(int x) {
        this.dir = dirs[x];
    }

}
