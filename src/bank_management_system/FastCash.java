package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel text, l2;
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balancequery, exit;
    JTextField t1;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);

        text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setBounds(210, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 499, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(390, 499, 150, 35);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 543, 150, 35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(390, 543, 150, 35);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 588, 150, 35);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancequery = new JButton("Rs 10000");
        balancequery.setBounds(390, 588, 150, 35);
        balancequery.addActionListener(this);
        image.add(balancequery);
        
        exit = new JButton("BACK");
        exit.setBounds(390, 633, 150, 35);
        exit.addActionListener(this);
        image.add(exit);

        setLayout(null);

  
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                 int balance=0;
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance+=Integer.parseInt(rs.getString("amount"));
                     }
                     else{
                         balance-=Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 
                 if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null , "Insufficient Balance");
                     return;
                 }
                 Date date=new Date();
                 String query="insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,  "Rs. " +amount+ " Debited Successfully");
                 setVisible(false);
                 new Transactions(pin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}