
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Observable;

/**
	File name: GraphGUI.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/




/**
 *
 * @author Joshua
 */
public class GraphGUI extends Frame implements Observer
{	
    private TemperatureModel model;
	private Canvas gauges;
	private TemperatureGauge _farenheit;
        
    public GraphGUI(TemperatureModel model, int h, int v)
	{ 	super("Temperature Gauge");
		this.model = model;
		_farenheit = new TemperatureGauge(-200, 300);
		Panel Top = new Panel();
		add("North", Top);
		gauges = new TemperatureCanvas(_farenheit);
		gauges.setSize(500,280);
		add("Center", gauges);		
                setSize(280, 500);
		setLocation(h,v);
		setVisible(true);
		//model.addObserver((java.util.Observer) this); // Connect to the model
	}
	
	public void update(Observable obs, Object o) // Respond to changes
	{	repaint();
	}
		
	public void paint(Graphics g)
	{	int farenheit = (int)model.getF(); // Use the current data to paint
		_farenheit.set(farenheit);
		gauges.repaint();
		super.paint(g);
	}
}
