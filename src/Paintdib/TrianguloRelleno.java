package Paintdib;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class TrianguloRelleno extends Componentes {
    public TrianguloRelleno(int x1, int y1, int x2, int y2, Color relleno, Color borde) {
        super(x1, y1, x2, y2, relleno, borde, null);
    }

    @Override
    public void dibujarFigura(Graphics2D g2) {
        Color re = null;
        int[] xCoords = new int[3];
        int[] yCoords = new int[3];

        xCoords[0] = x1;
        yCoords[0] = y1;
        xCoords[1] = x1 - (x2 - x1);
        yCoords[1] = y2;
        xCoords[2] = x2;
        yCoords[2] = y2;
        
        Polygon p = new Polygon(xCoords, yCoords, 3);
        
        if (relleno != re) {
            g2.setColor(borde);
            g2.fill(p);
        }
        
        g2.setStroke(new BasicStroke(2));
        g2.setColor(relleno);
        g2.draw(p);
    }
}