import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

public class Statement extends JFrame{
    String ID;
    int bal=0;
    JLabel T,h,c1,c3,c2,name,date;
    Statement(String ID){
        this.ID=ID;
        super.setLayout(null);
        super.setSize(600,800);
        super.setLocation(400,50);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
        conn c = new conn();
        String q ="SELECT * FROM transactions WHERE Formno='"+ID+"'";
        String query="SELECT * FROM user WHERE formno='"+ID+"'";
        Date d= new Date();
        date=new JLabel(String.valueOf(d));
        date.setBounds(200,20,350,20);
        date.setFont(new Font("Arial",Font.PLAIN,14));
        add(date);

        try{
            ResultSet resultSet= c.s.executeQuery(query);
            while (resultSet.next()){
                name=new JLabel("Welcome "+resultSet.getString("name")+"!");
                name.setBounds(200,50,400,20);
                name.setFont(new Font("Arial",Font.PLAIN,14));
                add(name);
            }
        }catch (Exception err){
            System.out.println(err);
        }
        h=new JLabel("Statement");
        h.setBounds(250,80,100,20);
        h.setFont(new Font("Raleway",Font.BOLD,20));
        add(h);
        c1= new JLabel("Date and Time");
        c1.setFont(new Font("Arial",Font.PLAIN,14));
        c1.setBounds(50,120,300,20);
        add(c1);
        c2= new JLabel("Type");
        c2.setFont(new Font("Arial",Font.PLAIN,14));
        c2.setBounds(350,120,150,20);
        add(c2);
        c3= new JLabel("Amount");
        c3.setFont(new Font("Arial",Font.PLAIN,14));
        c3.setBounds(500,120,100,20);
        add(c3);

        try{
            ResultSet rs= c.s.executeQuery(q);
            int height= 0;
            while (rs.next()) {
                if (rs.getString("operationType").equals("Deposite")) {
                    c1 = new JLabel(rs.getString("datetime"));
                    c1.setFont(new Font("Arial", Font.PLAIN, 14));
                    c1.setBounds(50, 160 + height, 300, 20);
                    add(c1);
                    c2 = new JLabel(rs.getString("operationType"));
                    c2.setFont(new Font("Arial", Font.PLAIN, 14));
                    c2.setBounds(350, 160 + height, 150, 20);
                    add(c2);
                    c3 = new JLabel(rs.getString("amount"));
                    c3.setFont(new Font("Arial", Font.PLAIN, 14));
                    c3.setBounds(500, 160 + height, 100, 20);
                    add(c3);
                    height += 40;
                    bal += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("operationType").equals("Withdraw")) {
                    c1 = new JLabel(rs.getString("datetime"));
                    c1.setFont(new Font("Arial", Font.PLAIN, 14));
                    c1.setBounds(50, 160 + height, 300, 20);
                    add(c1);
                    c2 = new JLabel(rs.getString("operationType"));
                    c2.setFont(new Font("Arial", Font.PLAIN, 14));
                    c2.setBounds(350, 160 + height, 150, 20);
                    add(c2);
                    c3 = new JLabel(rs.getString("amount"));
                    c3.setFont(new Font("Arial", Font.PLAIN, 14));
                    c3.setBounds(500, 160 + height, 100, 20);
                    add(c3);
                    height += 40;
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            T = new JLabel("Total:"+bal);
            T.setFont(new Font("Arial",Font.PLAIN,14));
            T.setBounds(500,160+height,100,20);
            add(T);

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}
