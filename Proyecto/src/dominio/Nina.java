package dominio;

import back.Juego;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import vista.frmJuego;

/**
 *
 * @author samuel
 */
public class Nina extends Posicionable {
    private Juego juego;
    private String dir;
    
    private Area nina;
    
    private boolean sigue;
    private Jugador jugador;
    
    public Nina(Juego juego) {
        super(70, 815);
        this.dir = "/Multimedia/nina_idle.png";
        this.juego = juego;
        this.sigue = true;
        this.jugador = juego.getJugador();
    }
    
    @Override
    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.getDir()));
        g.drawImage(image.getImage(), getX(), getY(), 70, 125, null);
    }
    
    public void restaurarValores() {
        setX(70);
        if(!estaSiguiendo()) {
            cambiarSigue();
        }
        setDir("/Multimedia/nina_idle.png");
    }
    
    public void seguirJugador() {
        if(this.sigue) {
            if(this.seEstaAlejando()) {
                mover();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                this.dir = "/Multimedia/nina_idle.png";
            }
        }
    }
    
    private void mover() {
        if(this.getX() < (this.jugador.getX() - 20)) {
            this.setX(this.getX() + 10);
            this.setDir("/Multimedia/nina_walkRight.png");
        }
        if(this.getX() > (this.jugador.getX() + 20)) {
            this.setX(this.getX() - 10);
            this.setDir("/Multimedia/nina_walkLeft.png");
        }
    }
    
    public Area getBounds() {
        Rectangle cuerpo = new Rectangle(this.getX()+5, this.getY(), 50, 120);
        this.nina = new Area(cuerpo);
        
        return nina;
    }
    
    public void cambiarSigue() {
        this.sigue = !this.sigue;
    }
    
    private boolean seEstaAlejando() {
        return Math.abs(this.jugador.getX() - this.getX()) > 20;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public boolean estaSiguiendo() {
        return sigue;
    }

}
