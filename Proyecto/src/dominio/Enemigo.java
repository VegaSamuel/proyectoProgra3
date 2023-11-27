package dominio;

import back.Juego;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
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
    
    private Area enemigo;
    
    private int vida;
    private boolean perseguir;
    private boolean atacando;
    
    private Timer timer;
    private Timer cooldownAtaque;
    
    private int xAtaque = 0;
    
    public Enemigo(Juego juego) {
        super(0, 750);
        this.juego = juego;
        this.dir = "/Multimedia/zombieFresh_idle.png";
        this.vida = 2;
        
        this.cooldownAtaque = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(esDerrotado()) {
                    removerDerrotado();
                }
                
                cooldownAtaque.stop();
                timer.start();
            }
        });
        
        perseguirJugador();
        generarLocacionX();
    }

    @Override
    public void dibujar(Graphics2D g) {
        ImageIcon image = new ImageIcon(getClass().getResource(this.getDir()));
        g.drawImage(image.getImage(), getX(), getY(), 180, 180, null);
    }
    
    public void perderVida() {
        this.vida -= 1;
    }
    
    public void perseguirJugador() {
        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover();
                if(esDerrotado()) {
                    removerDerrotado();
                }
            }
        });
            
        timer.start();
    }
    
    private void mover() {
        if(this.getX() < (this.juego.getJugador().getX() - 98)) {
            this.setX(this.getX() + 2);
            this.xAtaque = 15;
            this.setDir("/Multimedia/zombieFresh_walkRight.png");
            
            if(this.estaCercaJugador()) {
                this.setDir("/Multimedia/zombieFresh_attack.png");
                this.atacar();
            }
        }
        
        if(this.getX() > (this.juego.getJugador().getX() + 98)) {
            this.setX(this.getX() - 2);
            this.xAtaque = -15;
            this.setDir("/Multimedia/zombieFresh_walkLeft.png");
            
            if(this.estaCercaJugador()) {
                this.setDir("/Multimedia/zombieFresh_attackLeft.png");
                this.atacar();
            }
        }
    }
    
    private void atacar() {
        timer.stop();
        if(this.dañaJugador()) {
            this.juego.getJugador().setVida(juego.getJugador().getVida() - 1);
            this.cooldownAtaque.start();
        }
    }
    
    private boolean estaCercaJugador() {
        return Math.abs((this.juego.getJugador().getX()-this.getX())) <= 98;
    }
    
    public Area getBounds() {
        Rectangle cuerpo = new Rectangle(this.getX()+40+this.xAtaque, this.getY(), 95, 180);
        this.enemigo = new Area(cuerpo);
        
        return enemigo;
    }
    
    public void removerDerrotado() {
        this.setX(-500);
        this.timer.stop();
    }
    
    public boolean dañaJugador() {
        Area jugador = this.juego.getJugador().getBounds();
        jugador.intersect(getBounds());
        
        return !jugador.isEmpty();
    }
    
    public boolean esDerrotado() {
        return this.vida == 0;
    }
    
    private void generarLocacionX() {
        Random random = new Random();
        
        int x = random.nextInt(1719) + 50;
        
        setX(x);
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
    
    public boolean estaAtacando() {
        return atacando;
    }
    
    public void cambiarAtacando() {
        this.atacando = !this.atacando;
    }

}
