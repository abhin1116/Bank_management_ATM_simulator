import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homescreen extends JFrame implements ActionListener {
    JButton deposite, withdrawal, balenceEnquire, fastCash, miniStatement, changePassword, exit;
    String ID;
    homescreen(String ID){
        this.ID=ID;
        super.setSize(900,900);
        super.setLocation(300,0);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i = new JLabel(i3);
        i.setBounds(0,0,900,900);
        add(i);
        JLabel text= new JLabel("Welcome to the ATM");
        text.setBounds(250,300,300,30);
        text.setFont(new Font("arial",Font.BOLD,18));
        text.setForeground(Color.white);
        i.add(text);

        deposite=new JButton("Deposite");
        deposite.setFont(new Font("arial",Font.BOLD,15));
        deposite.setBounds(160,420,160,30);
        deposite.addActionListener(this);
        i.add(deposite);
        withdrawal=new JButton("Withdrawal");
        withdrawal.setFont(new Font("arial",Font.BOLD,15));
        withdrawal.setBounds(360,420,160,30);
        withdrawal.addActionListener(this);
        i.add(withdrawal);
        fastCash=new JButton("Fast Cash");
        fastCash.setFont(new Font("arial",Font.BOLD,15));
        fastCash.setBounds(160,450,160,30);
        fastCash.addActionListener(this);
        i.add(fastCash);
        balenceEnquire=new JButton("Balence Enquire");
        balenceEnquire.setFont(new Font("arial",Font.BOLD,15));
        balenceEnquire.setBounds(360,450,160,30);
        balenceEnquire.addActionListener(this);
        i.add(balenceEnquire);
        changePassword=new JButton("Change Password");
        changePassword.setFont(new Font("arial",Font.BOLD,13));
        changePassword.setBounds(160,480,160,30);
        changePassword.addActionListener(this);
        i.add(changePassword);
        miniStatement=new JButton("Mini-Statement");
        miniStatement.setFont(new Font("arial",Font.BOLD,15));
        miniStatement.setBounds(360,480,160,30);
        miniStatement.addActionListener(this);
        i.add(miniStatement);
        exit=new JButton("Exit");
        exit.setFont(new Font("arial",Font.BOLD,15));
        exit.setBounds(360,510,160,30);
        exit.addActionListener(this);
        i.add(exit);

    }

    public void actionPerformed(ActionEvent e){
//        String ID=R.getString("Formno");
        if(e.getSource() == deposite){
            super.setVisible(false);
            new Deposite(ID).setVisible(true);
        } else if (e.getSource() == exit) {
            super.setVisible(false);
            new Window().setVisible(true);
        }
       else if (e.getSource()== withdrawal) {
           super.setVisible(false);
           new Withdrawal(ID).setVisible(true);
        }else if (e.getSource()== fastCash) {
            super.setVisible(false);
            new Fastcash(ID).setVisible(true);
        }
        else if (e.getSource()== balenceEnquire) {
            super.setVisible(false);
            new BalenceEnquire(ID).setVisible(true);
        }

        else if (e.getSource()== changePassword) {
            super.setVisible(false);
            new ChangePass(ID).setVisible(true);
        }
        else if (e.getSource()== miniStatement) {
            super.setVisible(false);
            new Statement(ID).setVisible(true);
        }

    }
}
