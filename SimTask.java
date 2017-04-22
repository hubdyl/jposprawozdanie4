package lab3;

import java.util.TimerTask;

public class SimTask extends TimerTask{


	@SuppressWarnings("unused")
	private SimEngine pole1;
	private SpringApplet pole2;
	private double odstep;
	
	public SimTask()
	{
		
	}
	
	public SimTask(SimEngine pole1, SpringApplet pole2)
	{
		this.pole1 = pole1;
		this.pole2 = pole2;
		this.odstep = odstep();
	}
	

	@Override
	
	
	public void run() {
		this.odstep++;
		pole2.repaint();
		System.out.println("Minelo czasu : "+this.odstep()+"\n");
	}
	
	public double odstep()
	{
		return this.odstep;
	}
	

}
