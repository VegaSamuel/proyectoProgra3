package dominio;

import back.Juego;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author samuel
 */
public class Jugador extends Posicionable {
    private Juego juego;
    private String dir;
    
    private Area jugador;
    
    private int vida;
    private int direccion;
    
    private int xAtaque;
    
    public Jugador(Juego juego) {
        super(120, 750);
        this.juego = juego;
        this.vida = 3;
        this.xAtaque = 0;
        this.dir = "/Multimedia/zombiePlayer_idle.png";
    }
    
    @Override
    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.getDir()));
        g.drawImage(image.getImage(), getX(), getY(), 180, 180, null);
    }
    
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                mover(-10);
                setDir("/Multimedia/zombiePlayer_walkLeft.png");
                break;
            case KeyEvent.VK_D:
                mover(10);
                setDir("/Multimedia/zombiePlayer_walkRight.png");
                break;
            case KeyEvent.VK_E:
                atacar();
                break;
        }
    }
    
    public void keyRealeased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                direccion = -1;
                setDir("/Multimedia/zombiePlayer_idleLeft.png");
                break;
            case KeyEvent.VK_D:
                direccion = 1;
                setDir("/Multimedia/zombiePlayer_idle.png");
                break;
            case KeyEvent.VK_E:
                if(direccion > 0) {
                    this.xAtaque = 2;
                    setDir("/Multimedia/zombiePlayer_idle.png");
                }else {
                    this.xAtaque = 0;
                    setDir("/Multimedia/zombiePlayer_idleLeft.png");
                }
                break;
        }
    }
    
    public void restaurarValores() {
        setX(120);
        setVida(3);
        setDir("/Multimedia/zombiePlayer_idle.png");
    }

    public void perderVida() {
        this.vida -= 1;
    }
    
    public void atacar() {
        if(direccion > 0) {
            this.xAtaque = 20;
            setDir("/Multimedia/zombiePlayer_attack.png");
        }else {
            this.xAtaque = -20;
            setDir("/Multimedia/zombiePlayer_attackLeft.png");
        }
    }

    private void mover(int x) {
        this.setX(getX() + x);
    }
    
    public Area getBounds() {
        Rectangle cuerpo = new Rectangle(this.getX()+40+this.xAtaque, this.getY(), 95, 180);
        this.jugador = new Area(cuerpo);
        
        return jugador;
    }
    
    public boolean dañaEnemigo(Enemigo enemigo) {
        Area enemigoA = enemigo.getBounds();
        enemigoA.intersect(getBounds());
        
        return !enemigoA.isEmpty();
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
