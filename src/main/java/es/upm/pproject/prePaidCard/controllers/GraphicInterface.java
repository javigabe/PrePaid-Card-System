package es.upm.pproject.prePaidCard.controllers;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class GraphicInterface extends JFrame{
	//CONSTRUCTOR
	public GraphicInterface() {}
	
	//MAIN
	public static void main(String[] args) {
		try {
			//MAIN WINDOW
			GraphicInterface window = new GraphicInterface();
			window.setSize(1000,800); //SIZE OF WINDOW
			window.setLocation(450,125); //LOCATION
			window.setResizable(false); //NO MAXIMIZE
			window.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
			window.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
			window.getContentPane().setBackground(Color.CYAN); //COLOR OF WINDOW
            window.setVisible(true); //VISIBLE
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setLayout(null);
            //window.setLayout(null);
            
            //BUTTON BUY CARD

            JButton buttonBuyCard = new JButton("BUY CARD");
            buttonBuyCard.setForeground(Color.BLACK);
            buttonBuyCard.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonBuyCard.setBackground(Color.WHITE);
            buttonBuyCard.setBounds(300, 30, 400, 100);

            window.add(buttonBuyCard);
            
            //BUTTON CHARGE CARD

            JButton buttonChargeCard = new JButton("CHARGE CARD");
            buttonChargeCard.setForeground(Color.BLACK);
            buttonChargeCard.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonChargeCard.setBackground(Color.WHITE);
            buttonChargeCard.setBounds(300, 150, 400, 100);
           
            window.add(buttonChargeCard);
            
            //BUTTON PAY CARD
 
            JButton buttonPayCard = new JButton("PAY CARD");
            buttonPayCard.setForeground(Color.BLACK);
            buttonPayCard.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonPayCard.setBackground(Color.WHITE);
            buttonPayCard.setBounds(300, 270, 400, 100);
    
            window.add(buttonPayCard);
            
            //BUTTON CHANGE PIN

            JButton buttonChangePin = new JButton("CHANGE PIN");
            buttonChangePin.setForeground(Color.BLACK);
            buttonChangePin.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonChangePin.setBackground(Color.WHITE);
            buttonChangePin.setBounds(300, 390, 400, 100);

            window.add(buttonChangePin);
            
            //BUTTON CONSULT MOVEMENTS

            JButton buttonConsultMovements = new JButton("CONSULT MOVEMENTS");
            buttonConsultMovements.setForeground(Color.BLACK);
            buttonConsultMovements.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonConsultMovements.setBackground(Color.WHITE);
            buttonConsultMovements.setBounds(300, 510, 400, 100);
            
            window.add(buttonConsultMovements);
    
            //BUTTON CONSULT BALANCE

            JButton buttonConsultBalance = new JButton("CONSULT BALANCE");
            buttonConsultBalance.setForeground(Color.BLACK);
            buttonConsultBalance.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonConsultBalance.setBackground(Color.WHITE);
            buttonConsultBalance.setBounds(300, 630, 400, 100);

            window.add(buttonConsultBalance);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	
}
