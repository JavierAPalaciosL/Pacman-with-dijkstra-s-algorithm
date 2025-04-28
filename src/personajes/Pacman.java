/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Javier Alberto Palacios Lopez
 */
public class Pacman extends Jugador {

  public Pacman(int x, int y) {
    super(x, y);
    bufferDeImagen("src/imagenes/pacman.png");

  }

  @Override
  protected void bufferDeImagen(String ruta) {
    super.bufferDeImagen(ruta);
  }

  public ArrayList<Point> devolverLosCuatroPuntos(Point posicionPacman) {

    ArrayList<Point> retorno = new ArrayList<>();

    retorno.add(new Point(posicionPacman.x, posicionPacman.y));
    retorno.add(new Point(posicionPacman.x + this.ancho - 1, posicionPacman.y));
    retorno.add(new Point(posicionPacman.x + this.ancho - 1, posicionPacman.y + this.largo));
    retorno.add(new Point(posicionPacman.x, posicionPacman.y + this.ancho - 1));

    return retorno;
  }

  @Override
  public void pintarJugador(Graphics g) {
    
    
    int COORDX = x;
    int COORDY = y;

    if (this.BI != null) {

      for (int i = 0; i < this.BI.getWidth(); i++) {
        for (int j = 0; j < this.BI.getHeight(); j++) {

          Color color = new Color(this.BI.getRGB(i, j));
          //r=0,g=255,b=33
          //r=50,g=51,b=205
          if (!(color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255)) {
            g.setColor(Color.YELLOW);
            g.fillRect(COORDX, COORDY, 1, 1);
          }

          COORDY = COORDY + 1;
        }
        COORDY = y;
        COORDX = COORDX + 1;
      }

    } else {
      g.setColor(Color.YELLOW);
      g.fillRect(x, y, ancho, largo);
    }

  }

}
