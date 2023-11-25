/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back;

import dominio.HUD;
import dominio.Jugador;
import dominio.Nina;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import vista.Fondo;

/**
 *
 * @author ruben
 */
public class Juego extends JPanel {
    private Jugador jugador = new Jugador(this);
    private Nina nina = new Nina(this);
    private Fondo fondo = new Fondo(this);
    private HUD hud = new HUD(this);
    
    private boolean juegoFinalizado;
    
    public Juego() {
        juegoFinalizado = false;
        
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
        hud.dibujarCorazones(g);
    }
    
    public boolean isJuegoFinalizado() {
        return juegoFinalizado;
    }

    public void verificarFinJuego() {
        if(this.jugador.getX() == 1370 && this.fondo.getLevel() == 3) {
            juegoFinalizado = true;
        }
        
        if(this.jugador.getX() == 1370 && this.fondo.getLevel() == 0) {
            jugador.perderVida();
        }
        
        if(this.jugador.getVida() == 0) {
            juegoFinalizado = true;
        }
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

}
