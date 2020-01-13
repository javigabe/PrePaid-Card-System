package es.upm.pproject.prePaidCard.views;

import es.upm.pproject.prePaidCard.controllers.Controller;
import es.upm.pproject.prePaidCard.model.*;

import java.awt.*;
import javax.swing.*;

public class FrameManager extends JFrame {

    private Controller controller;

    private JTextField cardNumber;
    private JPasswordField textPIN;
    private JPasswordField textNewPIN;
    private JTextField textOwner;
    private JTextField textBalance;
    private JTextField chargeAmount;
    private JTextField payAmount;

    private FrameManager mainWindow;
    private FrameManager windowBuyCard;
    private FrameManager windowChargeCard;
    private FrameManager windowPayCard;
    private FrameManager windowChangePin;
    private FrameManager windowConsultMovements;
    private FrameManager windowConsultBalance;


    public FrameManager(Controller controller) {
        this.controller = controller;
        createMainWindow();
    }

    public FrameManager() {
        // EMPTY CONSTRUCTOR
    }

    private void createMainWindow() {
        mainWindow = new FrameManager();

        mainWindow.setSize(1000,800); //SIZE OF WINDOW
        mainWindow.setLocation(450,125); //LOCATION
        mainWindow.setResizable(false); //NO MAXIMIZE
        mainWindow.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        mainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        mainWindow.getContentPane().setLayout(new GridLayout(3,2)); //new GridLayaout(3,2) or null
        mainWindow.setVisible(true); //VISIBLE
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BUTTON BUY CARD
        JButton buttonBuyCard = new JButton("BUY CARD");
        buttonBuyCard.setForeground(Color.BLACK);
        buttonBuyCard.setFont(new Font("Consolas", Font.BOLD, 28));
        buttonBuyCard.setBackground(Color.WHITE);
        buttonBuyCard.setBounds(300, 30, 400, 100);
        buttonBuyCard.addActionListener(event -> {
            mainWindow.setVisible(false);
            buyCardView();
        });
        mainWindow.add(buttonBuyCard);

        // BUTTON CHARGE CARD
        JButton buttonChargeCard = new JButton("CHARGE CARD");
        buttonChargeCard.setForeground(Color.BLACK);
        buttonChargeCard.setFont(new Font("Consolas", Font.BOLD, 28));
        buttonChargeCard.setBackground(Color.WHITE);
        buttonChargeCard.setBounds(300, 150, 400, 100);
        buttonChargeCard.addActionListener(event -> {
            mainWindow.setVisible(false);
            chargeCardView();
        });
        mainWindow.add(buttonChargeCard);

        // BUTTON PAY CARD
        JButton buttonPayCard = new JButton("PAY CARD");
        buttonPayCard.setForeground(Color.BLACK);
        buttonPayCard.setFont(new Font("Consolas", Font.BOLD, 28));
        buttonPayCard.setBackground(Color.WHITE);
        buttonPayCard.setBounds(300, 270, 400, 100);
        buttonPayCard.addActionListener(event -> {
            mainWindow.setVisible(false);
            payCardView();
        });
        mainWindow.add(buttonPayCard);

        // BUTTON CHANGE PIN
        JButton buttonChangePin = new JButton("CHANGE PIN");
        buttonChangePin.setForeground(Color.BLACK);
        buttonChangePin.setFont(new Font("Consolas", Font.BOLD, 28));
        buttonChangePin.setBackground(Color.WHITE);
        buttonChangePin.setBounds(300, 390, 400, 100);
        buttonChangePin.addActionListener(event -> {
            mainWindow.setVisible(false);
            changePinView();
        });
        mainWindow.add(buttonChangePin);

        //BUTTON CONSULT MOVEMENTS
        JButton buttonConsultMovements = new JButton("CONSULT MOVEMENTS");
        buttonConsultMovements.setForeground(Color.BLACK);
        buttonConsultMovements.setFont(new Font("Consolas", Font.BOLD, 28));
        buttonConsultMovements.setBackground(Color.WHITE);
        buttonConsultMovements.setBounds(300, 510, 400, 100);
        buttonConsultMovements.addActionListener(event -> {
            mainWindow.setVisible(false);
            consultMovementsView();
        });
        mainWindow.add(buttonConsultMovements);

        //BUTTON CONSULT BALANCE
        JButton buttonConsultBalance = new JButton("CONSULT BALANCE");
        buttonConsultBalance.setForeground(Color.BLACK);
        buttonConsultBalance.setFont(new Font("Consolas", Font.BOLD, 28));
        buttonConsultBalance.setBackground(Color.WHITE);
        buttonConsultBalance.setBounds(300, 630, 400, 100);
        buttonConsultBalance.addActionListener(event -> {
            mainWindow.setVisible(false);
            consultBalanceView();
        });
        mainWindow.add(buttonConsultBalance);
    }

