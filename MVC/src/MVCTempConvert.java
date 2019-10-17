
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

/**
	File name: MVCTempConvert.java
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
public class MVCTempConvert 
{	public static void main(String args[]) 
	{	TemperatureModel temperature = new TemperatureModel();
		FarenheitGUI f = new FarenheitGUI(temperature, 100, 100);
		CelsiusGUI c = new CelsiusGUI(temperature,100, 250);
                SliderGUI s = new SliderGUI(temperature, 100, 400);
                GraphGUI g = new GraphGUI(temperature, 200, 600);
	}


	public void setDisplay(String s){ display.setText(s);}
	
	public double getDisplay()
	{	double result = 0.0;
		try
		{	result = Double.valueOf(display.getText()).doubleValue();
		}
		catch (NumberFormatException e){}
		return result;
	}
	
	public void addDisplayListener(ActionListener a){ display.addActionListener(a);}
	public void addUpListener(ActionListener a){ upButton.addActionListener(a);}
	public void addDownListener(ActionListener a){ downButton.addActionListener(a);}
	
	protected TemperatureModel model(){return model;}
	
	private String label;
	private TemperatureModel model;
	private Frame temperatureFrame;
	private TextField display = new TextField();
	private Button upButton = new Button("Raise");
	private Button downButton = new Button("Lower");
	
	public class CloseListener extends WindowAdapter
	{	public void windowClosing(WindowEvent e)
		{	e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
        
        	
	
    }
        
      

