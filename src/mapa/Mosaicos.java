/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import personajes.Jugador;

/**
 *
 * @author Javier Alberto Palacios Lopez
 */
public class Mosaicos extends Jugador{

  private boolean esPared;
  
  public Mosaicos(int x, int y, boolean esPared) {
    super(x, y);
    this.esPared = esPared;
  }

  public boolean isEsPared() {
    return esPared;
  }

  public void setEsPared(boolean esPared) {
    this.esPared = esPared;
  }
  
  @Override
  public void pintarJugador(Graphics g) {
    
    g.setColor(Color.BLUE);
    g.fillRect(this.x, this.y, this.ancho,this.largo);
    
    g.setColor(Color.WHITE);
    g.drawRect(this.x, this.y, this.ancho,this.largo);
  }
  
  
  
}
