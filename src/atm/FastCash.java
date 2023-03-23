package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit , fastCash , pinChange , cashWithdrawal , miniStatement , balanceEnquiry , exit ;
    String pinNumber ;

    public FastCash(String pinNumber){

        this.pinNumber = pinNumber ;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900 , 650);
        add(image) ;

        JLabel text = new JLabel("Select Withdrawal Amount") ;
        text.setBounds(220 , 180 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text) ;

        deposit = new JButton("Rs.100") ;
        deposit.setBounds(167 , 292 , 145 , 30);
        deposit.addActionListener(this);
        image.add(deposit) ;

        fastCash = new JButton("Rs.500") ;
        fastCash.setBounds(167 , 327 , 145 , 30);
        fastCash.addActionListener(this);
        image.add(fastCash) ;

        pinChange = new JButton("Rs.1000") ;
        pinChange.setBounds(167 , 362 , 145 , 30);
        pinChange.addActionListener(this);
        image.add(pinChange) ;

        cashWithdrawal = new JButton("Rs.2000") ;
        cashWithdrawal.setBounds(365 , 292 , 145 , 30);
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal) ;

        miniStatement = new JButton("Rs.5000") ;
        miniStatement.setBounds(365 , 327 , 145 , 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement) ;

        balanceEnquiry = new JButton("Rs.10,000") ;
        balanceEnquiry.setBounds(365 , 362 , 145 , 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry) ;

        exit = new JButton("Back") ;
        exit.setBounds(365 , 397 , 145 , 27);
        exit.addActionListener(this);
        image.add(exit) ;


        setSize(900 , 700);
        setLocation(200 , 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else{
            String amount = ((JButton) ae.getSource()).getText().substring(3) ;

            Conn c = new Conn() ;
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'") ;

                int balance = 0 ;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount")) ;
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount")) ;
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null , "Insufficient Balance");
                    return ;
                }
                Date date = new Date() ;
                String query = "insert into bank values ('"+pinNumber+"' , '"+date+"' , '"+amount+"' , 'Withdraw')" ;
                c.s.executeUpdate(query) ;
                JOptionPane.showMessageDialog(null , "Rs."+ amount +" debited successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch(Exception e){
                e.printStackTrace() ;
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("") ;
    }
}
