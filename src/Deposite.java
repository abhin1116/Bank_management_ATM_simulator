import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    String ID;
    JTextField DAmount;
    JButton Depo,Back;
    Deposite(String ID){
//        this.ID=ID;
//        super.setSize(900,900);
//        super.setLocation(300,0);
//        super.setVisible(true);
//        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(null);
//        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
//        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
//        ImageIcon i3= new ImageIcon(i2);
//        JLabel i = new JLabel(i3);
//        i.setBounds(0,0,900,900);
//        add(i);
        System.out.println("you are in deposite page...");
        this.ID=ID;
        super.setSize(900,900);
        super.setVisible(true);
        super.setLocation(300,0);
        setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        JLabel heading= new JLabel("Enter the amount you want to Deposite.");
        heading.setBounds(160,300,350,30);
        heading.setFont(new Font("arial",Font.BOLD,18));
        heading.setForeground(Color.white);
        img.add(heading);
        DAmount= new JTextField();
        DAmount.setBounds(200,400,200,30);
        DAmount.setFont(new Font("arial",Font.BOLD,18));
        img.add(DAmount);
        Depo=new JButton("Deposite");
        Depo.setBounds(160,510,160,30);
        Depo.setFont(new Font("arial",Font.BOLD,18));
        Depo.addActionListener(this);
        img.add(Depo);
        Back=new JButton("Back");
        Back.setBounds(360,510,160,30);
        Back.setFont(new Font("arial",Font.BOLD,18));
        Back.addActionListener(this);
        img.add(Back);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            super.setVisible(false);
            new homescreen(ID).setVisible(true);
        }else if(e.getSource()==Depo){
            String Date= String.valueOf(new Date());
            String Amount=(DAmount.getText());
            if(Amount.equals("")){
                JOptionPane.showMessageDialog(null, "Amount Feild cannot be empty.");
            }else {
                conn c = new conn();
                String q= "insert into transactions values('"+ID+"','"+Date+"','Deposite','"+Amount+"')";
                try {
                    c.s.executeUpdate(q);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                JOptionPane.showMessageDialog(null, Amount+" is Deposited successfully.");
                super.setVisible(false);
                new homescreen(ID).setVisible(true);
            }


        }

    }
}
