/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Javier Alberto Palacios Lopez
 */
public abstract class Jugador {
 
  protected int x;
  protected int y;
  //protected int ancho = (int)Math.pow(2, 4);
  //protected int largo = (int)Math.pow(2, 4);
  protected int ancho = 20;
  protected int largo = 20;
  
  protected BufferedImage BI;
  
  public Jugador(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setAncho(int ancho) {
    this.ancho = ancho;
  }

  public void setLargo(int largo) {
    this.largo = largo;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getAncho() {
    return ancho;
  }

  public int getLargo() {
    return largo;
  }
  
  protected void bufferDeImagen(String ruta){
    
    try {
      this.BI = ImageIO.read(new File(ruta));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    
  }
  
  protected abstract void pintarJugador(Graphics g);
  
}
