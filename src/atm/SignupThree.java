package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton saving , current , fd , rd ;
    JCheckBox atmCard , mobileBanking , chequeBook , internetBanking , emailSmsAlerts , eStatement , last ;
    JButton submit , cancel ;
    String formno ;

    public SignupThree(String formno){

        this.formno = formno ;

        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details") ;
        l1.setFont(new Font("Raleway" , Font.BOLD , 23));
        l1.setBounds(225 , 20 , 500 , 40);
        add(l1) ;

        JLabel l2 = new JLabel("Account Type : ") ;
        l2.setFont(new Font("Raleway" , Font.BOLD , 18));
        l2.setBounds(65 , 85 , 200 , 25);
        add(l2) ;
        saving = new JRadioButton("Saving Account") ;
        saving.setBounds(235 , 85 , 175 , 25);
        saving.setFont(new Font("Raleway" , Font.BOLD , 15));
        saving.setBackground(Color.WHITE);
        add(saving) ;
        current = new JRadioButton("Current Account") ;
        current.setBounds(435 , 85 , 175 , 25);
        current.setFont(new Font("Raleway" , Font.BOLD , 15));
        current.setBackground(Color.WHITE);
        add(current) ;
        fd = new JRadioButton("Fixed Deposit Account") ;
        fd.setBounds(235 , 115 , 200 , 25);
        fd.setFont(new Font("Raleway" , Font.BOLD , 15));
        fd.setBackground(Color.WHITE);
        add(fd) ;
        rd = new JRadioButton("Recurring Deposit Account") ;
        rd.setBounds(435 , 115 , 250 , 25);
        rd.setFont(new Font("Raleway" , Font.BOLD , 15));
        rd.setBackground(Color.WHITE);
        add(rd) ;

        ButtonGroup accountType = new ButtonGroup() ;
        accountType.add(saving);
        accountType.add(current);
        accountType.add(fd);
        accountType.add(rd);

        JLabel l3 = new JLabel("Card Number : ") ;
        l3.setFont(new Font("Raleway" , Font.BOLD , 18));
        l3.setBounds(65 , 165 , 200 , 25);
        add(l3) ;
        JLabel l4 = new JLabel("XXXX-XXXX-XXXX-5946") ;
        l4.setFont(new Font("Raleway" , Font.BOLD , 18));
        l4.setBounds(250 , 165 , 225 , 25);
        add(l4) ;
        JLabel l7 = new JLabel("(Your 16 digit card number)") ;
        l7.setFont(new Font("Raleway" , Font.BOLD , 8));
        l7.setBounds(65 , 185 , 200 , 25);
        add(l7) ;

        JLabel L5 = new JLabel("PIN : ") ;
        L5.setFont(new Font("Raleway" , Font.BOLD , 18));
        L5.setBounds(65 , 225 , 200 , 25);
        add(L5) ;
        JLabel L6 = new JLabel("XXXX") ;
        L6.setFont(new Font("Raleway" , Font.BOLD , 18));
        L6.setBounds(250 , 225 , 225 , 25);
        add(L6) ;
        JLabel L8 = new JLabel("(Your 4 digit pin)") ;
        L8.setFont(new Font("Raleway" , Font.BOLD , 8));
        L8.setBounds(65 , 245 , 200 , 25);
        add(L8) ;

        JLabel L9 = new JLabel("Services Required : ") ;
        L9.setFont(new Font("Raleway" , Font.BOLD , 18));
        L9.setBounds(65 , 300 , 200 , 25);
        add(L9) ;
        atmCard = new JCheckBox("ATM Card") ;
        atmCard.setBounds(100 , 350 , 125 , 25);
        atmCard.setFont(new Font("Raleway" , Font.BOLD , 15));
        atmCard.setBackground(Color.WHITE);
        add(atmCard) ;
        mobileBanking = new JCheckBox("Mobile Banking") ;
        mobileBanking.setBounds(100 , 390 , 175 , 25);
        mobileBanking.setFont(new Font("Raleway" , Font.BOLD , 15));
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking) ;
        chequeBook = new JCheckBox("Cheque Book") ;
        chequeBook.setBounds(100 , 430 , 175 , 25);
        chequeBook.setFont(new Font("Raleway" , Font.BOLD , 15));
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook) ;
        internetBanking = new JCheckBox("Internet Banking") ;
        internetBanking.setBounds(325 , 350 , 150 , 25);
        internetBanking.setFont(new Font("Raleway" , Font.BOLD , 15));
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking) ;
        emailSmsAlerts = new JCheckBox("E-Mail & SMS Alerts") ;
        emailSmsAlerts.setBounds(325 , 390 , 175 , 25);
        emailSmsAlerts.setFont(new Font("Raleway" , Font.BOLD , 15));
        emailSmsAlerts.setBackground(Color.WHITE);
        add(emailSmsAlerts) ;
        eStatement = new JCheckBox("E-Statement") ;
        eStatement.setBounds(325 , 430 , 175 , 25);
        eStatement.setFont(new Font("Raleway" , Font.BOLD , 15));
        eStatement.setBackground(Color.WHITE);
        add(eStatement) ;


        last = new JCheckBox("I hereby declare that the above entered details are correct") ;
        last.setBounds(80 , 510 , 500 , 25);
        last.setFont(new Font("Raleway" , Font.BOLD , 13));
        last.setBackground(Color.WHITE);
        add(last) ;

        submit = new JButton("Submit") ;
        submit.setBounds(175 , 560 , 100 , 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit) ;

        cancel = new JButton("Cancel") ;
        cancel.setBounds(350 , 560 , 100 , 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel) ;

        getContentPane().setBackground(Color.WHITE);
        setSize(700 , 650);
        setVisible(true);
        setLocation(300 , 40);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null ;
            if(saving.isSelected()) accountType = "Saving Account" ;
            if(current.isSelected()) accountType = "Current Account" ;
            if(fd.isSelected()) accountType = "Fixed Deposit Account" ;
            if(rd.isSelected()) accountType = "Recurring Deposit Account" ;

            Random random = new Random() ;
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 4719826400000000L) ;

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L) ;

            String facility = "" ;
            if(atmCard.isSelected()) facility += " ATM Card " ;
            if(mobileBanking.isSelected()) facility += " Mobile Banking " ;
            if(chequeBook.isSelected()) facility += " Cheque Book " ;
            if(internetBanking.isSelected()) facility += " Internet Banking " ;
            if(emailSmsAlerts.isSelected()) facility += " Email & SMS Alerts " ;
            if(eStatement.isSelected()) facility += " E-Statement " ;

            try {
                Conn conn = new Conn() ;
                String query1 = "insert into signupthree values ('"+formno+"' , '"+accountType+"' , '"+cardNumber+"' , '"+pinNumber+"' , '"+facility+"')" ;
                String query2 = "insert into login values ('"+formno+"' , '"+cardNumber+"' , '"+pinNumber+"')" ;
                conn.s.executeUpdate(query1) ;
                conn.s.executeUpdate(query2) ;

                JOptionPane.showMessageDialog(null , "card number " + cardNumber + "\npin number " + pinNumber);

                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            }
            catch (Exception e){
                e.printStackTrace() ;
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("") ;
    }
}
