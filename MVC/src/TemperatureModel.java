/**
	File name: MVCPractice.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/



import java.awt.*;
import java.util.Observable;
/**
 *
 * @author Joshua
 */

    interface Observer
{	void update(Observable t, Object o);	
}
    public class TemperatureModel extends java.util.Observable
{	public double getF(){return temperatureF;}
	
	public double getC(){return (temperatureF - 32.0) * 5.0 / 9.0;}
	
	public void setF(double tempF)
	{	temperatureF = tempF;
		setChanged();
		notifyObservers();
	}
	
	public void setC(double tempC)
	{	temperatureF = tempC*9.0/5.0 + 32.0;
		setChanged();
		notifyObservers();
	}

	private double temperatureF = 32.0;
}

class TemperatureCanvas extends Canvas
{	public TemperatureCanvas(TemperatureGauge farenheit)
	{	_farenheit = farenheit;
	}
	
	public void paint(Graphics g)
	{	g.setColor(Color.black);
		g.drawRect(left,top, width, height);
		g.setColor(Color.red);
		g.fillOval(left-width/2, top+height-width/3,width*2, width*2);
		g.setColor(Color.black);
		g.drawOval(left-width/2, top+height-width/3,width*2, width*2);
		g.setColor(Color.white);
		g.fillRect(left+1,top+1, width-1, height-1);
		g.setColor(Color.red);
		long redtop = height*(_farenheit.get()-_farenheit.getMax())/(_farenheit.getMin()-_farenheit.getMax());
		g.fillRect(left+1, top + (int)redtop, width-1, height-(int)redtop);
	}
	
	private TemperatureGauge _farenheit;
	private static final int width = 20;
	private static final int top = 20;
	private static final int left = 100;
	private static final int right = 250;
	private static final int height = 200;
}

class TemperatureGauge
{	public TemperatureGauge(int min, int max){ Min = min; Max = max; }
	
	public void set(int level) { current = level; }	
	public int get(){return current;}
	public int getMax(){return Max;}
	public int getMin(){return Min;}
	
	private int Max, Min, current;
}


	
	

