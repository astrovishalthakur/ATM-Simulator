package atm;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinNumber ;

    public MiniStatement(String pinNumber){

        this.pinNumber = pinNumber ;

        setLayout(null);

        setTitle("Mini Statement");

        JLabel mini = new JLabel() ;
        mini.setBounds(20 , 150 , 700 , 30);
        add(mini) ;

        JLabel bank = new JLabel("Canara Bank") ;
        bank.setBounds(150 , 20 , 100 , 30);
        add(bank) ;

        JLabel card = new JLabel() ;
        card.setBounds(20 , 80 , 300 , 30);
        add(card) ;

        JLabel balance = new JLabel() ;
        balance.setBounds(20 , 400 , 300 , 20);
        add(balance) ;

        try {
            Conn conn = new Conn() ;
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinNumber+"'") ;

            while (rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0 , 4) + "-XXXX-XXXX-"+ rs.getString("cardnumber").substring(12));
            }
        }
        catch (Exception e){
            e.printStackTrace() ;
        }

        try {
            Conn c = new Conn() ;
            int bal = 0 ;
            ResultSet ab = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'") ;

            while (ab.next()){
                mini.setText(mini.getText() + "<html>" + ab.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + ab.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + ab.getString("amount") + "<br><br><html>");
                if (ab.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(ab.getString("amount"));
                } else {
                    bal -= Integer.parseInt(ab.getString("amount"));
                }
            }

            balance.setText("Your Balance is Rs." + bal);
        }
        catch (Exception e){
            e.printStackTrace() ;
        }

        setSize(400 , 600);
        setLocation(20 , 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {

        new MiniStatement("") ;

    }
}
