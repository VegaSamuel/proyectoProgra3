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
    private Enemigo[] enemigos = new Enemigo[1];
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
                        break;
                    case KeyEvent.VK_Z:
                        nina.cambiarSigue();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                jugador.setDir("/Multimedia/zombiePlayer_idle.png");
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
//        if(estaEnNivelesPeligrosos()) {
//            for (int i = 0; i < 10; i++) {
//                enemigos[i].dibujar(g);
//            }
//        }
        hud.dibujarCorazones(g);
    }
    
    public void funcionalidadesJuego() {
        getNina().seguirJugador();
        getFondo().posicionarJugadorCambioFondo();
        
        verificarFinJuego();
    }
    
    public boolean isJuegoFinalizado() {
        return juegoFinalizado;
    }
    
    public String getTipoFinalizacion() {
        if(juegoGanado) {
            return "FinalSeguro";
        }else {
            return "Asesinado";
        }
    }
    
    public void reiniciarJuego() {
        this.jugador.restaurarValores();
        this.nina.restaurarValores();
        this.fondo.restaurarValores();
        
        this.juegoFinalizado = false;
    }

    public void verificarFinJuego() {
        if(ninaYZombieEnElFinal() && estaEnUltimoNivel()) {
            juegoFinalizado = true;
            juegoGanado = true;
        }
        
//        if(hayZombies()) {
//            if(this.jugador.getX() == this.enemigos[0][0].getX()) {
//                jugador.perderVida();
//            }
//        }
        
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
    
//    public boolean hayZombies() {
//        return this.enemigos[0] != null;
//    }
//    
//    public void generarZombies() {
//        Random random = new Random();
//        int cantidad = random.nextInt(6);
//        enemigos = new Enemigo[cantidad];
//            
//        if(this.fondo.getLevel() == 1) {
//            for (int i = 0; i < cantidad; i++) {
//                enemigos[i] = new Enemigo(this);
//            }
//        }
//    }

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
    
    public boolean sePuedeReiniciar() {
        return reinicio;
    }

}
