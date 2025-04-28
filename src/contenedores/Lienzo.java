/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenedores;

import grafo.InsertarDatos;
import grafo.Vertice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import mapa.MapaUno;
import personajes.FantasmaAzul;
import personajes.FantasmaNaranja;
import personajes.FantasmaRojo;
import personajes.FantasmaRosa;
import personajes.Pacman;

/**
 *
 * @author Javier Alberto Palacios López
 */
public class Lienzo extends JPanel {

  private MapaUno mapa;
  private Pacman pacman;
//  private InsertarDatos grafoFanstamaUno;
//  private InsertarDatos grafoFantasmaDos;
  private FantasmaRojo FR;
  private FantasmaRosa FP;
  private FantasmaAzul FA;
  private FantasmaNaranja FN;

  public Lienzo(MapaUno mapa, Pacman pacman, FantasmaRojo FR, FantasmaRosa FP, FantasmaAzul FA, FantasmaNaranja FN) {
    this.mapa = mapa;
    this.pacman = pacman;
    this.FR = FR;
    this.FP = FP;
    this.FA = FA;
    this.FN = FN;
//    this.grafoFanstamaUno = new InsertarDatos();
//    this.insertarVerticesTablero();
//    this.configurarEnlacesTablero();
    this.setBackground(Color.BLACK);
  }

//  public InsertarDatos getGrafoFanstamaUno() {
//    return grafoFanstamaUno;
//  }
//
//  public void setGrafoFanstamaUno(InsertarDatos grafoFanstamaUno) {
//    this.grafoFanstamaUno = grafoFanstamaUno;
//  }
  public void insertarVerticesTablero(InsertarDatos grafoFanstamaUno, int distancia) {

    int nombreVertice = 0;

    for (int y = 0; y < this.mapa.getDimensionMapa()[0].length; y++) {
      for (int x = 0; x < this.mapa.getDimensionMapa().length; x++) {

        if (this.mapa.getDimensionMapa()[x][y].isEsPared()) {

          grafoFanstamaUno.insertarVertices(nombreVertice);

          Vertice obtenerDireccion = grafoFanstamaUno.obtenerVertice(nombreVertice);

//          obtenerDireccion.x = this.mapa.getDimensionMapa()[x][y].getX();
//          obtenerDireccion.y = this.mapa.getDimensionMapa()[x][y].getY();
          obtenerDireccion.x = x;
          obtenerDireccion.y = y;

          nombreVertice = nombreVertice + 1;

        }
      }
    }
    configurarEnlacesTablero(grafoFanstamaUno, distancia);

  }

  public void configurarEnlacesTablero(InsertarDatos grafoFanstamaUno, int distancia) {

    for (int i = 0; i < mapa.getDimensionMapa()[0].length; i++) {
      for (int j = 0; j < mapa.getDimensionMapa().length; j++) {

        boolean derecha = puedoIrDerecha(i, j);
        boolean abajo = puedoIrAbajo(i, j);

        boolean derechaAbajo = puedoIrDerecha(i, j) && puedoIrAbajo(i, j);
        boolean IzquierdaAbajo = puedoIrIzquierda(i, j) && puedoIrAbajo(i, j);

        Vertice enlaceV = grafoFanstamaUno.obtenerVerticePorCordenada(i, j);

        if (enlaceV != null) {

          if (derecha) {
            Vertice VD = grafoFanstamaUno.obtenerVerticePorCordenada(i, j + 1);
            if (VD != null) {
              grafoFanstamaUno.insertarArista(enlaceV.nombreVertice, VD.nombreVertice, distancia);
            }

          }
          if (abajo) {
            Vertice VA = grafoFanstamaUno.obtenerVerticePorCordenada(i + 1, j);
            if (VA != null) {
              grafoFanstamaUno.insertarArista(enlaceV.nombreVertice, VA.nombreVertice, distancia);
            }

          }

//          if (derechaAbajo) {
//            Vertice VDA = grafoFanstamaUno.obtenerVerticePorCordenada(i + 1, j + 1);
//            if (VDA != null) {
//              grafoFanstamaUno.insertarArista(enlaceV.nombreVertice, VDA.nombreVertice, 1);
//            }
//
//          }
//
//          if (IzquierdaAbajo) {
//            Vertice VIA = grafoFanstamaUno.obtenerVerticePorCordenada(i + 1, j - 1);
//            if (VIA != null) {
//              grafoFanstamaUno.insertarArista(enlaceV.nombreVertice, VIA.nombreVertice, 1);
//            }
//
//          }
        }

      }
    }
  }

  public boolean puedoIrArriba(int x, int y) {
    return (x - 1 >= 0);
  }

  public boolean puedoIrAbajo(int x, int y) {
    return (x + 1 <= this.mapa.getAncho() - 1);
  }

  public boolean puedoIrDerecha(int x, int y) {
    return (y + 1 <= mapa.getLargo() - 1);
  }

  public boolean puedoIrIzquierda(int x, int y) {
    return (y - 1 >= 0);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    this.mapa.dibujarMapa(g);
    this.pacman.pintarJugador(g);
    this.FR.pintarJugador(g);
    this.FP.pintarJugador(g);
    this.FA.pintarJugador(g);
    this.FN.pintarJugador(g);
  }

}
