/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pcm;

import contenedores.Lienzo;
import eventos.MovimientoFantasma;
import eventos.MovimientoPacman;
import javax.swing.JFrame;
import mapa.MapaUno;
import mapa.Mosaicos;
import personajes.FantasmaAzul;
import personajes.FantasmaNaranja;
import personajes.FantasmaRojo;
import personajes.FantasmaRosa;
import personajes.Pacman;

/**
 *
 * @author Cazaputas666
 */
public class Pcm {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    
    Pacman pacman = new Pacman(260, 340);
    FantasmaRojo FR = new FantasmaRojo(13*20, 13*20);
    FantasmaRosa FP = new FantasmaRosa(14 * 20, 14 * 20);
    FantasmaAzul FA = new FantasmaAzul(15*20, 15*20);
    FantasmaNaranja FN = new FantasmaNaranja(17*20, 14*20);
    
    final int numeroMosaicosX = 33;
    final int numeroMosaicosY = 30;
    
    MapaUno MU = new MapaUno(new Mosaicos[numeroMosaicosY][numeroMosaicosX]);
    
    Lienzo l = new Lienzo(MU, pacman,FR,FP,FA,FN);
    
//    System.out.println(l.getGrafoFanstamaUno().inicioVerice.x+" "+l.getGrafoFanstamaUno().inicioVerice.y);
//    
    MovimientoPacman MP = new MovimientoPacman(l, MU, pacman);
    MovimientoFantasma MFR = new MovimientoFantasma(l,MU,pacman,FR,FP,FA,FN);
    
    JFrame j = new JFrame("Pac-man");
    j.setSize(620, 665);
    j.add(l);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.setVisible(true);
    MFR.iniciarBot();
    
    
  }
  
}
