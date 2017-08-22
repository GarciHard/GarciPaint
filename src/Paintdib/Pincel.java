package Paintdib;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Pincel extends Componentes {
    public Pincel(int x1, int y1, int x2, int y2, Color borde) {
        super(x1, y1, x2, y2, borde, null, null);
    }
    
    @Override
    public void dibujarFigura(Graphics2D g2) {
        Line2D.Float r = new Line2D.Float(x1, y1, x2, y2);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(borde);
        g2.draw(r);
    }
}
