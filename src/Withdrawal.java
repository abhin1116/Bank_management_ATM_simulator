import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JButton Back,Withdraw;
    JTextField WAmount;
    String ID;
    int bal=0;
    Withdrawal(String ID){
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
        JLabel heading= new JLabel("Enter the amount you want to Deposite.");
        heading.setBounds(160,300,350,30);
        heading.setFont(new Font("arial",Font.BOLD,18));
        heading.setForeground(Color.white);
        im.add(heading);
        WAmount= new JTextField();
        WAmount.setBounds(200,400,200,30);
        WAmount.setFont(new Font("arial",Font.BOLD,18));
        im.add(WAmount);
        Withdraw=new JButton("Withdraw");
        Withdraw.setBounds(160,510,160,30);
        Withdraw.setFont(new Font("arial",Font.BOLD,18));
        Withdraw.addActionListener(this);
        im.add(Withdraw);
        Back=new JButton("Back");
        Back.setBounds(360,510,160,30);
        Back.setFont(new Font("arial",Font.BOLD,18));
        Back.addActionListener(this);
        im.add(Back);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            super.setVisible(false);
            new homescreen(ID).setVisible(true);
        } else if (e.getSource()==Withdraw) {
            String Amount= WAmount.getText();
            Date D= new Date();

            if (Amount.equals("")){
                JOptionPane.showMessageDialog(null,"Withdrawal amount cannot be empty.");
            }else{
                conn c=new conn();
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
                String q= "insert into transactions values('"+ID+"','"+D+"','Withdraw','"+Amount+"')";
                if(bal>Integer.parseInt(Amount)) {
                    try {
                        c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, Amount + " is withdrawn from your Account.");
                        super.setVisible(false);
                        new homescreen(ID).setVisible(true);
                    } catch (Exception err) {
                        System.out.println(err);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Sorry, Insufficient Balence. \nTry later");
                    super.setVisible(false);
                    new homescreen(ID).setVisible(true);
                }
            }

        }
    }
}
