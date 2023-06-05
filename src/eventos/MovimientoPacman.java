/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

import contenedores.Lienzo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import mapa.MapaUno;
import personajes.Pacman;

/**
 *
 * @author cazaputas666
 */
public class MovimientoPacman implements KeyListener {

  private Lienzo lienzo;
  private MapaUno mapa;
  private Pacman pacman;
  public static int VELOCIDADPACMAN = 20;

  public MovimientoPacman(Lienzo lienzo, MapaUno mapa, Pacman pacman) {
    this.lienzo = lienzo;
    this.mapa = mapa;
    this.pacman = pacman;
    this.lienzo.setFocusable(true);
    this.lienzo.addKeyListener(this);

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  public Point coordenadasNormalesAArreglo(int factorSumaX, int factorSumaY) {
    int x = (this.pacman.getX() + factorSumaX) % this.pacman.getAncho();
    int y = (this.pacman.getY() + factorSumaY) % this.pacman.getLargo();

    int totalX = (this.pacman.getX() + factorSumaX) - x;
    int totalY = (this.pacman.getY() + factorSumaY) - y;

    int arregloX = (totalX) / (this.pacman.getAncho());
    int arregloY = (totalY) / (this.pacman.getLargo());

    return new Point(arregloX, arregloY);
  }

  public boolean puedoAvanzar(int vk, int constanteMovimiento) {

    int totalX = 0, totalY = 0;
    boolean elRetorno = false;
    ArrayList<Point> puntos = null;
    Point p1 = null;

    switch (constanteMovimiento) {
      case VK_RIGHT -> {
        p1 = this.coordenadasNormalesAArreglo(VELOCIDADPACMAN, 0);
        Point p2 = this.coordenadasNormalesAArreglo(VELOCIDADPACMAN + this.pacman.getAncho() - 1, 0);
        Point p3 = this.coordenadasNormalesAArreglo(VELOCIDADPACMAN + this.pacman.getAncho() - 1, this.pacman.getLargo() - 1);
        elRetorno = this.mapa.getDimensionMapa()[p2.x][p2.y].isEsPared() && this.mapa.getDimensionMapa()[p3.x][p3.y].isEsPared();
      }
      case VK_LEFT -> {
        p1 = this.coordenadasNormalesAArreglo(-VELOCIDADPACMAN, 0);
        Point p3 = this.coordenadasNormalesAArreglo(-VELOCIDADPACMAN, this.pacman.getLargo() - 1);
        elRetorno = this.mapa.getDimensionMapa()[p1.x][p1.y].isEsPared() && this.mapa.getDimensionMapa()[p3.x][p3.y].isEsPared();
      }
      case VK_UP -> {
        p1 = this.coordenadasNormalesAArreglo(0, -VELOCIDADPACMAN);
        Point p3 = this.coordenadasNormalesAArreglo(this.pacman.getAncho() - 1, -VELOCIDADPACMAN);
        elRetorno = this.mapa.getDimensionMapa()[p1.x][p1.y].isEsPared() && this.mapa.getDimensionMapa()[p3.x][p3.y].isEsPared();
      }
      case VK_DOWN -> {
        p1 = this.coordenadasNormalesAArreglo(0, VELOCIDADPACMAN);
        Point p2 = this.coordenadasNormalesAArreglo(0, VELOCIDADPACMAN + this.pacman.getAncho() - 1);
        Point p3 = this.coordenadasNormalesAArreglo(this.pacman.getLargo() - 1, VELOCIDADPACMAN + this.pacman.getAncho() - 1);
        elRetorno = this.mapa.getDimensionMapa()[p2.x][p2.y].isEsPared() && this.mapa.getDimensionMapa()[p3.x][p3.y].isEsPared();
      }
      default -> {
      }
    }

    return elRetorno;
  }

  @Override
  public void keyPressed(KeyEvent e) {

    boolean av = false;

    if (puedoAvanzar(VK_RIGHT, e.getKeyCode()) && VK_RIGHT == e.getKeyCode()) {

      this.pacman.setX(this.pacman.getX() + VELOCIDADPACMAN);

    } else if (puedoAvanzar(VK_LEFT, e.getKeyCode()) && VK_LEFT == e.getKeyCode()) {

      this.pacman.setX(this.pacman.getX() - VELOCIDADPACMAN);

    } else if (puedoAvanzar(VK_DOWN, e.getKeyCode()) && VK_DOWN == e.getKeyCode()) {

      this.pacman.setY(this.pacman.getY() + VELOCIDADPACMAN);

    } else if (puedoAvanzar(VK_UP, e.getKeyCode()) && VK_UP == e.getKeyCode()) {

      this.pacman.setY(this.pacman.getY() - VELOCIDADPACMAN);

    }

    this.lienzo.repaint();

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  
  
}
