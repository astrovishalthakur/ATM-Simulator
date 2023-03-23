package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton signin , signup , clear ;

    JTextField cardTextField ;

    JPasswordField pinTextField ;

    public Login(){

        setTitle("Automated Teller Machine");

        setLayout(null) ;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank1.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(100 , 100 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel label = new JLabel(i3) ;
        label.setBounds(50 , 10 , 100 , 100);
        add(label) ;

        JLabel text = new JLabel("Welcome to ATM") ;
        text.setFont(new Font("Oswald" , Font.BOLD , 38));
        text.setBounds(180 , 40 , 400 , 40);
        add(text) ;

        JLabel CardNo = new JLabel("Card Number : ") ;
        CardNo.setFont(new Font("Raleway" , Font.BOLD , 20));
        CardNo.setBounds(120 , 140 , 150 , 40);
        add(CardNo) ;
        cardTextField = new JTextField() ;
        cardTextField.setBounds(300 , 147 , 170 , 30);
        cardTextField.setFont(new Font("Arial" , Font.BOLD , 15));
        add(cardTextField) ;

        JLabel Pin = new JLabel("PIN : ") ;
        Pin.setFont(new Font("Raleway" , Font.BOLD , 20));
        Pin.setBounds(120 , 200 , 150 , 40);
        add(Pin) ;
        pinTextField = new JPasswordField() ;
        pinTextField.setBounds(300 , 207 , 100 , 30);
        pinTextField.setFont(new Font("Arial" , Font.BOLD , 15));
        add(pinTextField) ;

        signin = new JButton("SIGN IN") ;
        signin.setBounds(200 , 300 , 100 , 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin) ;

        clear = new JButton("CLEAR") ;
        clear.setBounds(325 , 300 , 100 , 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear) ;

        signup = new JButton("SIGN UP") ;
        signup.setBounds(263 , 350 , 100 , 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup) ;

        getContentPane().setBackground(Color.WHITE);

        setSize(600 , 450);
        setVisible(true);
        setLocation(320 , 120);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signin){

            Conn conn = new Conn() ;
            String cardNumber = cardTextField.getText() ;
            String pinNumber = pinTextField.getText() ;
            String query = "select * from login where cardnumber = '"+ cardNumber+"' and pin = '"+pinNumber+"'" ;

            try {
                ResultSet rs = conn.s.executeQuery(query) ;
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null , "Incorrect card number or pin");
                }
            }
            catch (Exception e){
                e.printStackTrace() ;
            }

        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new Login() ;
    }
}
