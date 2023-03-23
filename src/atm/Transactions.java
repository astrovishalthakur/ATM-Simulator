package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit , fastCash , pinChange , cashWithdrawal , miniStatement , balanceEnquiry , exit ;
    String pinNumber ;

    public Transactions(String pinNumber){

        this.pinNumber = pinNumber ;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900 , 650);
        add(image) ;

        JLabel text = new JLabel("Please select your Transaction") ;
        text.setBounds(220 , 180 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text) ;

        deposit = new JButton("Deposit") ;
        deposit.setBounds(167 , 292 , 145 , 30);
        deposit.addActionListener(this);
        image.add(deposit) ;

        fastCash = new JButton("Fast Cash") ;
        fastCash.setBounds(167 , 327 , 145 , 30);
        fastCash.addActionListener(this);
        image.add(fastCash) ;

        pinChange = new JButton("Pin Change") ;
        pinChange.setBounds(167 , 362 , 145 , 30);
        pinChange.addActionListener(this);
        image.add(pinChange) ;

        cashWithdrawal = new JButton("Cash Withdrawal") ;
        cashWithdrawal.setBounds(365 , 292 , 145 , 30);
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal) ;

        miniStatement = new JButton("Mini Statement") ;
        miniStatement.setBounds(365 , 327 , 145 , 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement) ;

        balanceEnquiry = new JButton("Balance Enquiry") ;
        balanceEnquiry.setBounds(365 , 362 , 145 , 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry) ;

        exit = new JButton("Exit") ;
        exit.setBounds(365 , 397 , 145 , 27);
        exit.addActionListener(this);
        image.add(exit) ;


        setSize(900 , 700);
        setLocation(200 , 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == cashWithdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("") ;
    }
}