    private void buyCardView() {
        windowBuyCard = new FrameManager();
        windowBuyCard.setSize(1000,800); //SIZE OF WINDOW
        windowBuyCard.setLocation(450,125); //LOCATION
        windowBuyCard.setResizable(false); //NO MAXIMIZE
        windowBuyCard.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowBuyCard.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowBuyCard.setVisible(true); //VISIBLE
        windowBuyCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowBuyCard.getContentPane().setLayout(null);

        // BACK BUTTON
        JButton back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setBackground(Color.WHITE);
        back.setBounds(10, 10, 90, 40);
        windowBuyCard.add(back);
        back.addActionListener(event -> {
            windowBuyCard.setVisible(false);
            mainWindow.setVisible(true);
        });

        //OWNER
        JLabel labelOwner = new JLabel("OWNER:", JLabel.LEFT);
        labelOwner.setFont(new Font("Consolas", Font.BOLD, 20));
        labelOwner.setBounds(200, 180, 400, 100);
        windowBuyCard.add(labelOwner);

        textOwner = new JTextField();
        textOwner.setFont(new Font("Consolas", Font.BOLD, 18));
        textOwner.setBounds(300, 200, 400, 50);
        windowBuyCard.add(textOwner);

        //PIN
        JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
        labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelPIN.setBounds(200, 280, 400, 100);
        windowBuyCard.add(labelPIN);

        textPIN = new JPasswordField(JLabel.LEFT);
        textPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        textPIN.setBounds(300, 300, 400, 50);
        windowBuyCard.add(textPIN);

        //BALANCE
        JLabel labelBalance = new JLabel("AMOUNT:", JLabel.LEFT);
        labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
        labelBalance.setBounds(200, 380, 400, 100);
        windowBuyCard.add(labelBalance);

        textBalance = new JTextField();
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
        windowBuyCard.add(buttonContinue);
        buttonContinue.addActionListener(event -> {
            buyCardContinue();
            windowBuyCard.setVisible(false);
        });
    }
    
    private void buyCardContinue() {
        // WINDOW SETTINGS
        FrameManager windowBuyCardContinue = new FrameManager();
        windowBuyCardContinue.setSize(1000,800); //SIZE OF WINDOW
        windowBuyCardContinue.setLocation(450,125); //LOCATION
        windowBuyCardContinue.setResizable(false); //NO MAXIMIZE
        windowBuyCardContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowBuyCardContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowBuyCardContinue.setVisible(true); //VISIBLE
        windowBuyCardContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowBuyCardContinue.getContentPane().setLayout(null);

        long number = 0;
        try {
            number = controller.buyCard(textOwner.getText(), Long.parseLong(textBalance.getText()), String.valueOf(textPIN.getPassword()));
        } catch (WrongPINException e) {
            JOptionPane.showMessageDialog(windowBuyCardContinue, "WRONG PIN");
            windowBuyCardContinue.setVisible(false);
            buyCardView();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(windowBuyCardContinue, "AN ERROR OCURRED");
            windowBuyCardContinue.setVisible(false);
            buyCardView();
            return;
        }

        //FILL IN THE NUMBER
        String cardNumberFormated = Long.toString(number);
        StringBuilder nZeros = new StringBuilder();
        for(int i=0; i<(12-cardNumberFormated.length());i++) {
            nZeros.append("0");
        }
        cardNumberFormated = nZeros.append(cardNumberFormated).toString();

        //Dear
        JLabel labelDear = new JLabel("Dear "+ textOwner.getText(), JLabel.CENTER);
        labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
        labelDear.setBounds(300, 180, 400, 100);
        windowBuyCardContinue.add(labelDear);

        //CardNumber
        JLabel labelCardNumber = new JLabel("Card Number: " + cardNumberFormated, JLabel.CENTER);
        labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelCardNumber.setBounds(300, 220, 400, 100);
        windowBuyCardContinue.add(labelCardNumber);

        //Balance
        JLabel labelBalance = new JLabel("Balance: "+ textBalance.getText(), JLabel.CENTER);
        labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
        labelBalance.setBounds(300, 260, 400, 100);
        windowBuyCardContinue.add(labelBalance);

        //Thanks for using...
        JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
        labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
        labelThanks.setBounds(300, 300, 400, 100);
        windowBuyCardContinue.add(labelThanks);

        //HOME BUTTON
        JButton buttonHome = new JButton("HOME");
        buttonHome.setForeground(Color.BLACK);
        buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonHome.setBackground(Color.WHITE);
        buttonHome.setBounds(300, 550, 400, 100);
        windowBuyCardContinue.add(buttonHome);
        buttonHome.addActionListener(event -> {
            mainWindow.setVisible(true);
            windowBuyCardContinue.setVisible(false);
        });
    }

