package Paintdib;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Texto extends Componentes {

    public Texto(int x1, int y1, int x2, int y2, Color borde, String palabra) {
        super(x1, y1, x2, y2, borde, null, palabra);
    }

    @Override
    public void dibujarFigura(Graphics2D g2) {
        Font f = new Font("Arial", Font.PLAIN, 20);
        g2.setFont(f);
        g2.setColor(borde);
        g2.drawString(palabra, x1, y1);
    }
}