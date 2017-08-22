package Paintdib;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Renderizado extends JComponent {

    private Point inicioArrastre, finArrastre;
    private ArrayList<Componentes> listaFiguras;
    private int accion = 0, base, altura, v;
    private Color relleno = Color.white;
    private Color borde = Color.BLACK;
    String palabra;
    int tama;
    Graphics2D g2;
    private String im;

    public Renderizado(int c1, int c2) {
        super();
        setSize(c1, c2);
        listaFiguras = new ArrayList<>();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse

                finArrastre = new Point(e.getX(), e.getY());
                if (accion == 11) {
                    Linea ln = new Linea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde());
                    listaFiguras.add(ln);
                }
                if (accion == 20) {
                    Texto tx = new Texto(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde(), palabra);
                    listaFiguras.add(tx);
                }
                if (accion == 3) {
                    getListaFiguras().add(new Triangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 13) {
                    getListaFiguras().add(new TrianguloRelleno(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 4) {
                    getListaFiguras().add(new Circulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 14) {
                    getListaFiguras().add(new CirculoRelleno(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 80) {
                    getListaFiguras().add(new CirculoSombra(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 24) {
                    getListaFiguras().add(new Punto(inicioArrastre.x, inicioArrastre.y, 0, 0, getRelleno(), getBorde()));
                }
                if (accion == 7) {
                    getListaFiguras().add(new Rectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 17) {
                    getListaFiguras().add(new RectanguloRelleno(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 90) {
                    getListaFiguras().add(new RectanguloSombra(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde()));
                }
                if (accion == 8) {
                    getListaFiguras().add(new Curva(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde(), getBorde(), getV()));
                }

                inicioArrastre = null;
                finArrastre = null;
                repaint();

            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse

                finArrastre = new Point(e.getX(), e.getY());
                if (accion == 55) {
                    Lapiz lp = new Lapiz(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde());
                    listaFiguras.add(lp);
                    inicioArrastre = new Point(finArrastre.x, finArrastre.y);
                }
                repaint();

                if (accion == 15) {
                    Pincel pl = new Pincel(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde());
                    listaFiguras.add(pl);
                    inicioArrastre = new Point(finArrastre.x, finArrastre.y);
                }
                repaint();

                if (accion == 33) {
                    Goma gm = new Goma(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde());
                    listaFiguras.add(gm);
                    inicioArrastre = new Point(finArrastre.x, finArrastre.y);
                }
                repaint();

            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g2 = (Graphics2D) g;


        for (Componentes f : listaFiguras) {
            if (f instanceof Imagen) {

                Imagen ima = (Imagen) f;
                ima.dibujarFigura(g2);
            }
            if (f instanceof Linea) {
                Linea l = (Linea) f;
                l.dibujarFigura(g2);
            }
            if (f instanceof Lapiz) {
                Lapiz lp = (Lapiz) f;
                lp.dibujarFigura(g2);
            }
            if (f instanceof Pincel) {
                Pincel pl = (Pincel) f;
                pl.dibujarFigura(g2);
            }
            if (f instanceof Goma) {
                Goma gm = (Goma) f;
                gm.dibujarFigura(g2);
            }
            if (f instanceof Texto) {
                Texto tx = (Texto) f;
                tx.dibujarFigura(g2);
            }
            if (f instanceof Triangulo) {

                Triangulo t = (Triangulo) f;
                t.dibujarFigura(g2);
            }
            if (f instanceof TrianguloRelleno) {

                TrianguloRelleno tr = (TrianguloRelleno) f;
                tr.dibujarFigura(g2);
            }
            if (f instanceof Circulo) {

                Circulo c = (Circulo) f;
                c.dibujarFigura(g2);
            }
            if (f instanceof CirculoRelleno) {
                CirculoRelleno cr = (CirculoRelleno) f;
                cr.dibujarFigura(g2);
            }
            if (f instanceof CirculoSombra) {
                CirculoSombra cs = (CirculoSombra) f;
                cs.dibujarFigura(g2);
            }
            if (f instanceof Punto) {
                Punto pt = (Punto) f;
                pt.dibujarFigura(g2);
            }
            if (f instanceof Rectangulo) {

                Rectangulo r = (Rectangulo) f;
                r.dibujarFigura(g2);
            }
            if (f instanceof RectanguloRelleno) {
                RectanguloRelleno rr = (RectanguloRelleno) f;
                rr.dibujarFigura(g2);
            }
            if (f instanceof RectanguloSombra) {
                RectanguloSombra rs = (RectanguloSombra) f;
                rs.dibujarFigura(g2);
            }
            if (f instanceof Curva) {

                Curva cu = (Curva) f;
                cu.dibujarFigura(g2);
            }
        }
        if (accion == 11 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            Linea l = new Linea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde());
            l.dibujarFigura(g2);
        }
        if (accion == 3 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            Triangulo t = new Triangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            t.dibujarFigura(g2);
        }
        if (accion == 13 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            TrianguloRelleno tr = new TrianguloRelleno(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            tr.dibujarFigura(g2);
        }
        if (accion == 4 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            Circulo c = new Circulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            c.dibujarFigura(g2);
        }
        if (accion == 14 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            CirculoRelleno cr = new CirculoRelleno(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            cr.dibujarFigura(g2);
        }
        if (accion == 80 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            CirculoSombra cs = new CirculoSombra(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            cs.dibujarFigura(g2);
        }
        if (accion == 7 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            Rectangulo r = new Rectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            r.dibujarFigura(g2);
        }
        if (accion == 17 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            RectanguloRelleno rr = new RectanguloRelleno(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            rr.dibujarFigura(g2);
        }
        if (accion == 90 && inicioArrastre != null && finArrastre != null)// se esta arrastrando el raton?
        {
            RectanguloSombra rs = new RectanguloSombra(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getRelleno(), getBorde());
            rs.dibujarFigura(g2);
        }
        if (accion == 8 && inicioArrastre != null && finArrastre != null) {
            Curva cur = new Curva(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, getBorde(), getBorde(), v);
            cur.dibujarFigura(g2);
        }
        if (accion == 6 && inicioArrastre != null && finArrastre != null) {
            for (Componentes componente : listaFiguras) {
                if (componente instanceof Imagen) {
                    Imagen ima = (Imagen) componente;
                    if (ima.getRec().contains(inicioArrastre.x, inicioArrastre.y)) {
                        int tx = (finArrastre.x / 2);
                        int ty = (finArrastre.y / 2);
                        ima.setX1(tx);
                        ima.setY1(ty);
                    }
                }
            }
        }
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public ArrayList<Componentes> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(ArrayList<Componentes> figuras) {
        this.listaFiguras = figuras;
    }

    public void borrado() {

        listaFiguras.clear();
        repaint();
    }

    public void deshacer() {
        int total = 0;
        total = listaFiguras.size();
        if (total != 0) {
            listaFiguras.remove(total - 1);
        }
        repaint();
    }

    /**
     * @return the im
     */
    public String getIm() {
        return im;
    }

    /**
     * @param im the im to set
     */
    public void setIm(String im) {
        this.im = im;
    }

    /**
     * @return the base
     */
    public int getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Point getInicioArrastre() {
        return inicioArrastre;
    }

    /**
     * @param inicioArrastre the inicioArrastre to set
     */
    public void setInicioArrastre(Point inicioArrastre) {
        this.inicioArrastre = inicioArrastre;
    }

    /**
     * @return the finArrastre
     */
    public Point getFinArrastre() {
        return finArrastre;
    }

    /**
     * @param finArrastre the finArrastre to set
     */
    public void setFinArrastre(Point finArrastre) {
        this.finArrastre = finArrastre;
    }

    /**
     * @return the v
     */
    public int getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(int v) {
        this.v = v;
    }

    /**
     * @return the color
     */
    public Color getRelleno() {
        return relleno;
    }

    /**
     * @param relleno the color to set
     */
    public void setRelleno(Color relleno) {
        this.relleno = relleno;
    }

    /**
     * @return the relleno
     */
    public Color getBorde() {
        return borde;
    }

    /**
     * @param borde the relleno to set
     */
    public void setBorde(Color borde) {
        this.borde = borde;
    }
}