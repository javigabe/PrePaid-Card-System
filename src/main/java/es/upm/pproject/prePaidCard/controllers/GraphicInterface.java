package es.upm.pproject.prePaidCard.controllers;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import es.upm.pproject.prePaidCard.model.*;

public class GraphicInterface extends JFrame {
	//CONSTRUCTOR
	public GraphicInterface() {}
	
	//MAIN
	public static void main(String[] args) {

			PrePaidCardManager system= new PrePaidCardManager(true);
			
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
                    windowBuyCard.getContentPane().setLayout(null);
                    
                    //OWNER
                    JLabel labelOwner = new JLabel("OWNER:", JLabel.LEFT);
                    labelOwner.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelOwner.setBounds(200, 180, 400, 100);
                    windowBuyCard.add(labelOwner);
                    
                    JTextField textOwner = new JTextField();
                    textOwner.setFont(new Font("Consolas", Font.BOLD, 18));
                    textOwner.setBounds(300, 200, 400, 50);
                    windowBuyCard.add(textOwner);
                    
                    //PIN
                    JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
                    labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelPIN.setBounds(200, 280, 400, 100);
                    windowBuyCard.add(labelPIN);


                    JPasswordField textPIN = new JPasswordField(JLabel.LEFT);
                    textPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    textPIN.setBounds(300, 300, 400, 50);;
                    windowBuyCard.add(textPIN);
                    
                    //BALANCE
                    JLabel labelBalance = new JLabel("AMOUNT:", JLabel.LEFT);
                    labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelBalance.setBounds(200, 380, 400, 100);
                    windowBuyCard.add(labelBalance);
                    
                    JTextField textBalance = new JTextField();
                    textBalance.setFont(new Font("Consolas", Font.BOLD, 18));
                    textBalance.setBounds(300, 400, 400, 50);
                    windowBuyCard.add(textBalance);
                    
                    //WARNING
                    JLabel labelWarning = new JLabel("The PIN must have 4 digits and Amount must have at least one number");
                    labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning.setBounds(200, 700, 800, 50);
                    windowBuyCard.add(labelWarning);
                    
                    //CONTINUE BUTTON
                    JButton buttonContinue = new JButton("Continue");
                    buttonContinue.setForeground(Color.BLACK);
                    buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
                    buttonContinue.setBackground(Color.WHITE);
                    buttonContinue.setBounds(300, 550, 400, 100);
                    buttonContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	//ACCTION
                            try {
                            	//buyCard

                                long number = system.buyCard(textOwner.getText(), Long.parseLong(textBalance.getText()), String.valueOf(textPIN.getPassword()));
							    
							    //FILL IN THE NUMBER 
							    String cardNumber = Long.toString(number);
							    String nZeros= "";
							    for(int i=0; i<(12-cardNumber.length());i++) {
							       nZeros=nZeros+ "0";
							    }
							    cardNumber=nZeros+cardNumber;
							   
                                
	                        	windowBuyCard.setVisible(false); // NOT VISIBLE BUY CARD WINDOW
	                        	GraphicInterface windowContinue = new GraphicInterface();
	                        	windowContinue.setSize(1000,800); //SIZE OF WINDOW
	                			windowContinue.setLocation(450,125); //LOCATION
	                			windowContinue.setResizable(false); //NO MAXIMIZE
	                			windowContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
	                			windowContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
	                            windowContinue.setVisible(true); //VISIBLE
	                            windowContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            windowContinue.getContentPane().setLayout(null);
                               
	                        
	                            
	                            //TEXT   
	                            //Dear
	                            JLabel labelDear = new JLabel("Dear "+ textOwner.getText(), JLabel.CENTER);
	                            labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelDear.setBounds(300, 180, 400, 100);
	                            windowContinue.add(labelDear);
	                            //CardNumber
	                            JLabel labelCardNumber = new JLabel("Card Number: "+ cardNumber, JLabel.CENTER);
	                            labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelCardNumber.setBounds(300, 220, 400, 100);
	                            windowContinue.add(labelCardNumber);
	                            //Balance
	                            JLabel labelBalance = new JLabel("Balance: "+ textBalance.getText(), JLabel.CENTER);
	                            labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelBalance.setBounds(300, 260, 400, 100);
	                            windowContinue.add(labelBalance);
	                            //Thanks for using...
	                            JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
	                            labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelThanks.setBounds(300, 300, 400, 100);
	                            windowContinue.add(labelThanks);
	                            
	                            
	                            
	                            //HOME BUTTON
	                            JButton buttonHome = new JButton("HOME");
	                            buttonHome.setForeground(Color.BLACK);
	                            buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
	                            buttonHome.setBackground(Color.WHITE);
	                            buttonHome.setBounds(300, 550, 400, 100);
	                            buttonHome.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                	window.setVisible(true); //VISIBLE MAIN WINDOW
	                                	windowContinue.setVisible(false);
	                                   
	                                }
	                            });         
	                            windowContinue.add(buttonHome);
	                           
							} catch (NumberFormatException  | WrongPINException e1) {

			                   // System.out.println("The PIN must have 4 digits and Amount must have at least one number");
							}
                        	

                        }
                    });         
                    windowBuyCard.add(buttonContinue);
                    
                    
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
                    windowChargeCard.getContentPane().setLayout(null);
                    
                    //ID_NUMBER
                    JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
                    labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelIdNumber.setBounds(150, 180, 400, 100);
                    windowChargeCard.add(labelIdNumber);
                    
                    JTextField textIdNumber  = new JTextField();
                    textIdNumber .setFont(new Font("Consolas", Font.BOLD, 18));
                    textIdNumber .setBounds(300, 200, 400, 50);
                    windowChargeCard.add(textIdNumber );
                    
                    //PIN
                    JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
                    labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelPIN.setBounds(200, 280, 400, 100);
                    windowChargeCard.add(labelPIN);
                    
                    JPasswordField textPIN = new JPasswordField();
                    textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
                    textPIN.setBounds(300, 300, 400, 50);
                    windowChargeCard.add(textPIN);
                    
                    //AMOUNT
                    JLabel labelAmount = new JLabel("AMOUNT:", JLabel.LEFT);
                    labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelAmount.setBounds(200, 380, 400, 100);
                    windowChargeCard.add(labelAmount);
                    
                    JTextField textAmount = new JTextField();
                    textAmount.setFont(new Font("Consolas", Font.BOLD, 18));
                    textAmount.setBounds(300, 400, 400, 50);
                    windowChargeCard.add(textAmount);
                    
                    //WARNING
                    JLabel labelWarning = new JLabel("The PIN must have 4 digits and Amount must have at least one number");
                    labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning.setBounds(200, 700, 800, 50);
                    windowChargeCard.add(labelWarning);
                    
                    //CONTINUE BUTTON
                    JButton buttonContinue = new JButton("Continue");
                    buttonContinue.setForeground(Color.BLACK);
                    buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
                    buttonContinue.setBackground(Color.WHITE);
                    buttonContinue.setBounds(300, 550, 400, 100);
                    buttonContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	//ACCTION
                            try {
                            	//ChargeCard
                            	system.chargeCard(Long.parseLong(textIdNumber.getText()), String.valueOf(textPIN.getPassword()), Long.parseLong(textAmount.getText()));
                            	
                                Card card = system.getCards().get(Long.parseLong(textIdNumber.getText()));
                                long number= card.getId();
							    
							    //FILL IN THE NUMBER 
							    String cardNumber = Long.toString(number);
							    String nZeros= "";
							    for(int i=0; i<(4-cardNumber.length());i++) {
							       nZeros=nZeros+ "0";
							    }
							    cardNumber=nZeros+cardNumber;
							   
                                
	                        	windowChargeCard.setVisible(false); // NOT VISIBLE BUY CARD WINDOW
	                        	GraphicInterface windowContinue = new GraphicInterface();
	                        	windowContinue.setSize(1000,800); //SIZE OF WINDOW
	                			windowContinue.setLocation(450,125); //LOCATION
	                			windowContinue.setResizable(false); //NO MAXIMIZE
	                			windowContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
	                			windowContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
	                            windowContinue.setVisible(true); //VISIBLE
	                            windowContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            windowContinue.getContentPane().setLayout(null);
                               
	                        
	                            
	                            //TEXT   
	                            //Dear
	                            JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
	                            labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelDear.setBounds(300, 180, 400, 100);
	                            windowContinue.add(labelDear);
	                            //Amount
	                            JLabel labelAmount = new JLabel("Amount: "+ textAmount.getText(), JLabel.CENTER);
	                            labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelAmount.setBounds(300, 220, 400, 100);
	                            windowContinue.add(labelAmount);
	                            //CardNumber
	                            JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX "+ cardNumber, JLabel.CENTER);
	                            labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelCardNumber.setBounds(300, 260, 400, 100);
	                            windowContinue.add(labelCardNumber);
                                //Balance
	                            JLabel labelBalance = new JLabel("Balance: "+ card.getBalance(), JLabel.CENTER);
	                            labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelBalance.setBounds(300, 300, 400, 100);
	                            windowContinue.add(labelBalance);
	                            //Thanks for using...
	                            JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
	                            labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelThanks.setBounds(300, 340, 400, 100);
	                            windowContinue.add(labelThanks);
	                            
	                            
	                            
	                            //HOME BUTTON
	                            JButton buttonHome = new JButton("HOME");
	                            buttonHome.setForeground(Color.BLACK);
	                            buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
	                            buttonHome.setBackground(Color.WHITE);
	                            buttonHome.setBounds(300, 550, 400, 100);
	                            buttonHome.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                	window.setVisible(true); //VISIBLE MAIN WINDOW
	                                	windowContinue.setVisible(false);
	                                   
	                                }
	                            });         
	                            windowContinue.add(buttonHome);
	                           
							} catch (NumberFormatException  | WrongPINException | CardDoesntExistException | ExpiredCardException e1) {

			                   // System.out.println("The PIN must have 4 digits and Amount must have at least one number");
							}

                        }
                    });         
                    windowChargeCard.add(buttonContinue);
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
                    windowPayCard.getContentPane().setLayout(null);
                    
                    //ID_NUMBER
                    JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
                    labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelIdNumber.setBounds(150, 180, 400, 100);
                    windowPayCard.add(labelIdNumber);
                    
                    JTextField textIdNumber  = new JTextField();
                    textIdNumber .setFont(new Font("Consolas", Font.BOLD, 18));
                    textIdNumber .setBounds(300, 200, 400, 50);
                    windowPayCard.add(textIdNumber );
                    
                    //PIN
                    JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
                    labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelPIN.setBounds(200, 280, 400, 100);
                    windowPayCard.add(labelPIN);
                    
                    JPasswordField textPIN = new JPasswordField();
                    textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
                    textPIN.setBounds(300, 300, 400, 50);
                    windowPayCard.add(textPIN);
                    
                    //AMOUNT
                    JLabel labelAmount = new JLabel("AMOUNT:", JLabel.LEFT);
                    labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelAmount.setBounds(200, 380, 400, 100);
                    windowPayCard.add(labelAmount);
                    
                    JTextField textAmount = new JTextField();
                    textAmount.setFont(new Font("Consolas", Font.BOLD, 18));
                    textAmount.setBounds(300, 400, 400, 50);
                    windowPayCard.add(textAmount);
                    
                    //WARNING
                    JLabel labelWarning = new JLabel("The PIN must have 4 digits and Amount must have at least one number");
                    labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning.setBounds(200, 690, 800, 50);
                    windowPayCard.add(labelWarning);
                    JLabel labelWarning2 = new JLabel("The amount cannot be higher than the balance");
                    labelWarning2.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning2.setBounds(300, 720, 800, 50);
                    windowPayCard.add(labelWarning2);
                    
                    //CONTINUE BUTTON
                    JButton buttonContinue = new JButton("Continue");
                    buttonContinue.setForeground(Color.BLACK);
                    buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
                    buttonContinue.setBackground(Color.WHITE);
                    buttonContinue.setBounds(300, 550, 400, 100);
                    buttonContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	//ACCTION
                            try {
                            	//PayCard
                            	system.payCard(Long.parseLong(textIdNumber.getText()), String.valueOf(textPIN.getPassword()), Long.parseLong(textAmount.getText()));
                            	
                                Card card = system.getCards().get(Long.parseLong(textIdNumber.getText()));
                                long number= card.getId();
							    
							    //FILL IN THE NUMBER 
							    String cardNumber = Long.toString(number);
							    String nZeros= "";
							    for(int i=0; i<(4-cardNumber.length());i++) {
							       nZeros=nZeros+ "0";
							    }
							    cardNumber=nZeros+cardNumber;
							   
                                
	                        	windowPayCard.setVisible(false); // NOT VISIBLE BUY CARD WINDOW
	                        	GraphicInterface windowContinue = new GraphicInterface();
	                        	windowContinue.setSize(1000,800); //SIZE OF WINDOW
	                			windowContinue.setLocation(450,125); //LOCATION
	                			windowContinue.setResizable(false); //NO MAXIMIZE
	                			windowContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
	                			windowContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
	                            windowContinue.setVisible(true); //VISIBLE
	                            windowContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            windowContinue.getContentPane().setLayout(null);
                               
	                        
	                            
	                            //TEXT   
	                            //Dear
	                            JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
	                            labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelDear.setBounds(300, 180, 400, 100);
	                            windowContinue.add(labelDear);
	                            //Amount
	                            JLabel labelAmount = new JLabel("Amount: "+ textAmount.getText(), JLabel.CENTER);
	                            labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelAmount.setBounds(300, 220, 400, 100);
	                            windowContinue.add(labelAmount);
	                            //CardNumber
	                            JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX "+ cardNumber, JLabel.CENTER);
	                            labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelCardNumber.setBounds(300, 260, 400, 100);
	                            windowContinue.add(labelCardNumber);
                                //Balance
	                            JLabel labelBalance = new JLabel("Balance: "+ card.getBalance(), JLabel.CENTER);
	                            labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelBalance.setBounds(300, 300, 400, 100);
	                            windowContinue.add(labelBalance);
	                            //Thanks for using...
	                            JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
	                            labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelThanks.setBounds(300, 340, 400, 100);
	                            windowContinue.add(labelThanks);
	                            
	                            
	                            
	                            //HOME BUTTON
	                            JButton buttonHome = new JButton("HOME");
	                            buttonHome.setForeground(Color.BLACK);
	                            buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
	                            buttonHome.setBackground(Color.WHITE);
	                            buttonHome.setBounds(300, 550, 400, 100);
	                            buttonHome.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                	window.setVisible(true); //VISIBLE MAIN WINDOW
	                                	windowContinue.setVisible(false);
	                                   
	                                }
	                            });         
	                            windowContinue.add(buttonHome);
	                           
							} catch (NumberFormatException  | WrongPINException | CardDoesntExistException | ExpiredCardException | NotEnoughMoneyException e1) {

			                   // System.out.println("The PIN must have 4 digits and Amount must have at least one number");
							}

                        }
                    });         
                    windowPayCard.add(buttonContinue);      
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
                    windowChangePin.getContentPane().setLayout(null);
                    
                    //ID_NUMBER
                    JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
                    labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelIdNumber.setBounds(150, 180, 400, 100);
                    windowChangePin.add(labelIdNumber);
                    
                    JTextField textIdNumber  = new JTextField();
                    textIdNumber .setFont(new Font("Consolas", Font.BOLD, 18));
                    textIdNumber .setBounds(300, 200, 400, 50);
                    windowChangePin.add(textIdNumber );
                    
                    //OLD PIN
                    JLabel labelPIN = new JLabel("OLD PIN:", JLabel.LEFT);
                    labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelPIN.setBounds(200, 280, 400, 100);
                    windowChangePin.add(labelPIN);
                    
                    JPasswordField textPIN = new JPasswordField();
                    textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
                    textPIN.setBounds(300, 300, 400, 50);
                    windowChangePin.add(textPIN);
                    
                    //NEW PIN
                    JLabel labelNewPIN = new JLabel("NEW PIN:", JLabel.LEFT);
                    labelNewPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelNewPIN.setBounds(200, 380, 400, 100);
                    windowChangePin.add(labelNewPIN);
                    
                    JPasswordField textNewPIN = new JPasswordField();
                    textNewPIN.setFont(new Font("Consolas", Font.BOLD, 18));
                    textNewPIN.setBounds(300, 400, 400, 50);
                    windowChangePin.add(textNewPIN);
                    
                    //WARNING
                    JLabel labelWarning = new JLabel("The PIN must have 4 digits");
                    labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning.setBounds(380, 700, 800, 50);
                    windowChangePin.add(labelWarning);
                    
                  //CONTINUE BUTTON
                    JButton buttonContinue = new JButton("Continue");
                    buttonContinue.setForeground(Color.BLACK);
                    buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
                    buttonContinue.setBackground(Color.WHITE);
                    buttonContinue.setBounds(300, 550, 400, 100);
                    buttonContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	//ACCTION
                            try {
                            	//ChangePin
                            	system.changePin(Long.parseLong(textIdNumber.getText()), String.valueOf(textPIN.getPassword()), textNewPIN.getText());
                            	
                                Card card = system.getCards().get(Long.parseLong(textIdNumber.getText()));
                                long number= card.getId();
							    
							    //FILL IN THE NUMBER 
							    String cardNumber = Long.toString(number);
							    String nZeros= "";
							    for(int i=0; i<(4-cardNumber.length());i++) {
							       nZeros=nZeros+ "0";
							    }
							    cardNumber=nZeros+cardNumber;
							   
                                
	                        	windowChangePin.setVisible(false); // NOT VISIBLE BUY CARD WINDOW
	                        	GraphicInterface windowContinue = new GraphicInterface();
	                        	windowContinue.setSize(1000,800); //SIZE OF WINDOW
	                			windowContinue.setLocation(450,125); //LOCATION
	                			windowContinue.setResizable(false); //NO MAXIMIZE
	                			windowContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
	                			windowContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
	                            windowContinue.setVisible(true); //VISIBLE
	                            windowContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            windowContinue.getContentPane().setLayout(null);
                               
	                        
	                            
	                            //TEXT 
	                            //Thanks for using...
	                            JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
	                            labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelThanks.setBounds(300, 340, 400, 100);
	                            windowContinue.add(labelThanks);
	                            
	                            
	                            
	                            //HOME BUTTON
	                            JButton buttonHome = new JButton("HOME");
	                            buttonHome.setForeground(Color.BLACK);
	                            buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
	                            buttonHome.setBackground(Color.WHITE);
	                            buttonHome.setBounds(300, 550, 400, 100);
	                            buttonHome.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                	window.setVisible(true); //VISIBLE MAIN WINDOW
	                                	windowContinue.setVisible(false);
	                                   
	                                }
	                            });         
	                            windowContinue.add(buttonHome);
	                           
							} catch (NumberFormatException  | WrongPINException | CardDoesntExistException  e1) {

			                   // System.out.println("The PIN must have 4 digits and Amount must have at least one number");
							}

                        }
                    });         
                    windowChangePin.add(buttonContinue);      
  
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
                    windowConsultMovements.getContentPane().setLayout(null);
                    
                    //ID_NUMBER
                    JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
                    labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelIdNumber.setBounds(150, 180, 400, 100);
                    windowConsultMovements.add(labelIdNumber);
                    
                    JTextField textIdNumber  = new JTextField();
                    textIdNumber .setFont(new Font("Consolas", Font.BOLD, 18));
                    textIdNumber .setBounds(300, 200, 400, 50);
                    windowConsultMovements.add(textIdNumber );
                    
                    //PIN
                    JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
                    labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelPIN.setBounds(200, 280, 400, 100);
                    windowConsultMovements.add(labelPIN);
                    
                    JPasswordField textPIN = new JPasswordField();
                    textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
                    textPIN.setBounds(300, 300, 400, 50);
                    windowConsultMovements.add(textPIN);
                    
                    //WARNING
                    JLabel labelWarning = new JLabel("The PIN must have 4 digits");
                    labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning.setBounds(380, 700, 800, 50);
                    windowConsultMovements.add(labelWarning);
                    
                  //CONTINUE BUTTON
                    JButton buttonContinue = new JButton("Continue");
                    buttonContinue.setForeground(Color.BLACK);
                    buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
                    buttonContinue.setBackground(Color.WHITE);
                    buttonContinue.setBounds(300, 550, 400, 100);
                    buttonContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	//ACCTION
                            try {
                            	//ConsultMovements
                            	String movements = system.consultMovements(Long.parseLong(textIdNumber.getText()), String.valueOf(textPIN.getPassword()));
                            	
                                Card card = system.getCards().get(Long.parseLong(textIdNumber.getText()));
                                long number= card.getId();
							    
							    //FILL IN THE NUMBER 
							    String cardNumber = Long.toString(number);
							    String nZeros= "";
							    for(int i=0; i<(4-cardNumber.length());i++) {
							       nZeros=nZeros+ "0";
							    }
							    cardNumber=nZeros+cardNumber;
							   
                                
	                        	windowConsultMovements.setVisible(false); // NOT VISIBLE BUY CARD WINDOW
	                        	GraphicInterface windowContinue = new GraphicInterface();
	                        	windowContinue.setSize(1000,800); //SIZE OF WINDOW
	                			windowContinue.setLocation(450,125); //LOCATION
	                			windowContinue.setResizable(false); //NO MAXIMIZE
	                			windowContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
	                			windowContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
	                            windowContinue.setVisible(true); //VISIBLE
	                            windowContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            windowContinue.getContentPane().setLayout(null);
                               
	                        
	                            
	                            //TEXT   
	                            //Dear
	                            JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
	                            labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelDear.setBounds(300, 180, 400, 100);
	                            windowContinue.add(labelDear);
	                            //CardNumber
	                            JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX "+ cardNumber, JLabel.CENTER);
	                            labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelCardNumber.setBounds(300, 220, 400, 100);
	                            windowContinue.add(labelCardNumber);
                                //Movements
	                            JTextArea textMovements = new JTextArea("Movements: ");
	                            
	                            textMovements.setBackground(Color.WHITE);
	                            textMovements.setFont(new Font("Consolas", Font.BOLD, 20));
	                            textMovements.setEditable(false);
	                            JScrollPane scrollPaneMovements = new JScrollPane(textMovements);
	                            scrollPaneMovements.setEnabled(false);
	                            scrollPaneMovements.setBounds(300, 300, 430, 100);
	                            textMovements.setText(movements);
	                            windowContinue.getContentPane().add(scrollPaneMovements);
	                         
	                            //Thanks for using...
	                            JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
	                            labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelThanks.setBounds(300, 380, 400, 100);
	                            windowContinue.add(labelThanks);
	                            
	                            
	                            
	                            //HOME BUTTON
	                            JButton buttonHome = new JButton("HOME");
	                            buttonHome.setForeground(Color.BLACK);
	                            buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
	                            buttonHome.setBackground(Color.WHITE);
	                            buttonHome.setBounds(300, 550, 400, 100);
	                            buttonHome.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                	window.setVisible(true); //VISIBLE MAIN WINDOW
	                                	windowContinue.setVisible(false);
	                                   
	                                }
	                            });         
	                            windowContinue.add(buttonHome);
	                           
							} catch (NumberFormatException  | WrongPINException | CardDoesntExistException e1) {

			                   // System.out.println("The PIN must have 4 digits and Amount must have at least one number");
							}

                        }
                    });         
                    windowConsultMovements.add(buttonContinue);      
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
                    windowConsultBalance.getContentPane().setLayout(null);
                    
                    //ID_NUMBER
                    JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
                    labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelIdNumber.setBounds(150, 180, 400, 100);
                    windowConsultBalance.add(labelIdNumber);
                    
                    JTextField textIdNumber  = new JTextField();
                    textIdNumber .setFont(new Font("Consolas", Font.BOLD, 18));
                    textIdNumber .setBounds(300, 200, 400, 50);
                    windowConsultBalance.add(textIdNumber );
                    
                    //PIN
                    JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
                    labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
                    labelPIN.setBounds(200, 280, 400, 100);
                    windowConsultBalance.add(labelPIN);
                    
                    JPasswordField textPIN = new JPasswordField();
                    textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
                    textPIN.setBounds(300, 300, 400, 50);
                    windowConsultBalance.add(textPIN);
                    
                    //WARNING
                    JLabel labelWarning = new JLabel("The PIN must have 4 digits");
                    labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
                    labelWarning.setBounds(380, 700, 800, 50);
                    windowConsultBalance.add(labelWarning);

                    
                    //CONTINUE BUTTON
                    JButton buttonContinue = new JButton("Continue");
                    buttonContinue.setForeground(Color.BLACK);
                    buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
                    buttonContinue.setBackground(Color.WHITE);
                    buttonContinue.setBounds(300, 550, 400, 100);
                    buttonContinue.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	//ACCTION
                            try {
                            	//ConsultBalance
                            	system.consultBalance(Long.parseLong(textIdNumber.getText()), String.valueOf(textPIN.getPassword()));
                            	
                                Card card = system.getCards().get(Long.parseLong(textIdNumber.getText()));
                                long number= card.getId();
							    
							    //FILL IN THE NUMBER 
							    String cardNumber = Long.toString(number);
							    String nZeros= "";
							    for(int i=0; i<(4-cardNumber.length());i++) {
							       nZeros=nZeros+ "0";
							    }
							    cardNumber=nZeros+cardNumber;
							   
                                
	                        	windowConsultBalance.setVisible(false); // NOT VISIBLE BUY CARD WINDOW
	                        	GraphicInterface windowContinue = new GraphicInterface();
	                        	windowContinue.setSize(1000,800); //SIZE OF WINDOW
	                			windowContinue.setLocation(450,125); //LOCATION
	                			windowContinue.setResizable(false); //NO MAXIMIZE
	                			windowContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
	                			windowContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
	                            windowContinue.setVisible(true); //VISIBLE
	                            windowContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                            windowContinue.getContentPane().setLayout(null);
                               
	                        
	                            
	                            //TEXT   
	                            //Dear
	                            JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
	                            labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelDear.setBounds(300, 180, 400, 100);
	                            windowContinue.add(labelDear);
	                            //CardNumber
	                            JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX "+ cardNumber, JLabel.CENTER);
	                            labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelCardNumber.setBounds(300, 220, 400, 100);
	                            windowContinue.add(labelCardNumber);
                                //Balance
	                            JLabel labelBalance = new JLabel("Balance: "+ card.getBalance(), JLabel.CENTER);
	                            labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelBalance.setBounds(300, 260, 400, 100);
	                            windowContinue.add(labelBalance);
	                            //Thanks for using...
	                            JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
	                            labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
	                            labelThanks.setBounds(300, 300, 400, 100);
	                            windowContinue.add(labelThanks);
	                            
	                            
	                            
	                            //HOME BUTTON
	                            JButton buttonHome = new JButton("HOME");
	                            buttonHome.setForeground(Color.BLACK);
	                            buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
	                            buttonHome.setBackground(Color.WHITE);
	                            buttonHome.setBounds(300, 550, 400, 100);
	                            buttonHome.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                	window.setVisible(true); //VISIBLE MAIN WINDOW
	                                	windowContinue.setVisible(false);
	                                   
	                                }
	                            });         
	                            windowContinue.add(buttonHome);
	                           
							} catch (NumberFormatException  | WrongPINException | CardDoesntExistException e1) {

			                   // System.out.println("The PIN must have 4 digits and Amount must have at least one number");
							}

                        }
                    });         
                    windowConsultBalance.add(buttonContinue);      
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
 

	}
	
	
	
}
