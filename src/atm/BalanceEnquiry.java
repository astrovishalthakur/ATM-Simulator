package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back ;
    String pinNumber ;

    public BalanceEnquiry(String pinNumber){

        this.pinNumber = pinNumber ;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900 , 650);
        add(image) ;

        back = new JButton("Back") ;
        back.setBounds(365 , 397 , 145 , 27);
        back.addActionListener(this);
        image.add(back) ;

        Conn c = new Conn() ;
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace() ;
        }

        JLabel text = new JLabel("Your Account balance is Rs." + balance) ;
        text.setBounds(165 , 225 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 20));
        image.add(text) ;

        setSize(900 , 700);
        setLocation(200 , 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {

        new BalanceEnquiry("") ;
    }
}
