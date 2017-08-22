package Paintdib;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class Circulo extends Componentes {

    public Circulo(int x, int x2, int y, int y2, Color relleno, Color borde) {
        super(x, x2, y, y2, relleno, borde, null);
    }

    public void dibujarFigura(Graphics2D g2) {
        Ellipse2D r = new Ellipse2D.Double(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));


        g2.setColor(borde);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(relleno);
        g2.draw(r);
    }
}
