package Paintdib;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

public class Curva extends Componentes{
   
    private int v=1, p1, p2, p3, p4,p5,p6;
    public Curva(int x1, int y1, int x2, int y2, Color borde, Color relleno,int v)
    {
        super(x1,y1,x2,y2, borde, borde,null);
        this.v=v;
    }
    

    public void dibujarFigura(Graphics2D g2) {
      
       if(v==1)
       {
           p1=x1; p2=y1; p3=x2+(x2-x1); p4=(y2+y1)/2; p5=x1; p6=y2;
       }
       if(v==2)
       {
           p1=x1; p2=y1; p3=(x2+x1)/2; p4=y2+(y2-y1); p5=x2; p6=y1;
       }
       g2.setColor(borde);
       QuadCurve2D c= new QuadCurve2D.Double(p1, p2, p3, p4, p5,p6);
       g2.draw(c);
       g2.setStroke(new BasicStroke(2));

    }

}
