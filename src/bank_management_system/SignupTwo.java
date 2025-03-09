package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField , aadharTextField ,pincodeTextField; 
    JButton next;
    JRadioButton syes,sno , eyes , eno;
    JComboBox religion , category, income , occupation , education;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Detils");
        additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
        additionalDetails.setBounds(290 , 80 , 400 , 30);
        add(additionalDetails);
        
        // Religion Text field;
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway" , Font.BOLD , 20));
        name.setBounds(100 , 140 , 100 , 30);
        add(name);
        
        String[] valReligion = {"Hinduism" , "Christian" , "Buddhist" , "Muslim" , "Sikhism" , "Jainism","Judaism" , "Baháʼí Faith", "Zoroastrianism" , "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300 , 140 , 400 , 30);
        religion.setBackground(Color.LIGHT_GRAY);
        add(religion);
        
        //Category text Field
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway" , Font.BOLD , 20));
        fname.setBounds(100 , 190 , 200 , 30);
        add(fname);
        
        
        String[] Category={"General" , "OBC" , "SC" , "ST" , "Other"};
        category= new JComboBox(Category);
        category.setBounds(300 , 190 , 400 , 30);
        category.setBackground(Color.LIGHT_GRAY);
        add(category);
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway" , Font.BOLD , 20));
        dob.setBounds(100 , 240 , 200 , 30);
        add(dob);
        
        String[] incomeCategory={"null" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000" , "Upto 10,00,000"};
        income= new JComboBox(incomeCategory);
        income.setBounds(300 , 240 , 400 , 30);
        income.setBackground(Color.LIGHT_GRAY);
        add(income);
        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway" , Font.BOLD , 20));
        gender.setBounds(100 , 290 , 200 , 30);
        add(gender);
        
        JLabel email=new JLabel("Qualifiaction:");
        email.setFont(new Font("Raleway" , Font.BOLD , 20));
        email.setBounds(100 , 317 , 200 , 30);
        add(email);
        
        String[] occupationValues={"Salaried" , "Self-Employed" , "Bussiness" , "Student", "Retired" , "Others"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300 , 390 , 400 , 30);
        occupation.setBackground(Color.LIGHT_GRAY);
        add(occupation);
        
        //
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway" , Font.BOLD , 20));
        marital.setBounds(100 , 390 , 200 , 30);
        add(marital);
        
        String[] educationValues={"Non-Graduation" , "Graduate" , "Post-Graduation" , "Doctrate" , "Others"};
        education= new JComboBox(educationValues);
        education.setBounds(300 , 317 , 400 , 30);
        education.setBackground(Color.LIGHT_GRAY);
        add(education);
        
        
        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway" , Font.BOLD , 20));
        address.setBounds(100 , 440 , 200 , 30);
        add(address);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway" , Font.BOLD ,14));
        panTextField.setBounds(300 , 440 , 400 , 30);
        add(panTextField);
        
        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway" , Font.BOLD , 20));
        aadhar.setBounds(100 , 490 , 200 , 30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway" , Font.BOLD ,14));
        aadharTextField.setBounds(300 , 490 , 400 , 30);
        add(aadharTextField);
        
        JLabel state=new JLabel("Sinior Citizen:");
        state.setFont(new Font("Raleway" , Font.BOLD , 20));
        state.setBounds(100 , 540 , 200 , 30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300 , 540 , 120 , 30);
        syes.setBackground(Color.LIGHT_GRAY);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(440 , 540 , 120 , 30);
        sno.setBackground(Color.LIGHT_GRAY);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
        pincode.setBounds(100 , 590 , 200 , 30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300 , 590 , 120 , 30);
        eyes.setBackground(Color.LIGHT_GRAY);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(440 , 590 , 120 , 30);
        eno.setBackground(Color.LIGHT_GRAY);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.LIGHT_GRAY);
        next.setFont(new Font("Raleway" , Font.BOLD,14));
        next.setBounds(620 , 660 ,80 , 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(850 , 800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem(); //setText
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation= (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        try{
            
            Conn c= new Conn();
            String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            //signupThree object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new SignupTwo("");
    }
}
