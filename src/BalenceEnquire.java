import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalenceEnquire extends JFrame implements ActionListener {
    JLabel Balence;
    JButton Back;
    String ID;
    int bal=0;
    BalenceEnquire(String ID){
        this.ID=ID;
        super.setSize(300,300);
        super.setLocation(300,100);
        super.setLayout(null);
        super.setTitle("Account Balence");
        super.setVisible(true);
        conn con = new conn();
        String q = "select * from transactions where Formno='"+ID+"'";
        try{
            ResultSet resultSet= con.s.executeQuery(q);
            while (resultSet.next()){
                if(resultSet.getString("operationType").equals("Deposite")) {
                    bal += Integer.parseInt(resultSet.getString("amount"));
                }else if (resultSet.getString("operationType").equals("Withdraw")){
                    bal -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        Balence= new JLabel("Your balence is: \n"+bal);
        Balence.setBounds(50,50,160,80);
        Balence.setFont(new Font("Raleway",Font.BOLD,16));
        add(Balence);
        Back= new JButton("Back");
        Back.setBounds(60,120,130,30);
        Back.setFont(new Font("Raleway",Font.BOLD,16));
        Back.addActionListener(this);
        add(Back);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            super.setVisible(false);
            new homescreen(ID).setVisible(true);
        }
    }
}
