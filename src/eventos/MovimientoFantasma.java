/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventos;

import contenedores.Lienzo;
import grafo.InsertarDatos;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapa.MapaUno;
import personajes.FantasmaAzul;
import personajes.FantasmaNaranja;
import personajes.FantasmaRojo;
import personajes.FantasmaRosa;
import personajes.Jugador;
import personajes.Pacman;

/**
 *
 * @author CazaPutas666
 */
public class MovimientoFantasma {

  private final Lienzo l;
  private final MapaUno mu;
  private final Pacman pacman;
  private final FantasmaRojo FR;
  private final FantasmaRosa FP;
  private final FantasmaAzul FA;
  private final FantasmaNaranja FN;
  private static final int CALCULADOBUSQUEDA = 2;
  //private InsertarDatos id;
  //  private InsertarDatos grafoRojo;
  //  private InsertarDatos grafoRosa;

  public MovimientoFantasma(Lienzo l, MapaUno MU, Pacman pacman, FantasmaRojo FR, FantasmaRosa FP, FantasmaAzul FA, FantasmaNaranja FN) {

    this.l = l;
    this.mu = MU;
    this.pacman = pacman;
    this.FR = FR;
    this.FP = FP;
    this.FA = FA;
    this.FN = FN;

  }

  public void iniciarBot() {

    try {

      HiloFantasma f1 = new HiloFantasma(FR, 100);
      HiloFantasma f2 = new HiloFantasma(FP, 110);
      HiloFantasma f3 = new HiloFantasma(FA, 120);
      HiloFantasma f4 = new HiloFantasma(FN, 130);

      f1.start();
      Thread.sleep(2000);

      f2.start();
      Thread.sleep(2000);

      f3.start();
      Thread.sleep(2000);

      f4.start();

    } catch (InterruptedException ex) {
      Logger.getLogger(MovimientoFantasma.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  private class HiloFantasma extends Thread {

    private Jugador jugador;
    private int tiempo;

    public HiloFantasma(Jugador jugador, int tiempo) {
      this.jugador = jugador;
      this.tiempo = tiempo;
    }

    @Override
    public void run() {

      while (true) {

        InsertarDatos id = new InsertarDatos();

        l.insertarVerticesTablero(id, 1);

        Vertice jugadorPosicion = id.obtenerVerticePorCordenada(this.jugador.getX() / MovimientoPacman.VELOCIDADPACMAN, this.jugador.getY() / MovimientoPacman.VELOCIDADPACMAN);

        Vertice comidaPosicion = id.obtenerVerticePorCordenada(pacman.getX() / MovimientoPacman.VELOCIDADPACMAN, pacman.getY() / MovimientoPacman.VELOCIDADPACMAN);

        ArrayList<Vertice> v = id.dijkstra(jugadorPosicion.nombreVertice, comidaPosicion.nombreVertice);

        int aux = 0;
        //jugador.setPuntos(v);
        for (int i = 0; i < v.size(); i++) {

          if (aux == CALCULADOBUSQUEDA) {
            //i = v.size();
            break;
          } else {
            
            Vertice v1 = v.get(i);

            jugador.setX(v1.x * 20);
            jugador.setY(v1.y * 20);
            l.repaint();

            try {
              Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
            }
          }
          aux = aux + 1;
        }

        l.repaint();
      }

    }

  }

}
