package dominio;

import back.Juego;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author samuel
 */
public class Enemigo extends Posicionable {
    private Juego juego;
    private String dir;
    private boolean perseguir;
    
    private int vida;
    private Timer timer;
    
    public Enemigo(Juego juego) {
        super(0, 750);
        this.juego = juego;
        this.dir = "/Multimedia/zombieFresh_idle.png";
        this.vida = 2;
        
        perseguirJugador();
        generarLocacionX();
    }

    @Override
    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.getDir()));
        g.drawImage(image.getImage(), getX(), getY(), 180, 180, null);
    }
    
    public void perderVida() {
        this.setVida(this.getVida() - 1);
    }
    
    public void perseguirJugador() {
        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover();
                removerDerrotado();
            }
        });
            
        timer.start();
    }
    
    private void mover() {
        if(this.getX() < (this.juego.getJugador().getX() - 50)) {
            this.setX(this.getX() + 2);
            this.setDir("/Multimedia/zombieFresh_walkRight.png");
        }
        if(this.getX() > (this.juego.getJugador().getX() + 50)) {
            this.setX(this.getX() - 2);
            this.setDir("/Multimedia/zombieFresh_walkLeft.png");
        }
    }
    
    public void removerDerrotado() {
        if(this.esDerrotado()) {
            this.setX(-500);
            this.timer.stop();
        }
    }
    
    public boolean esDerrotado() {
        return this.vida == 0;
    }
    
    private void generarLocacionX() {
        Random random = new Random();
        
        int x = random.nextInt(1769) + 1;
        
        setX(x);
    }
    
    private void atacar() {
        setDir("/Multimedia/zombieFresh_attack.png");
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void dejarPerseguirJugador() {
        this.perseguir = !perseguir;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
