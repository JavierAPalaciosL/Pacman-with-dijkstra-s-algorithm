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
public class FantasmaRosa extends Jugador {

  public FantasmaRosa(int x, int y) {
    super(x, y);
    bufferDeImagen("src/imagenes/fantasma.png");

  }

  @Override
  protected void bufferDeImagen(String ruta) {
    super.bufferDeImagen(ruta);
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
          if (color.getRed() == 0 && color.getGreen() == 255 && color.getBlue() == 33) {
            g.setColor(Color.WHITE);
            g.fillRect(COORDX, COORDY, 1, 1);
          } else if (color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
            g.setColor(Color.PINK);

            g.fillRect(COORDX, COORDY, 1, 1);
          } else if (color.getRed() == 50 && color.getGreen() == 51 && color.getBlue() == 205) {

            g.setColor(Color.BLUE);

            g.fillRect(COORDX, COORDY, 1, 1);
          }

          COORDY = COORDY + 1;
        }
        COORDY = y;
        COORDX = COORDX + 1;
      }

    } else {
      g.setColor(Color.PINK);
      g.fillRect(x, y, ancho, largo);
    }

  }

}
