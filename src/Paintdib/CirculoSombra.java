package Paintdib;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;

public class CirculoSombra extends Componentes {

    public CirculoSombra(int x, int x2, int y, int y2, Color relleno, Color borde) {
        super(x, x2, y, y2, relleno, borde, null);
    }

    public void dibujarFigura(Graphics2D g2) {
        
        BufferedImage buff = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        Graphics2D gg = buff.createGraphics();
        gg = buff.createGraphics();
        gg.setColor(borde);
        gg.fillRect(0, 0, 10, 10);
        gg.setColor(Color.BLACK);
        gg.fillRect(1, 1, 6, 6);
        gg.setColor(Color.BLUE);
        gg.fillRect(1, 1, 3, 3);
        gg.setColor(relleno);
        gg.fillRect(4, 4, 3, 3);
        
        Ellipse2D r = new Ellipse2D.Double(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        Ellipse2D r2 = new Ellipse2D.Double(Math.min(x1+15, x2), Math.min(y1+15, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
        Color color = new Color(0,0,0,75);
        g2.setColor(color);
        g2.fill(r2);
        g2.draw(r2);
        g2.setColor(borde);
        g2.fill(r);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(relleno);
        g2.draw(r);
        
        g2.setPaint(new TexturePaint(buff, new Rectangle(10,10)));
        g2.fill(r);

    }
}
