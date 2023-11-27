package back;

import dominio.Enemigo;
import dominio.HUD;
import dominio.Jugador;
import dominio.Nina;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import vista.Fondo;

/**
 *
 * @author ruben
 */
public class Juego extends JPanel {
    private Jugador jugador = new Jugador(this);
    private Nina nina = new Nina(this);
    private Enemigo[] enemigosL1;
    private Enemigo[] enemigosL2;
    private Fondo fondo = new Fondo(this);
    private HUD hud = new HUD(this);
    
    private boolean juegoFinalizado;
    private boolean reinicio;
    private boolean juegoGanado;
    
    public Juego() {
        juegoFinalizado = false;
        juegoGanado = false;
        reinicio = false;
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_A:
                        jugador.keyPressed(e);
                        break;
                    case KeyEvent.VK_D:
                        jugador.keyPressed(e);
                        break;
                    case KeyEvent.VK_E:
                        jugador.keyPressed(e);
                        if(hayZombiesGenerados(enemigosL1)) {
                                for (Enemigo enemigo : enemigosL1) {
                                enemigo.perderVida();
                            }
                        }
                        if(hayZombiesGenerados(enemigosL2)) {
                                for (Enemigo enemigo : enemigosL2) {
                                enemigo.perderVida();
                            }
                        }
                        break;
                    case KeyEvent.VK_Z:
                        nina.cambiarSigue();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_A:
                        jugador.keyRealeased(e);
                        break;
                    case KeyEvent.VK_D:
                        jugador.keyRealeased(e);
                        break;
                    case KeyEvent.VK_E:
                        jugador.keyRealeased(e);
                        break;
                }
            }
            
        });
        
        setFocusable(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintChildren(g);
        Graphics2D g2 = (Graphics2D) g;
        dibujar(g2);
    }
    
    private void dibujar(Graphics2D g) {
        fondo.dibujar(g);
        jugador.dibujar(g);
        nina.dibujar(g);
        if(this.fondo.getLevel() == 1 && hayZombiesGenerados(enemigosL1)) {
            for (Enemigo zombie : enemigosL1) {
                zombie.dibujar(g);
            }
        }
        if(this.fondo.getLevel() == 2 && hayZombiesGenerados(enemigosL2)) {
            for (Enemigo zombie : enemigosL2) {
                zombie.dibujar(g);
            }
        }
        hud.dibujarCorazones(g);
    }
    
    public void funcionalidadesJuego() {
        getNina().seguirJugador();
        getFondo().posicionarJugadorCambioFondo();
        if(this.fondo.getLevel() == 1 && !hayZombiesGenerados(enemigosL1)) {
            enemigosL1 = generarZombies();
        }else if(this.fondo.getLevel() == 1) {
            if(this.quedanZombies(enemigosL1)) {
                limitarMovimientoJugador();
            }
        }
        if(this.fondo.getLevel() == 2 && !hayZombiesGenerados(enemigosL2)) {
            enemigosL2 = generarZombies();
        }else if(this.fondo.getLevel() == 2) {
            if(this.quedanZombies(enemigosL2)) {
                limitarMovimientoJugador();
            }
        }
        verificarFinJuego();
    }
    
    private void limitarMovimientoJugador() {
        if(this.jugador.getX() > 1769) {
            this.jugador.setX(1769);
        }else if (this.jugador.getX() < 1){
            this.jugador.setX(1);
        }
    }
    
    public boolean isJuegoFinalizado() {
        return juegoFinalizado;
    }
        
    public boolean sePuedeReiniciar() {
        return reinicio;
    }
    
    public String getTipoFinalizacion() {
        if(isJuegoFinalizado()) {
            return "FinalSeguro";
        }else if(this.jugador.getVida() == 0){
            return "Asesinado";
        }
        return null;
    }
    
    public void reiniciarJuego() {
        this.jugador.restaurarValores();
        this.nina.restaurarValores();
        this.fondo.restaurarValores();
        this.enemigosL1 = null;
        this.enemigosL2 = null;
        this.juegoFinalizado = false;
    }

    public void verificarFinJuego() {
        if(ninaYZombieEnElFinal() && estaEnUltimoNivel()) {
            juegoFinalizado = true;
            juegoGanado = true;
        }
        
        if(hayZombiesGenerados(enemigosL1)) {
            if(this.jugador.getX() == this.enemigosL1[0].getX()) {
                jugador.perderVida();
            }
        }
        
        if(hayZombiesGenerados(enemigosL2)) {
            if(this.jugador.getX() == this.enemigosL2[0].getX()) {
                jugador.perderVida();
            }
        }
        
        if(this.jugador.getVida() == 0) {
            juegoFinalizado = true;
        }
    }
    
    private boolean ninaYZombieEnElFinal() {
        return (this.jugador.getX() == 1370 && this.getNina().getX() == 1350);
    }
    
    private boolean estaEnUltimoNivel() {
        return this.fondo.getLevel() == 3;
    }
    
    public boolean estaEnNivelesPeligrosos() {
        return this.fondo.getLevel() > 0 && this.fondo.getLevel() < 3;
    }
    
    public boolean hayZombiesGenerados(Enemigo[] zombies) {
        return zombies != null;
    }
    
    public boolean quedanZombies(Enemigo[] zombies) {
        int total = zombies.length;
        int inicial = 0;
        
        for (Enemigo zombie : zombies) {
            if(zombie.esDerrotado()) {
                inicial++;
            }
        }
        
        return inicial != total;
    }
    
    private Enemigo[] generarZombies() {
        Random random = new Random();
        int cantidad = random.nextInt(6) + 1;
        Enemigo[] zombies = new Enemigo[cantidad];
            
        if(this.estaEnNivelesPeligrosos()) {
            for (int i = 0; i < cantidad; i++) {
                zombies[i] = new Enemigo(this);
            }
        }
        
        return zombies;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Nina getNina() {
        return nina;
    }

    public void setNina(Nina nina) {
        this.nina = nina;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    public HUD getHud() {
        return hud;
    }

    public void setHud(HUD hud) {
        this.hud = hud;
    }

    public void setReinicio(boolean reinicio) {
        this.reinicio = reinicio;
    }

}