    private void chargeCardView() {
        windowChargeCard = new FrameManager();
        windowChargeCard.setSize(1000,800); //SIZE OF WINDOW
        windowChargeCard.setLocation(450,125); //LOCATION
        windowChargeCard.setResizable(false); //NO MAXIMIZE
        windowChargeCard.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowChargeCard.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowChargeCard.setVisible(true); //VISIBLE
        windowChargeCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowChargeCard.getContentPane().setLayout(null);

        // BACK BUTTON
        JButton back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setBackground(Color.WHITE);
        back.setBounds(10, 10, 90, 40);
        windowChargeCard.add(back);
        back.addActionListener(event -> {
            windowChargeCard.setVisible(false);
            mainWindow.setVisible(true);
        });

        //ID_NUMBER
        JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
        labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelIdNumber.setBounds(150, 180, 400, 100);
        windowChargeCard.add(labelIdNumber);

        cardNumber = new JTextField();
        cardNumber.setFont(new Font("Consolas", Font.BOLD, 18));
        cardNumber.setBounds(300, 200, 400, 50);
        windowChargeCard.add(cardNumber);

        //PIN
        JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
        labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelPIN.setBounds(200, 280, 400, 100);
        windowChargeCard.add(labelPIN);

        textPIN = new JPasswordField();
        textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
        textPIN.setBounds(300, 300, 400, 50);
        windowChargeCard.add(textPIN);

        //AMOUNT
        JLabel labelAmount = new JLabel("AMOUNT:", JLabel.LEFT);
        labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
        labelAmount.setBounds(200, 380, 400, 100);
        windowChargeCard.add(labelAmount);

        chargeAmount = new JTextField();
        chargeAmount.setFont(new Font("Consolas", Font.BOLD, 18));
        chargeAmount.setBounds(300, 400, 400, 50);
        windowChargeCard.add(chargeAmount);

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
        windowChargeCard.add(buttonContinue);
        buttonContinue.addActionListener(event -> {
            windowChargeCard.setVisible(false);
            chargeContinue();
        });
    }

