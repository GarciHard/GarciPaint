package Paintdib;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Imagen extends Componentes {

    String s;
    private Rectangle rec;
    private int accion, x3, y3;

    public Imagen(int x1, int y1, int x2, int y2, Color c, Color relleno, String s) {
        super(x1, y1, x2, y2, c, relleno, null);
        this.s = s;
    }

    @Override
    public void dibujarFigura(Graphics2D g2) {
        String x = s;
        ImageIcon im = new ImageIcon(x);



        g2.drawImage(im.getImage(), x1, y1, x2, y2, null);
        setRec(new Rectangle(x1, y1, x2, y2));
    }

    /**
     * @return the rec
     */
    public Rectangle getRec() {
        return rec;
    }

    /**
     * @param rec the rec to set
     */
    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    /**
     * @return the accion
     */
    public int getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(int accion) {
        this.accion = accion;
    }

    /**
     * @return the x3
     */
    public int getX3() {
        return x3;
    }

    /**
     * @param x3 the x3 to set
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @return the y3
     */
    public int getY3() {
        return y3;
    }

    /**
     * @param y3 the y3 to set
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }
}
