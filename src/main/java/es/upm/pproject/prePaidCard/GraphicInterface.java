package es.upm.pproject.prePaidCard;
import java.awt.*;
import javax.swing.*;


public class GraphicInterface extends JFrame{
	//CONSTRUCTOR
	public GraphicInterface() {}
	
	//MAIN
	public static void main(String[] args) {
		try {
			GraphicInterface window = new GraphicInterface();
			window.setSize(1000,800); //SIZE OF WINDOW
			window.setLocation(450,125); //LOCATION
			window.setResizable(false); //NO MAXIMIZE
			window.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
			window.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
            window.setVisible(true); //VISIBLE
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	
}
