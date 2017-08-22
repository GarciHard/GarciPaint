package Paintdib;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Componentes {

    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected Color borde, relleno;
    String palabra;

    public Componentes(int x1, int y1, int x2, int y2, Color c, Color relleno, String palabra) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.borde = c;
        this.relleno = relleno;
        this.palabra = palabra;
    }

    public abstract void dibujarFigura(Graphics2D g2);

    public void setColor(Color c) {
        this.borde = c;
    }

    public Color getColor() {
        return borde;
    }

    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @return the relleno
     */
    public Color getRelleno() {
        return relleno;
    }

    /**
     * @param relleno the relleno to set
     */
    public void setRelleno(Color relleno) {
        this.relleno = relleno;
    }
    /**
     * @return the c
     */
}
