package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinTextField , repinTextField ;
    JButton change , back ;
    String pinNumber ;

    public PinChange(String pinNumber){

        this.pinNumber = pinNumber ;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900 , 900 , Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0 , 0 , 900 , 650);
        add(image) ;

        JLabel text = new JLabel("Change your PIN") ;
        text.setBounds(250 , 180 , 700 , 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 16));
        image.add(text) ;

        JLabel pinText = new JLabel("New PIN : ") ;
        pinText.setBounds(200 , 250 , 700 , 35);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System" , Font.BOLD , 16));
        image.add(pinText) ;

        pinTextField = new JPasswordField() ;
        pinTextField.setFont(new Font("System" , Font.BOLD , 16));
        pinTextField.setBounds(365 , 250 , 100 , 30);
        image.add(pinTextField) ;

        JLabel repinText = new JLabel("Re-Enter New PIN : ") ;
        repinText.setBounds(200 , 285 , 700 , 35);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System" , Font.BOLD , 16));
        image.add(repinText) ;

        repinTextField = new JPasswordField() ;
        repinTextField.setFont(new Font("System" , Font.BOLD , 16));
        repinTextField.setBounds(365 , 285 , 100 , 30);
        image.add(repinTextField) ;

        change = new JButton("Change") ;
        change.setBounds(365 , 362 , 145 , 30);
        change.addActionListener(this);
        image.add(change) ;

        back = new JButton("Back") ;
        back.setBounds(365 , 397 , 145 , 27);
        back.addActionListener(this);
        image.add(back) ;


        setSize(900 , 700);
        setLocation(200 , 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == change){
            try {
                String npin = pinTextField.getText() ;
                String renpin = repinTextField.getText() ;

                if(! npin.equals(renpin)){
                    JOptionPane.showMessageDialog(null , "PIN doesn't match");
                }
                else if(npin.isEmpty()){
                    JOptionPane.showMessageDialog(null , "PIN not entered");
                }
                else if(renpin.isEmpty()){
                    JOptionPane.showMessageDialog(null , "Please re-enter pin");
                }
                else{
                    Conn conn = new Conn() ;
                    String query1 = "update bank set pin = '"+npin+"' where pin = '"+pinNumber+"'" ;
                    String query2 = "update login set pin = '"+npin+"' where pin = '"+pinNumber+"'" ;
                    String query3 = "update signupthree set pinNumber = '"+npin+"' where pinNumber = '"+pinNumber+"'" ;

                    conn.s.executeUpdate(query1) ;
                    conn.s.executeUpdate(query2) ;
                    conn.s.executeUpdate(query3) ;

                    JOptionPane.showMessageDialog(null , "PIN changed successfully");
                    setVisible(false);
                    new Transactions(npin).setVisible(true);
                }
            }
            catch(Exception e){
                e.printStackTrace() ;
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
