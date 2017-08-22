package Paintdib;

import java.awt.Graphics2D;
import java.awt.Color;

public class Punto extends Componentes{

    public Punto(int x,int x2,int y, int y2, Color relleno,Color borde)
    {
    super(x,x2,y,y2,relleno,borde,null);
    }
    public void dibujarFigura(Graphics2D g2) {
        g2.setColor(borde);
        g2.setColor(relleno);
        g2.fillOval(x1, y1, 10, 10);
    }
    
}
