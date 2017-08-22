package Paintdib;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RectanguloSombra extends Componentes {
    public RectanguloSombra(int x1, int y1, int x2, int y2, Color c, Color relleno) {
        super(x1, y1, x2, y2, c, relleno, null);
    }

    @Override
    public void dibujarFigura(Graphics2D g2) {
              
        Rectangle2D r2 = new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        Rectangle2D r3 = new Rectangle2D.Float(Math.min(x1+15, x2), Math.min(y1+15, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        Color color = new Color(0,0,0,75);
        g2.setColor(color);
        g2.fill(r3);
        g2.draw(r3);
        
        g2.setColor(borde);
        g2.fill(r2);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(relleno);
        g2.draw(r2);
        
        g2.setPaint(new GradientPaint(5,30,borde,15,100,relleno,true));
        g2.fill(r2);
    }
}