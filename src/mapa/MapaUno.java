/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import personajes.Comida;

/**
 *
 * @author Javier Alberto Palacios Lopez
 */
public class MapaUno {

  private Mosaicos[][] dimensionMapa = null;
  private Comida[] comida = null;
  private int ancho, largo;

  public MapaUno(Mosaicos[][] dimensionMapa) {

    this.dimensionMapa = dimensionMapa;
    this.largo = this.dimensionMapa[0].length;
    this.ancho = this.dimensionMapa.length;
    System.out.println(ancho + " " + largo);
    inicializarMapa();

  }

  public int getAncho() {
    return ancho;
  }

  public void setAncho(int ancho) {
    this.ancho = ancho;
  }

  public int getLargo() {
    return largo;
  }

  public void setLargo(int largo) {
    this.largo = largo;
  }

  public Mosaicos[][] getDimensionMapa() {
    return dimensionMapa;
  }

  public void setDimensionMapa(Mosaicos[][] dimensionMapa) {
    this.dimensionMapa = dimensionMapa;
  }

  private void inicializarMapa() {
    int conteoDeComida = 0;
    try {
      BufferedImage bi = ImageIO.read(new File("src/imagenes/np.png"));

      for (int i = 0; i < this.dimensionMapa.length; i++) {
        for (int j = 0; j < this.dimensionMapa[i].length; j++) {
          //r=0,g=38,b=255

          Color color = new Color(bi.getRGB(i, j));

          if ((color.getRed() == 0 && color.getGreen() == 38 && color.getBlue() == 255)) {

            dimensionMapa[i][j] = new Mosaicos(i * 20, j * 20, false);

          } else {

            dimensionMapa[i][j] = new Mosaicos(i * 20, j * 20, true);
            conteoDeComida = conteoDeComida + 1;

          }

        }
      }

      System.out.println("la comida " + conteoDeComida);

      this.comida = new Comida[conteoDeComida];
      int contador = 0;

      for (int i = 0; i < this.dimensionMapa.length; i++) {
        for (int j = 0; j < this.dimensionMapa[i].length; j++) {

          if (this.dimensionMapa[i][j].isEsPared()) {

            this.comida[contador] = new Comida(this.dimensionMapa[i][j].getX(), this.dimensionMapa[i][j].getY());

            Color color = new Color(bi.getRGB(i, j));

            if ((color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0)) {
              this.comida[contador].setEstaComida(true);
//              this.dimensionMapa[i][j].setEsPared(false);
            }

            contador = contador + 1;

          }

        }
      }

    } catch (IOException ex) {

    }

  }

  public void dibujarMapa(Graphics g) {

    g.setColor(Color.BLUE);
    int contador = 0;
    for (int i = 0; i < this.dimensionMapa.length; i++) {
      for (int j = 0; j < this.dimensionMapa[i].length; j++) {

        if (!this.dimensionMapa[i][j].isEsPared()) {
          this.dimensionMapa[i][j].pintarJugador(g);
          this.comida[contador].pintarJugador(g);
          contador = contador + 1;
        }

      }
    }

  }

}
