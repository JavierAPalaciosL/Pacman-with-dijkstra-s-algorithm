/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Cazaputas666
 */
public class Comida extends Jugador {

  private boolean estaComida = false;

  public Comida(int x, int y) {
    super(x, y);
  }

  public boolean isEstaComida() {
    return estaComida;
  }

  public void setEstaComida(boolean estaComida) {
    this.estaComida = estaComida;
  }

  @Override
  public void pintarJugador(Graphics g) {

    if (!estaComida) {
      g.setColor(Color.GREEN);
//    g.fillOval(x+ancho/2, y+largo/2, ancho/10, largo/10);
      g.fillOval(x + ancho / 2, y + largo / 2, ancho / 5, largo / 5);
    }
  }

}
