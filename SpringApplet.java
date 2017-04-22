package lab3;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Timer;

import javax.swing.JApplet;

public class SpringApplet extends JApplet {

	public static final int WIDTH=640; // definiuje szerokosc oraz wysokosc appletu, które ustawiam w konfiguracjach RUN,
	public static final int HEIGHT=480; // zmiennych tych bede uzywac przy rysowaniu wektorów
	
	private SimEngine pole1;
	private SimTask pole2;
	private Timer timer1;
	
	
	public SpringApplet()
	{		
		
	}
	
	private static final long serialVersionUID = 1L;
	

	
	public void init()
	{
		SpringApplet applet1 = new SpringApplet();
		SimEngine silnik1 = new SimEngine(50,1,0.75,WIDTH/2,HEIGHT-100,10,50,10);
		SimTask simtask = new SimTask(pole1,applet1);
		Timer timerr1 = new Timer();
		pole1 = silnik1;
		pole2 = simtask;
		this.timer1 = timerr1;
		timer1.scheduleAtFixedRate(pole2, 1000, 1000);
		
	}
	
	// kod do zadania dodatkowego
	// rozmiary okna appletu ustawiam w opcjach kompilacj
	public void paint(Graphics g)
	{
		
		
		SimEngine silnik1 = new SimEngine(2,1,0.75,WIDTH/2,300,10,60,10);
		Vector2D wektorG = new Vector2D(silnik1.getXMasa(),silnik1.getYMasa(),silnik1.getXMasa(), silnik1.getYMasa()+(silnik1.getMasa()*silnik1.getG()));
		Polygon grotG = new Polygon(wektorG.getPolygonX(),wektorG.getPolygonY(),5);
		
		//rysowanie siatki wspolrzednych
		for(int j = 0; j<HEIGHT;j+=12)
		{
			for(int i = 0; i<WIDTH;i+=12)
			{
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(0+i, silnik1.getYZawK()+j, 0+i, silnik1.getYZawK()+6+j);
			g.drawLine(i+3,j+3+silnik1.getYZawK(),i+9,j+3+silnik1.getYZawK());
			}
		}
		
		g.setColor(Color.RED);
		g.fillOval(silnik1.getXMasa()-silnik1.getROval(),silnik1.getYMasa()-silnik1.getROval(),2*silnik1.getROval(),2*silnik1.getROval());
	
		
		//rysowanie spręzyny
		
		for(int i = 10; i<silnik1.zaczepieniezMasa(); i+=10)
		{
			g.setColor(Color.BLUE);
			g.drawLine(silnik1.getXZawK()-10, silnik1.getYZawK()+(i-10),silnik1.getXZawK()+10, silnik1.getYZawK()+(i));
			g.drawLine(silnik1.getXZawK()+10, silnik1.getYZawK()+(i-10),silnik1.getXZawK()-10, silnik1.getYZawK()+(i));
			
		}
		
		
		for(int i = 0; i<WIDTH;i+=10)
		{
			g.setColor(Color.BLACK);
			g.drawLine(0, silnik1.getYZawK(),WIDTH,	silnik1.getYZawK());
			g.drawLine(0+i,silnik1.getYZawK(), 10+i, 0);
		}
		g.setColor(Color.GREEN);
		g.drawLine((int)wektorG.x1,(int)wektorG.y1,(int)wektorG.x2,(int)wektorG.y2);
		g.fillPolygon(grotG);
		g.setColor(Color.BLACK);
		g.drawString("Wektor G", wektorG.getXString(), wektorG.getYString());
	}
}