    private void chargeContinue() {
        FrameManager windowChargeContinue = new FrameManager();
        windowChargeContinue.setSize(1000,800); //SIZE OF WINDOW
        windowChargeContinue.setLocation(450,125); //LOCATION
        windowChargeContinue.setResizable(false); //NO MAXIMIZE
        windowChargeContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowChargeContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowChargeContinue.setVisible(true); //VISIBLE
        windowChargeContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowChargeContinue.getContentPane().setLayout(null);

        try {
            controller.chargeCard(Long.parseLong(cardNumber.getText()), String.valueOf(textPIN.getPassword()), Long.parseLong(chargeAmount.getText()));
        } catch (WrongPINException e) {
            JOptionPane.showMessageDialog(windowChargeContinue, "WRONG PIN");
            windowChargeContinue.setVisible(false);
            chargeCardView();
            return;
        } catch (CardDoesntExistException e) {
            JOptionPane.showMessageDialog(windowChargeContinue, "CARD DOESNT EXIST");
            windowChargeContinue.setVisible(false);
            chargeCardView();
            return;
        } catch (ExpiredCardException e) {
            JOptionPane.showMessageDialog(windowChargeContinue, "EXPIRED CARD");
            windowChargeContinue.setVisible(false);
            chargeCardView();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(windowChargeContinue, "AN ERROR OCURRED");
            windowChargeContinue.setVisible(false);
            chargeCardView();
            return;
        }

        Card card = controller.getCards().get(Long.parseLong(cardNumber.getText()));

        //FILL IN THE NUMBER
        String cardNumberFormated = getCardNumberFormated(card);

        //Dear
        JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
        labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
        labelDear.setBounds(300, 180, 400, 100);
        windowChargeContinue.add(labelDear);

        //Amount
        JLabel labelAmount = new JLabel("Amount: "+ chargeAmount.getText(), JLabel.CENTER);
        labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
        labelAmount.setBounds(300, 220, 400, 100);
        windowChargeContinue.add(labelAmount);

        //CardNumber
        JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX " + cardNumberFormated, JLabel.CENTER);
        labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelCardNumber.setBounds(300, 260, 400, 100);
        windowChargeContinue.add(labelCardNumber);

        //Balance
        JLabel labelBalance = new JLabel("Balance: "+ card.getBalance(), JLabel.CENTER);
        labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
        labelBalance.setBounds(300, 300, 400, 100);
        windowChargeContinue.add(labelBalance);

        //Thanks for using...
        JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
        labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
        labelThanks.setBounds(300, 340, 400, 100);
        windowChargeContinue.add(labelThanks);

        //HOME BUTTON
        JButton buttonHome = new JButton("HOME");
        buttonHome.setForeground(Color.BLACK);
        buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonHome.setBackground(Color.WHITE);
        buttonHome.setBounds(300, 550, 400, 100);
        windowChargeContinue.add(buttonHome);
        buttonHome.addActionListener(event -> {
            windowChargeContinue.setVisible(false);
            mainWindow.setVisible(true);
        });
    }

    private void payCardView() {
        windowPayCard = new FrameManager();
        windowPayCard.setSize(1000,800); //SIZE OF WINDOW
        windowPayCard.setLocation(450,125); //LOCATION
        windowPayCard.setResizable(false); //NO MAXIMIZE
        windowPayCard.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowPayCard.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowPayCard.setVisible(true); //VISIBLE
        windowPayCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPayCard.getContentPane().setLayout(null);

        // BACK BUTTON
        JButton back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setBackground(Color.WHITE);
        back.setBounds(10, 10, 90, 40);
        windowPayCard.add(back);
        back.addActionListener(event -> {
            windowPayCard.setVisible(false);
            mainWindow.setVisible(true);
        });

        //ID_NUMBER
        JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
        labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelIdNumber.setBounds(150, 180, 400, 100);
        windowPayCard.add(labelIdNumber);

        cardNumber = new JTextField();
        cardNumber.setFont(new Font("Consolas", Font.BOLD, 18));
        cardNumber.setBounds(300, 200, 400, 50);
        windowPayCard.add(cardNumber);

        //PIN
        JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
        labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelPIN.setBounds(200, 280, 400, 100);
        windowPayCard.add(labelPIN);

        textPIN = new JPasswordField();
        textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
        textPIN.setBounds(300, 300, 400, 50);
        windowPayCard.add(textPIN);

        //AMOUNT
        JLabel labelAmount = new JLabel("AMOUNT:", JLabel.LEFT);
        labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
        labelAmount.setBounds(200, 380, 400, 100);
        windowPayCard.add(labelAmount);

        payAmount = new JTextField();
        payAmount.setFont(new Font("Consolas", Font.BOLD, 18));
        payAmount.setBounds(300, 400, 400, 50);
        windowPayCard.add(payAmount);

        //WARNING
        JLabel labelWarning = new JLabel("The PIN must have 4 digits and Amount must have at least one number");
        labelWarning.setFont(new Font("Consolas", Font.BOLD, 16));
        labelWarning.setBounds(200, 690, 800, 50);
        windowPayCard.add(labelWarning);

        //CONTINUE BUTTON
        JButton buttonContinue = new JButton("Continue");
        buttonContinue.setForeground(Color.BLACK);
        buttonContinue.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonContinue.setBackground(Color.WHITE);
        buttonContinue.setBounds(300, 550, 400, 100);
        windowPayCard.add(buttonContinue);
        buttonContinue.addActionListener(event -> {
            windowPayCard.setVisible(false);
            payCardContinue();
        });
    }

