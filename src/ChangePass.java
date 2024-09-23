import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChangePass extends JFrame implements ActionListener {
    String ID;
    JTextField Pass,Repass;
    JButton ChPass,Back;
    ChangePass(String ID){
        this.ID=ID;
        super.setLayout(null);
        super.setVisible(true);
        super.setSize(900,900);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocation(300,0);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        JLabel heading= new JLabel("Enter the new password.");
        heading.setBounds(160,300,250,30);
        heading.setFont(new Font("arial",Font.BOLD,18));
        heading.setForeground(Color.white);
        img.add(heading);
        Pass= new JTextField();
        Pass.setBounds(200,350,200,30);
        Pass.setFont(new Font("arial",Font.BOLD,18));
        img.add(Pass);
        JLabel h1= new JLabel("Re-enter the new password.");
        h1.setBounds(160,400,250,30);
        h1.setFont(new Font("arial",Font.BOLD,18));
        h1.setForeground(Color.white);
        img.add(h1);

        Repass= new JTextField();
        Repass.setBounds(200,450,200,30);
        Repass.setFont(new Font("arial",Font.BOLD,18));
        img.add( Repass);

        ChPass=new JButton("Change Password");
        ChPass.setFont(new Font("arial",Font.BOLD,12));
        ChPass.setBounds(360,510,160,30);
        ChPass.addActionListener(this);
        img.add(ChPass);
        Back=new JButton("Back");
        Back.setBounds(160,510,160,30);
        Back.setFont(new Font("arial",Font.BOLD,18));
        Back.addActionListener(this);
        img.add(Back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            super.setVisible(false);
            new homescreen(ID).setVisible(true);
        } else if (e.getSource()==ChPass){
            String P=Pass.getText();
            String RP=Repass.getText();
            if(P.equals("")){
                JOptionPane.showMessageDialog(null,"PIN can not be empty.");
            }else {
                if(P.equals(RP)){
                    conn c = new conn();
                    String q ="UPDATE accounts SET Pinno='"+P+"' WHERE Formno='"+ID+"'";
                    try {
                        c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "The pasword is updated.");
                        super.setVisible(false);
                        new homescreen(ID).setVisible(true);

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,   "Oops password didn't match.\n Re-enter the password.");
                    Pass.setText("");
                    Repass.setText("");
                }
            }
            }
    }

}
