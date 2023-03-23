package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser ;

public class SignupOne extends JFrame implements ActionListener {

    JTextField nameTextField , fnameTextField , emailTextField , addressTextField , stateTextField , cityTextField , pinTextField ;
    JDateChooser dateChooser ;
    JRadioButton male , female , other , married , unmarried ;
    JButton next ;
    Long random ;

    public SignupOne(){

        Random ran = new Random() ;

        setLayout(null) ;

        random = Math.abs((ran.nextLong() % 9000L) + 1000L) ;

        JLabel formno = new JLabel("Application Form Number : " + random) ;
        formno.setFont(new Font("Raleway" , Font.BOLD , 30));
        formno.setBounds(120 , 20 , 500 , 40);
        add(formno) ;

        JLabel personaldetails = new JLabel("Page 1 : Personal Details") ;
        personaldetails.setFont(new Font("Raleway" , Font.BOLD , 23));
        personaldetails.setBounds(225 , 65 , 500 , 40);
        add(personaldetails) ;

        JLabel name = new JLabel("Name : ") ;
        name.setFont(new Font("Raleway" , Font.BOLD , 18));
        name.setBounds(100 , 140 , 100 , 25);
        add(name) ;
        nameTextField = new JTextField() ;
        nameTextField.setBounds(300 , 140 , 300 , 25);
        nameTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(nameTextField) ;

        JLabel fname = new JLabel("Father's Name : ") ;
        fname.setFont(new Font("Raleway" , Font.BOLD , 18));
        fname.setBounds(100 , 175 , 200 , 25);
        add(fname) ;
        fnameTextField = new JTextField() ;
        fnameTextField.setBounds(300 , 175 , 300 , 25);
        fnameTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(fnameTextField) ;

        JLabel dob = new JLabel("Date Of Birth : ") ;
        dob.setFont(new Font("Raleway" , Font.BOLD , 18));
        dob.setBounds(100 , 210 , 200 , 25);
        add(dob) ;
        dateChooser = new JDateChooser() ;
        dateChooser.setBounds(300 , 210 , 200 , 25);
        dateChooser.setForeground(new Color(105 , 105 , 105));
        add(dateChooser) ;

        JLabel gender = new JLabel("Gender : ") ;
        gender.setFont(new Font("Raleway" , Font.BOLD , 18));
        gender.setBounds(100 , 245 , 200 , 25);
        add(gender) ;
        male = new JRadioButton("Male") ;
        male.setBounds(300 , 245 , 60 , 25);
        male.setBackground(Color.WHITE);
        add(male) ;
        female = new JRadioButton("Female") ;
        female.setBounds(400 , 245 , 75 , 25);
        female.setBackground(Color.WHITE);
        add(female) ;
        other = new JRadioButton("Other") ;
        other.setBounds(515 , 245 , 75 , 25);
        other.setBackground(Color.WHITE);
        add(other) ;
        ButtonGroup genderGroup = new ButtonGroup() ;
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("Email id : ") ;
        email.setFont(new Font("Raleway" , Font.BOLD , 18));
        email.setBounds(100 , 280 , 200 , 25);
        add(email) ;
        emailTextField = new JTextField() ;
        emailTextField.setBounds(300 , 280 , 300 , 25);
        emailTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(emailTextField) ;

        JLabel maritalstatus = new JLabel("Marital Status : ") ;
        maritalstatus.setFont(new Font("Raleway" , Font.BOLD , 18));
        maritalstatus.setBounds(100 , 315 , 200 , 25);
        add(maritalstatus) ;
        married = new JRadioButton("Married") ;
        married.setBounds(300 , 315 , 100 , 25);
        married.setBackground(Color.WHITE);
        add(married) ;
        unmarried = new JRadioButton("Unmarried") ;
        unmarried.setBounds(400 , 315 , 100 , 25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried) ;
        ButtonGroup maritalGroup = new ButtonGroup() ;
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        JLabel address = new JLabel("Address : ") ;
        address.setFont(new Font("Raleway" , Font.BOLD , 18));
        address.setBounds(100 , 350 , 200 , 25);
        add(address) ;
        addressTextField = new JTextField() ;
        addressTextField.setBounds(300 , 350 , 300 , 25);
        addressTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(addressTextField) ;

        JLabel state = new JLabel("State : ") ;
        state.setFont(new Font("Raleway" , Font.BOLD , 18));
        state.setBounds(100 , 385 , 200 , 25);
        add(state) ;
        stateTextField = new JTextField() ;
        stateTextField.setBounds(300 , 385 , 300 , 25);
        stateTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(stateTextField) ;

        JLabel city = new JLabel("City : ") ;
        city.setFont(new Font("Raleway" , Font.BOLD , 18));
        city.setBounds(100 , 420 , 200 , 25);
        add(city) ;
        cityTextField = new JTextField() ;
        cityTextField.setBounds(300 , 420 , 300 , 25);
        cityTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(cityTextField) ;

        JLabel pincode = new JLabel("Pin Code : ") ;
        pincode.setFont(new Font("Raleway" , Font.BOLD , 18));
        pincode.setBounds(100 , 455 , 200 , 25);
        add(pincode) ;
        pinTextField = new JTextField() ;
        pinTextField.setBounds(300 , 455 , 300 , 25);
        pinTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(pinTextField) ;

        next = new JButton("Next") ;
        next.setBounds(520 , 500 , 80 , 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next) ;

        getContentPane().setBackground(Color.WHITE);
        setSize(700 , 600);
        setVisible(true);
        setLocation(300 , 40);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random ;
        String name = nameTextField.getText() ;
        String fname = fnameTextField.getText() ;
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText() ;
        String gender = null ;
        if(male.isSelected()) gender = "Male" ;
        else if(female.isSelected()) gender = "Female" ;
        else if(other.isSelected()) gender = "Other" ;
        String email = emailTextField.getText() ;
        String maritalStatus = married.isSelected() ? "Married" : "Unmarried" ;
        String address = addressTextField.getText() ;
        String state = stateTextField.getText() ;
        String city = cityTextField.getText() ;
        String pin = pinTextField.getText() ;

        try {
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null , "Name is required");
            }else{
                Conn c = new Conn() ;
                String query = "insert into signup values ( '"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+maritalStatus+"' , '"+address+"' , '"+state+"' , '"+city+"' , '"+pin+"')" ;
                c.s.executeUpdate(query) ;

                setVisible(false) ;
                new SignupTwo(formno).setVisible(true) ;
            }
        }
        catch (Exception e){
            e.printStackTrace() ;
        }
    }
    public static void main(String[] args) {
        new SignupOne() ;
    }
}
