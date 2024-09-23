import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    JButton FW1,FW2,FW3,FW4,FW5,FW6,exit;
    String ID;
    int bal=0;
    Fastcash(String ID){
        this.ID=ID;
        super.setSize(900,900);
        super.setVisible(true);
        super.setLocation(300,0);
        setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel im= new JLabel(i3);
        im.setBounds(0,0,900,900);
        add(im);
        FW1=new JButton("Rs 500");
        FW1.setFont(new Font("arial",Font.BOLD,15));
        FW1.setBounds(160,420,160,30);
        FW1.addActionListener(this);
        im.add(FW1);
        FW2=new JButton("Rs 2000");
        FW2.setFont(new Font("arial",Font.BOLD,15));
        FW2.setBounds(360,420,160,30);
        FW2.addActionListener(this);
        im.add(FW2);
        FW3=new JButton("Rs 3000");
        FW3.setFont(new Font("arial",Font.BOLD,15));
        FW3.setBounds(160,450,160,30);
        FW3.addActionListener(this);
        im.add(FW3);
        FW4=new JButton("Rs 5000");
        FW4.setFont(new Font("arial",Font.BOLD,15));
        FW4.setBounds(360,450,160,30);
        FW4.addActionListener(this);
        im.add(FW4);
        FW5=new JButton("Rs 10000");
        FW5.setFont(new Font("arial",Font.BOLD,15));
        FW5.setBounds(160,480,160,30);
        FW5.addActionListener(this);
        im.add(FW5);
        FW6=new JButton("Rs 15000");
        FW6.setFont(new Font("arial",Font.BOLD,15));
        FW6.setBounds(360,480,160,30);
        FW6.addActionListener(this);
        im.add(FW6);
        exit=new JButton("Exit");
        exit.setFont(new Font("arial",Font.BOLD,15));
        exit.setBounds(360,510,160,30);
        exit.addActionListener(this);
        im.add(exit);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            super.setVisible(false);
            new homescreen(ID).setVisible(true);
        } else {
            String Amount= ((JButton)e.getSource()).getText().substring(3);
            Date Date= new Date();
            conn c = new conn();
            String query = "select * from transactions where Formno='"+ID+"'";
            try{
                ResultSet resultSet= c.s.executeQuery(query);
                while (resultSet.next()){
                    if(resultSet.getString("operationType").equals("Deposite")) {
                        bal += Integer.parseInt(resultSet.getString("amount"));
                    }else if (resultSet.getString("operationType").equals("Withdraw")){
                        bal -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
            String q = "insert into transactions values('"+ID+"','"+Date+"','Withdraw','"+Amount+"')";
            if(bal>Integer.parseInt(Amount)) {
                try {
                    c.s.executeUpdate(q);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                JOptionPane.showMessageDialog(null, Amount + " is Withdrawn successfully.");
                super.setVisible(false);
                new homescreen(ID).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Sorry, Insufficient Balence. \nTry later");
                super.setVisible(false);
                new homescreen(ID).setVisible(true);
            }

        }
    }
}