    private void payCardContinue() {
        FrameManager windowPayContinue = new FrameManager();
        windowPayContinue.setSize(1000,800); //SIZE OF WINDOW
        windowPayContinue.setLocation(450,125); //LOCATION
        windowPayContinue.setResizable(false); //NO MAXIMIZE
        windowPayContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowPayContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowPayContinue.setVisible(true); //VISIBLE
        windowPayContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPayContinue.getContentPane().setLayout(null);

        try {
            controller.payCard(Long.parseLong(cardNumber.getText()), String.valueOf(textPIN.getPassword()), Long.parseLong(payAmount.getText()));
        } catch(WrongPINException e) {
            JOptionPane.showMessageDialog(windowPayContinue, "WRONG PIN");
            windowPayContinue.setVisible(false);
            payCardView();
            return;
        } catch (ExpiredCardException a) {
            JOptionPane.showMessageDialog(windowPayContinue, "EXPIRED CARD");
            windowPayContinue.setVisible(false);
            payCardView();
            return;
        } catch (CardDoesntExistException b) {
            JOptionPane.showMessageDialog(windowPayContinue, "CARD DOESNT EXIST");
            windowPayContinue.setVisible(false);
            payCardView();
            return;
        } catch (NotEnoughMoneyException c) {
            JOptionPane.showMessageDialog(windowPayContinue, "YOU DON'T HAVE ENOUGH MONEY");
            windowPayContinue.setVisible(false);
            payCardView();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(windowPayContinue, "AN ERROR OCURRED");
            windowPayContinue.setVisible(false);
            payCardView();
            return;
        }

        Card card = controller.getCards().get(Long.parseLong(cardNumber.getText()));

        //FILL IN THE NUMBER
        String cardNumberFormated = getCardNumberFormated(card);

        //Dear
        JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
        labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
        labelDear.setBounds(300, 180, 400, 100);
        windowPayContinue.add(labelDear);

        //Amount
        JLabel labelAmount = new JLabel("Amount: "+ payAmount.getText(), JLabel.CENTER);
        labelAmount.setFont(new Font("Consolas", Font.BOLD, 20));
        labelAmount.setBounds(300, 220, 400, 100);
        windowPayContinue.add(labelAmount);

        //CardNumber
        JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX " + cardNumberFormated, JLabel.CENTER);
        labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelCardNumber.setBounds(300, 260, 400, 100);
        windowPayContinue.add(labelCardNumber);

        //Balance
        JLabel labelBalance = new JLabel("Balance: "+ card.getBalance(), JLabel.CENTER);
        labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
        labelBalance.setBounds(300, 300, 400, 100);
        windowPayContinue.add(labelBalance);

        //Thanks for using...
        JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
        labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
        labelThanks.setBounds(300, 340, 400, 100);
        windowPayContinue.add(labelThanks);

        //HOME BUTTON
        JButton buttonHome = new JButton("HOME");
        buttonHome.setForeground(Color.BLACK);
        buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonHome.setBackground(Color.WHITE);
        buttonHome.setBounds(300, 550, 400, 100);
        windowPayContinue.add(buttonHome);
        buttonHome.addActionListener(event -> {
            windowPayContinue.setVisible(false);
            mainWindow.setVisible(true);
        });
    }

    private void changePinView() {
        windowChangePin = new FrameManager();
        windowChangePin.setSize(1000,800); //SIZE OF WINDOW
        windowChangePin.setLocation(450,125); //LOCATION
        windowChangePin.setResizable(false); //NO MAXIMIZE
        windowChangePin.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowChangePin.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowChangePin.setVisible(true); //VISIBLE
        windowChangePin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowChangePin.getContentPane().setLayout(null);

        // BACK BUTTON
        JButton back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setBackground(Color.WHITE);
        back.setBounds(10, 10, 90, 40);
        windowChangePin.add(back);
        back.addActionListener(event -> {
            windowChangePin.setVisible(false);
            mainWindow.setVisible(true);
        });

        //ID_NUMBER
        JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
        labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelIdNumber.setBounds(150, 180, 400, 100);
        windowChangePin.add(labelIdNumber);

        cardNumber = new JTextField();
        cardNumber.setFont(new Font("Consolas", Font.BOLD, 18));
        cardNumber.setBounds(300, 200, 400, 50);
        windowChangePin.add(cardNumber);

        //OLD PIN
        JLabel labelPIN = new JLabel("OLD PIN:", JLabel.LEFT);
        labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelPIN.setBounds(200, 280, 400, 100);
        windowChangePin.add(labelPIN);

        textPIN = new JPasswordField();
        textPIN.setFont(new Font("Consolas", Font.BOLD, 18));
        textPIN.setBounds(300, 300, 400, 50);
        windowChangePin.add(textPIN);

        //NEW PIN
        JLabel labelNewPIN = new JLabel("NEW PIN:", JLabel.LEFT);
        labelNewPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelNewPIN.setBounds(200, 380, 400, 100);
        windowChangePin.add(labelNewPIN);

        textNewPIN = new JPasswordField();
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
        windowChangePin.add(buttonContinue);
        buttonContinue.addActionListener(event -> {
            windowChangePin.setVisible(false);
            changePinContinue();
        });
    }

