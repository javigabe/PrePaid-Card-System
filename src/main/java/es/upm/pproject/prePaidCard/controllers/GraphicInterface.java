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
            
            
            //BUTTON BUY CARD

            JButton buttonBuyCard = new JButton("BUY CARD");
            buttonBuyCard.setForeground(Color.BLACK);
            buttonBuyCard.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonBuyCard.setBackground(Color.WHITE);
            buttonBuyCard.setBounds(300, 30, 400, 100);
            buttonBuyCard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	window.setVisible(false); // NOT VISIBLE MAIN WINDOW
                	GraphicInterface windowBuyCard = new GraphicInterface();
                	windowBuyCard.setSize(1000,800); //SIZE OF WINDOW
        			windowBuyCard.setLocation(450,125); //LOCATION
        			windowBuyCard.setResizable(false); //NO MAXIMIZE
        			windowBuyCard.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        			windowBuyCard.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
                    windowBuyCard.setVisible(true); //VISIBLE
                    windowBuyCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                }
            });
            window.add(buttonBuyCard);
            
            //BUTTON CHARGE CARD

            JButton buttonChargeCard = new JButton("CHARGE CARD");
            buttonChargeCard.setForeground(Color.BLACK);
            buttonChargeCard.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonChargeCard.setBackground(Color.WHITE);
            buttonChargeCard.setBounds(300, 150, 400, 100);
            buttonChargeCard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	window.setVisible(false); // NOT VISIBLE MAIN WINDOW
                	GraphicInterface windowChargeCard = new GraphicInterface();
                	windowChargeCard.setSize(1000,800); //SIZE OF WINDOW
        			windowChargeCard.setLocation(450,125); //LOCATION
        			windowChargeCard.setResizable(false); //NO MAXIMIZE
        			windowChargeCard.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        			windowChargeCard.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
                    windowChargeCard.setVisible(true); //VISIBLE
                    windowChargeCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   
                }
            });         
            window.add(buttonChargeCard);
            
            //BUTTON PAY CARD
 
            JButton buttonPayCard = new JButton("PAY CARD");
            buttonPayCard.setForeground(Color.BLACK);
            buttonPayCard.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonPayCard.setBackground(Color.WHITE);
            buttonPayCard.setBounds(300, 270, 400, 100);
            buttonPayCard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	window.setVisible(false); // NOT VISIBLE MAIN WINDOW
                	GraphicInterface windowPayCard = new GraphicInterface();
                	windowPayCard.setSize(1000,800); //SIZE OF WINDOW
        			windowPayCard.setLocation(450,125); //LOCATION
        			windowPayCard.setResizable(false); //NO MAXIMIZE
        			windowPayCard.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        			windowPayCard.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
                    windowPayCard.setVisible(true); //VISIBLE
                    windowPayCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   
                }
            });
            window.add(buttonPayCard);
            
            //BUTTON CHANGE PIN

            JButton buttonChangePin = new JButton("CHANGE PIN");
            buttonChangePin.setForeground(Color.BLACK);
            buttonChangePin.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonChangePin.setBackground(Color.WHITE);
            buttonChangePin.setBounds(300, 390, 400, 100);
            buttonChangePin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	window.setVisible(false); // NOT VISIBLE MAIN WINDOW
                	GraphicInterface windowChangePin = new GraphicInterface();
                	windowChangePin.setSize(1000,800); //SIZE OF WINDOW
        			windowChangePin.setLocation(450,125); //LOCATION
        			windowChangePin.setResizable(false); //NO MAXIMIZE
        			windowChangePin.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        			windowChangePin.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
                    windowChangePin.setVisible(true); //VISIBLE
                    windowChangePin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   
                }
            });
            window.add(buttonChangePin);
            
            //BUTTON CONSULT MOVEMENTS

            JButton buttonConsultMovements = new JButton("CONSULT MOVEMENTS");
            buttonConsultMovements.setForeground(Color.BLACK);
            buttonConsultMovements.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonConsultMovements.setBackground(Color.WHITE);
            buttonConsultMovements.setBounds(300, 510, 400, 100);
            buttonConsultMovements.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	window.setVisible(false); // NOT VISIBLE MAIN WINDOW
                	GraphicInterface windowConsultMovements = new GraphicInterface();
                	windowConsultMovements.setSize(1000,800); //SIZE OF WINDOW
        			windowConsultMovements.setLocation(450,125); //LOCATION
        			windowConsultMovements.setResizable(false); //NO MAXIMIZE
        			windowConsultMovements.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        			windowConsultMovements.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
                    windowConsultMovements.setVisible(true); //VISIBLE
                    windowConsultMovements.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   
                }
            });
            window.add(buttonConsultMovements);
            
            //BUTTON CONSULT BALANCE

            JButton buttonConsultBalance = new JButton("CONSULT BALANCE");
            buttonConsultBalance.setForeground(Color.BLACK);
            buttonConsultBalance.setFont(new Font("Consolas", Font.BOLD, 28));
            buttonConsultBalance.setBackground(Color.WHITE);
            buttonConsultBalance.setBounds(300, 630, 400, 100);
            buttonConsultBalance.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	window.setVisible(false); // NOT VISIBLE MAIN WINDOW
                	GraphicInterface windowConsultBalance = new GraphicInterface();
                	windowConsultBalance.setSize(1000,800); //SIZE OF WINDOW
        			windowConsultBalance.setLocation(450,125); //LOCATION
        			windowConsultBalance.setResizable(false); //NO MAXIMIZE
        			windowConsultBalance.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        			windowConsultBalance.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
                    windowConsultBalance.setVisible(true); //VISIBLE
                    windowConsultBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   
                }
            });
            window.add(buttonConsultBalance);
            
            //MAIN WINDOW
            window.setSize(1000,800); //SIZE OF WINDOW
			window.setLocation(450,125); //LOCATION
            window.setResizable(false); //NO MAXIMIZE
            //window.getContentPane().setBackground(Color.BLUE); //BACKGROUND COLOR
			window.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
			window.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
			window.getContentPane().setLayout(new GridLayout(3,2)); //new GridLayaout(3,2) or null
            window.setVisible(true); //VISIBLE
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
}
