package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField , panTextField ;
    JRadioButton syes , sno , eyes , eno;
    JButton next ;
    JComboBox religion , category , income , education , occupation ;
    String formno ;

    public SignupTwo(String formno){

        this.formno = formno ;

        setLayout(null) ;

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details") ;
        additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 23));
        additionalDetails.setBounds(225 , 20 , 500 , 40);
        add(additionalDetails) ;

        JLabel setReligion = new JLabel("Religion : ") ;
        setReligion.setFont(new Font("Raleway" , Font.BOLD , 18));
        setReligion.setBounds(100 , 85 , 100 , 25);
        add(setReligion) ;
        String[] valReligion = {"Hindu" , "Muslim" , "Sikh" , "Christian" , "Other"} ;
        religion = new JComboBox(valReligion) ;
        religion.setBounds(300 , 85 , 300 , 25);
        religion.setBackground(Color.WHITE);
        add(religion) ;

        JLabel setCategory = new JLabel("Category : ") ;
        setCategory.setFont(new Font("Raleway" , Font.BOLD , 18));
        setCategory.setBounds(100 , 135 , 200 , 25);
        add(setCategory) ;
        String[] valCategory = {"SC" , "ST" , "General" , "OBC" , "Other"} ;
        category = new JComboBox(valCategory) ;
        category.setBounds(300 , 135 , 300 , 25);
        category.setBackground(Color.WHITE);
        add(category) ;

        JLabel setIncome = new JLabel("Income : ") ;
        setIncome.setFont(new Font("Raleway" , Font.BOLD , 18));
        setIncome.setBounds(100 , 185 , 200 , 25);
        add(setIncome) ;
        String[] valIncome = {"Null" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000" , "Upto 10,00,000"} ;
        income = new JComboBox(valIncome) ;
        income.setBounds(300 , 185 , 200 , 25);
        income.setBackground(Color.WHITE);
        add(income) ;

        JLabel ed = new JLabel("Educational") ;
        ed.setFont(new Font("Raleway" , Font.BOLD , 18));
        ed.setBounds(100 , 235 , 200 , 25);
        add(ed) ;
        JLabel qual = new JLabel("Qualification : ") ;
        qual.setFont(new Font("Raleway" , Font.BOLD , 18));
        qual.setBounds(100 , 255 , 200 , 25);
        add(qual) ;
        String[] educationValues = {"High School" , "Graduation" , "Post Graduation" , "Masters" , "P.H.D" , "Others"} ;
        education = new JComboBox(educationValues) ;
        education.setBounds(300 , 243 , 200 , 25);
        education.setBackground(Color.WHITE);
        add(education) ;

        JLabel setOccupation = new JLabel("Occupation : ") ;
        setOccupation.setFont(new Font("Raleway" , Font.BOLD , 18));
        setOccupation.setBounds(100 , 295 , 200 , 25);
        add(setOccupation) ;
        String[] occupationValues = {"Salaried" , "Self-Employed" , "Businessman" , "Student" , "Retired" , "Others"} ;
        occupation = new JComboBox(occupationValues) ;
        occupation.setBounds(300 , 295 , 200 , 25);
        occupation.setBackground(Color.WHITE);
        add(occupation) ;

        JLabel aadhar = new JLabel("Aadhar Number : ") ;
        aadhar.setFont(new Font("Raleway" , Font.BOLD , 18));
        aadhar.setBounds(100 , 345 , 200 , 25);
        add(aadhar) ;
        aadharTextField = new JTextField() ;
        aadharTextField.setBounds(300 , 345 , 300 , 25);
        aadharTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(aadharTextField) ;

        JLabel pan = new JLabel("PAN Number : ") ;
        pan.setFont(new Font("Raleway" , Font.BOLD , 18));
        pan.setBounds(100 , 395 , 200 , 25);
        add(pan) ;
        panTextField = new JTextField() ;
        panTextField.setBounds(300 , 395 , 300 , 25);
        panTextField.setFont(new Font("Oswald" , Font.ITALIC , 16));
        add(panTextField) ;

        JLabel senCit = new JLabel("Senior Citizen : ") ;
        senCit.setFont(new Font("Raleway" , Font.BOLD , 18));
        senCit.setBounds(100 , 445 , 200 , 25);
        add(senCit) ;
        syes = new JRadioButton("Yes") ;
        syes.setBounds(300 , 445 , 60 , 25);
        syes.setBackground(Color.WHITE);
        add(syes) ;
        sno = new JRadioButton("No") ;
        sno.setBounds(400 , 445 , 45 , 25);
        sno.setBackground(Color.WHITE);
        add(sno) ;
        ButtonGroup seniorCitizen = new ButtonGroup() ;
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);

        JLabel existAcc = new JLabel("Existing Account : ") ;
        existAcc.setFont(new Font("Raleway" , Font.BOLD , 18));
        existAcc.setBounds(100 , 495 , 200 , 25);
        add(existAcc) ;
        eyes = new JRadioButton("Yes") ;
        eyes.setBounds(300 , 495 , 60 , 25);
        eyes.setBackground(Color.WHITE);
        add(eyes) ;
        eno = new JRadioButton("No") ;
        eno.setBounds(400 , 495 , 45 , 25);
        eno.setBackground(Color.WHITE);
        add(eno) ;
        ButtonGroup existingAccount = new ButtonGroup() ;
        existingAccount.add(eyes);
        existingAccount.add(eno);

        next = new JButton("Next") ;
        next.setBounds(520 , 500 , 80 , 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next) ;

        getContentPane().setBackground(Color.WHITE);
        setSize(700 , 650);
        setVisible(true);
        setLocation(300 , 40);
    }

    public void actionPerformed(ActionEvent ae){
        String sReligion = (String)religion.getSelectedItem() ;
        String sCategory = (String)category.getSelectedItem() ;
        String sIncome = (String)income.getSelectedItem() ;
        String sEducation = (String)education.getSelectedItem() ;
        String sOccupation = (String)occupation.getSelectedItem() ;
        String sAadhar = aadharTextField.getText() ;
        String sPan = panTextField.getText() ;
        String seniorCitizen = null ;
        if(syes.isSelected()) seniorCitizen = "Yes" ;
        else if(sno.isSelected()) seniorCitizen = "No" ;
        String existingAccount = null ;
        if(eyes.isSelected()) existingAccount = "Yes" ;
        else if(eno.isSelected()) existingAccount = "No" ;

        try {
            Conn c = new Conn() ;
            String query = "insert into signuptwo values ( '"+formno+"' , '"+sReligion+"' , '"+sCategory+"' , '"+sIncome+"' , '"+sEducation+"' , '"+sOccupation+"' , '"+sAadhar+"' , '"+sPan+"' , '"+seniorCitizen+"' , '"+existingAccount+"')" ;
            c.s.executeUpdate(query) ;

            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace() ;
        }
    }
    public static void main(String[] args) {
        new SignupTwo("") ;
    }
}
