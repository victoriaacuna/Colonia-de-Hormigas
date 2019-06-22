
package Algoritmo;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo {
    
    private int x;
    private int y;
    String ciudad;
    public static final int d=45; 
    public Color color;
    
    public Circulo(int x, int y, String ciudad) {
        this.x = x;
        this.y = y;
        this.ciudad = ciudad; 
        this.color = Color.PINK; 
    }
    
    public void dibujarCiudad(Graphics g){
        g.setColor(color);
        g.fillOval(x-d/2, y-d/2, d, d);//rellena el circulo con el color que se establece por el rectangulo especiificado (int x( le resto el radio a la pos), int y ( le resto el radio a la pos), altura(diametro), ancho)
        g.setColor(Color.BLACK);
        g.drawString(ciudad, x-d/3, y+d/6); 
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
