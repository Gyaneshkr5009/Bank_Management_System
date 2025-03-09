package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField pinfield,repinfield;
    JButton change,back;                               
    JLabel text,pintext,repintext;
    String pin;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,25);
        image.add(text);
        
        pintext = new JLabel("New PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        repintext = new JLabel("Re-Enter New PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        pinfield = new JPasswordField();
        pinfield.setFont(new Font("Raleway", Font.BOLD, 25));
        pinfield.setBounds(330,320,180,25);
        image.add(pinfield);
        
        repinfield = new JPasswordField();
        repinfield.setFont(new Font("Raleway", Font.BOLD, 25));
        repinfield.setBounds(330,360,180,25);
        image.add(repinfield);
        
        change = new JButton("CHANGE");
        back = new JButton("BACK");
        
        change.addActionListener(this);
        back.addActionListener(this);
        
        setLayout(null);
     
        change.setBounds(390,588,150,35);
        image.add(change);
        
        back.setBounds(390,633,150,35);
        image.add(back);
        
        setSize(960,900);
        setLocation(300,0);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pinfield.getText();
                String rpin = repinfield.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    return ;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new Pin");
                    return;
                }
                Conn c1=new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signupThree set pin = '"+rpin+"' where pin = '"+pin+"' ";
                
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}