
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
	File name: CelsiusGUI.java
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
public class CelsiusGUI extends TemperatureGUI
{	public CelsiusGUI(TemperatureModel model, int h, int v)
	{	super("Celsius Temperature", model, h, v);
		setDisplay(""+model.getC());
		addUpListener(new UpListener());
		addDownListener(new DownListener());
		addDisplayListener(new DisplayListener());
	}
	
	public void update(Observable t, Object o) // Called from the Model
	{	setDisplay("" + model().getC());
	}

	
	class UpListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	model().setF(model().getC() + 1.0);
		}
	}
	
	class DownListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	model().setF(model().getC() - 1.0);
		}
	}
	
	class DisplayListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	double value = getDisplay();
			model().setC(value);
		}
	}
        
        interface ValueStrategy
{	public void set(double d);
	public double get();
}
        
        class CelsiusStrategy implements ValueStrategy
{	public CelsiusStrategy(TemperatureModel m) {model = m;}
	public void set(double d){model.setC(d);}
	public double get(){ return model.getC();}
	
	private TemperatureModel model;
}
    }