    private void changePinContinue() {
        FrameManager windowPinContinue = new FrameManager();
        windowPinContinue.setSize(1000,800); //SIZE OF WINDOW
        windowPinContinue.setLocation(450,125); //LOCATION
        windowPinContinue.setResizable(false); //NO MAXIMIZE
        windowPinContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowPinContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowPinContinue.setVisible(true); //VISIBLE
        windowPinContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPinContinue.getContentPane().setLayout(null);

        try {
            controller.changePin(Long.parseLong(cardNumber.getText()), String.valueOf(textPIN.getPassword()), String.valueOf(textNewPIN.getPassword()));
        } catch (CardDoesntExistException e) {
            JOptionPane.showMessageDialog(windowPinContinue, "CARD DOESN'T EXIST");
            windowPinContinue.setVisible(false);
            changePinView();
            return;
        } catch (WrongPINException e) {
            JOptionPane.showMessageDialog(windowPinContinue, "WRONG PIN");
            windowPinContinue.setVisible(false);
            changePinView();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(windowPinContinue, "AN ERROR OCURRED");
            windowPinContinue.setVisible(false);
            changePinView();
            return;
        }

        //Thanks for using...
        JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
        labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
        labelThanks.setBounds(300, 340, 400, 100);
        windowPinContinue.add(labelThanks);

        //HOME BUTTON
        JButton buttonHome = new JButton("HOME");
        buttonHome.setForeground(Color.BLACK);
        buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonHome.setBackground(Color.WHITE);
        buttonHome.setBounds(300, 550, 400, 100);
        windowPinContinue.add(buttonHome);
        buttonHome.addActionListener(event -> {
            windowPinContinue.setVisible(false);
            mainWindow.setVisible(true);
        });

    }

    private void consultMovementsView() {
        windowConsultMovements = new FrameManager();
        windowConsultMovements.setSize(1000,800); //SIZE OF WINDOW
        windowConsultMovements.setLocation(450,125); //LOCATION
        windowConsultMovements.setResizable(false); //NO MAXIMIZE
        windowConsultMovements.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowConsultMovements.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowConsultMovements.setVisible(true); //VISIBLE
        windowConsultMovements.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowConsultMovements.getContentPane().setLayout(null);

        // BACK BUTTON
        JButton back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setBackground(Color.WHITE);
        back.setBounds(10, 10, 90, 40);
        windowConsultMovements.add(back);
        back.addActionListener(event -> {
            windowConsultMovements.setVisible(false);
            mainWindow.setVisible(true);
        });

        //ID_NUMBER
        JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
        labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelIdNumber.setBounds(150, 180, 400, 100);
        windowConsultMovements.add(labelIdNumber);

        cardNumber  = new JTextField();
        cardNumber.setFont(new Font("Consolas", Font.BOLD, 18));
        cardNumber.setBounds(300, 200, 400, 50);
        windowConsultMovements.add(cardNumber);

        //PIN
        JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
        labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelPIN.setBounds(200, 280, 400, 100);
        windowConsultMovements.add(labelPIN);

        textPIN = new JPasswordField();
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
        windowConsultMovements.add(buttonContinue);
        buttonContinue.addActionListener(event -> {
            windowConsultMovements.setVisible(false);
            consultMovemetsContinue();
        });
    }

    private void consultMovemetsContinue() {
        FrameManager windowMovementsContinue = new FrameManager();
        windowMovementsContinue.setSize(1000,800); //SIZE OF WINDOW
        windowMovementsContinue.setLocation(450,125); //LOCATION
        windowMovementsContinue.setResizable(false); //NO MAXIMIZE
        windowMovementsContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowMovementsContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowMovementsContinue.setVisible(true); //VISIBLE
        windowMovementsContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowMovementsContinue.getContentPane().setLayout(null);

        String movements = null;
        try {
            movements = controller.consultMovements(Long.parseLong(cardNumber.getText()), String.valueOf(textPIN.getPassword()));
        } catch (CardDoesntExistException e) {
            JOptionPane.showMessageDialog(windowMovementsContinue, "CARD DOESN'T EXIST");
            windowMovementsContinue.setVisible(false);
            consultMovementsView();
            return;
        } catch (WrongPINException e) {
            JOptionPane.showMessageDialog(windowMovementsContinue, "WRONG PIN");
            windowMovementsContinue.setVisible(false);
            consultMovementsView();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(windowMovementsContinue, "AN ERROR OCURRED");
            windowMovementsContinue.setVisible(false);
            consultMovementsView();
            return;
        }

        Card card = controller.getCards().get(Long.parseLong(cardNumber.getText()));

        //FILL IN THE NUMBER
        String cardNumberFormated = getCardNumberFormated(card);

        //Dear
        JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
        labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
        labelDear.setBounds(300, 180, 400, 100);
        windowMovementsContinue.add(labelDear);

        //CardNumber
        JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX "+ cardNumberFormated, JLabel.CENTER);
        labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelCardNumber.setBounds(300, 220, 400, 100);
        windowMovementsContinue.add(labelCardNumber);

        //Movements
        JTextArea textMovements = new JTextArea("Movements: ");
        textMovements.setBackground(Color.WHITE);
        textMovements.setFont(new Font("Consolas", Font.BOLD, 20));
        textMovements.setEditable(false);
        JScrollPane scrollPaneMovements = new JScrollPane(textMovements);
        scrollPaneMovements.setEnabled(false);
        scrollPaneMovements.setBounds(300, 300, 430, 100);
        textMovements.setText(movements);
        windowMovementsContinue.getContentPane().add(scrollPaneMovements);

        //Thanks for using...
        JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
        labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
        labelThanks.setBounds(300, 380, 400, 100);
        windowMovementsContinue.add(labelThanks);

        //HOME BUTTON
        JButton buttonHome = new JButton("HOME");
        buttonHome.setForeground(Color.BLACK);
        buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonHome.setBackground(Color.WHITE);
        buttonHome.setBounds(300, 550, 400, 100);
        windowMovementsContinue.add(buttonHome);
        buttonHome.addActionListener(event -> {
            windowMovementsContinue.setVisible(false);
            mainWindow.setVisible(true);
        });
    }

    private void consultBalanceView() {
        windowConsultBalance = new FrameManager();
        windowConsultBalance.setSize(1000,800); //SIZE OF WINDOW
        windowConsultBalance.setLocation(450,125); //LOCATION
        windowConsultBalance.setResizable(false); //NO MAXIMIZE
        windowConsultBalance.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowConsultBalance.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowConsultBalance.setVisible(true); //VISIBLE
        windowConsultBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowConsultBalance.getContentPane().setLayout(null);

        // BACK BUTTON
        JButton back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Consolas", Font.BOLD, 20));
        back.setBackground(Color.WHITE);
        back.setBounds(10, 10, 90, 40);
        windowConsultBalance.add(back);
        back.addActionListener(event -> {
            windowConsultBalance.setVisible(false);
            mainWindow.setVisible(true);
        });

        //ID_NUMBER
        JLabel labelIdNumber = new JLabel("CARD NUMBER:", JLabel.LEFT);
        labelIdNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelIdNumber.setBounds(150, 180, 400, 100);
        windowConsultBalance.add(labelIdNumber);

        cardNumber = new JTextField();
        cardNumber.setFont(new Font("Consolas", Font.BOLD, 18));
        cardNumber.setBounds(300, 200, 400, 50);
        windowConsultBalance.add(cardNumber);

        //PIN
        JLabel labelPIN = new JLabel("PIN:", JLabel.LEFT);
        labelPIN.setFont(new Font("Consolas", Font.BOLD, 20));
        labelPIN.setBounds(200, 280, 400, 100);
        windowConsultBalance.add(labelPIN);

        textPIN = new JPasswordField();
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
        windowConsultBalance.add(buttonContinue);
        buttonContinue.addActionListener(event -> {
            windowConsultBalance.setVisible(false);
            consultBalanceContinue();
        });
    }

    private void consultBalanceContinue() {
        FrameManager windowBalanceContinue = new FrameManager();
        windowBalanceContinue.setSize(1000,800); //SIZE OF WINDOW
        windowBalanceContinue.setLocation(450,125); //LOCATION
        windowBalanceContinue.setResizable(false); //NO MAXIMIZE
        windowBalanceContinue.setTitle("Pre-PaidCardSystem"); //NAME OF WINDOW
        windowBalanceContinue.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png")); //ICON OF WINDOW
        windowBalanceContinue.setVisible(true); //VISIBLE
        windowBalanceContinue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowBalanceContinue.getContentPane().setLayout(null);

        long balance = 0;
        try {
            balance = controller.consultBalance(Long.parseLong(cardNumber.getText()), String.valueOf(textPIN.getPassword()));
        } catch (CardDoesntExistException e) {
            JOptionPane.showMessageDialog(windowBalanceContinue, "CARD DOESN'T EXIST");
            windowBalanceContinue.setVisible(false);
            consultBalanceView();
            return;
        } catch (WrongPINException e) {
            JOptionPane.showMessageDialog(windowBalanceContinue, "WRONG PIN");
            windowBalanceContinue.setVisible(false);
            consultBalanceView();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(windowBalanceContinue, "AN ERROR OCURRED");
            windowBalanceContinue.setVisible(false);
            consultBalanceView();
            return;
        }

        Card card = controller.getCards().get(Long.parseLong(cardNumber.getText()));

        //FILL IN THE NUMBER
        String cardNumberFormated = getCardNumberFormated(card);

        //Dear
        JLabel labelDear = new JLabel("Dear "+ card.getOwner() , JLabel.CENTER);
        labelDear.setFont(new Font("Consolas", Font.BOLD, 20));
        labelDear.setBounds(300, 180, 400, 100);
        windowBalanceContinue.add(labelDear);

        //CardNumber
        JLabel labelCardNumber = new JLabel("Card Number: XXXX XXXX " + cardNumberFormated, JLabel.CENTER);
        labelCardNumber.setFont(new Font("Consolas", Font.BOLD, 20));
        labelCardNumber.setBounds(300, 220, 400, 100);
        windowBalanceContinue.add(labelCardNumber);

        //Balance
        JLabel labelBalance = new JLabel("Balance: " + balance, JLabel.CENTER);
        labelBalance.setFont(new Font("Consolas", Font.BOLD, 20));
        labelBalance.setBounds(300, 260, 400, 100);
        windowBalanceContinue.add(labelBalance);

        //Thanks for using...
        JLabel labelThanks= new JLabel("Thanks for using our system", JLabel.CENTER);
        labelThanks.setFont(new Font("Consolas", Font.BOLD, 20));
        labelThanks.setBounds(300, 300, 400, 100);
        windowBalanceContinue.add(labelThanks);

        //HOME BUTTON
        JButton buttonHome = new JButton("HOME");
        buttonHome.setForeground(Color.BLACK);
        buttonHome.setFont(new Font("Consolas", Font.BOLD, 20));
        buttonHome.setBackground(Color.WHITE);
        buttonHome.setBounds(300, 550, 400, 100);
        windowBalanceContinue.add(buttonHome);
        buttonHome.addActionListener(event -> {
            windowBalanceContinue.setVisible(false);
            mainWindow.setVisible(true);
        });
    }

    // METHOD THAT RETURN THE LAST 4 DIGITS OF A CARD
    private String getCardNumberFormated(Card card) {
        long number = card.getId();

        StringBuilder cardNum = new StringBuilder();
        //FILL IN THE NUMBER
        String cardNumberFormated = Long.toString(number);

        int isFormateable = cardNumberFormated.length() - 4;

        if (isFormateable > 0) {
            for(int i = isFormateable; i < cardNumberFormated.length();i++) {
                cardNum.append(cardNumberFormated.charAt(i));
            }
            return cardNum.toString();
        }

        else {
            for (int i = 0; i < 4 - cardNumberFormated.length(); i++) {
                cardNum.append("0");
            }
            return cardNum.append(cardNumberFormated).toString();
        }
    }
}

