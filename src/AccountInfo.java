import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AccountInfo extends JFrame implements ActionListener {
    Random ran= new Random();
    JRadioButton T1, T2, T3, T4, T5;
    JCheckBox C1,C2,C3,C4,C5,C6;
    JButton Finish;
    long cardno= Math.abs((ran.nextLong() %900000000L) +3773889500000000L);
    long pinno= Math.abs((ran.nextLong() %9000L) +1000L);
    String formno;
    AccountInfo(String formno){
        this.formno=formno;
        super.setLayout(null);
        super.setTitle("Registration form");
        super.setSize(1200,1200);
        super.setLocation(200,50);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading= new JLabel("Additional details..");
        heading.setFont(new Font("arial",Font.BOLD,38));
        heading.setBounds(200,30,500,40);
        add(heading);
        JLabel text= new JLabel("Page no. 2 | Additional Details");
        text.setFont(new Font("arial",Font.BOLD,18));
        text.setBounds(120,90,450,30);
        add(text);
        JLabel Formno= new JLabel("Form Number : "+formno);
        Formno.setFont(new Font("arial",Font.BOLD,18));
        Formno.setBounds(600,90,200,30);
        add(Formno);
        JLabel Subheading= new JLabel("Account Type : ");
        Subheading.setFont(new Font("arial",Font.BOLD,24));
        Subheading.setBounds(100,130,500,40);
        add(Subheading);
        T1= new JRadioButton("Current Account");
        T1.setFont(new Font("arial",Font.BOLD,18));
        T1.setBounds(150,180,300,20);
        add(T1);
        T2= new JRadioButton("Saving Account");
        T2.setFont(new Font("arial",Font.BOLD,18));
        T2.setBounds(550,180,300,20);
        add(T2);
        T3= new JRadioButton("Fixed Deposit Account");
        T3.setFont(new Font("arial",Font.BOLD,18));
        T3.setBounds(150,240,300,20);
        add(T3);
        T4= new JRadioButton("Recurring Deposit Account");
        T4.setFont(new Font("arial",Font.BOLD,18));
        T4.setBounds(550,240,300,20);
        add(T4);
        T5= new JRadioButton("Salary Account");
        T5.setFont(new Font("arial",Font.BOLD,18));
        T5.setBounds(150,290,300,20);
        add(T5);
        ButtonGroup manageacctypestatus= new ButtonGroup();
        manageacctypestatus.add(T1);
        manageacctypestatus.add(T2);
        manageacctypestatus.add(T3);
        manageacctypestatus.add(T4);
        manageacctypestatus.add(T5);
        JLabel cardnoex = new JLabel("Card Number : XXXX XXXX XXXX 8787");
        cardnoex.setFont(new Font("arial",Font.BOLD,28));
        cardnoex.setBounds(100,540,550,30);
        add(cardnoex);
        JLabel cardnonotation = new JLabel("This is a example of card number.");
//        cardnonotation.setBackground(Color.red);
        cardnonotation.setFont(new Font("arial",Font.BOLD,10));
        cardnonotation.setBounds(130,580,500,10);
        add(cardnonotation);
        JLabel pinnoex = new JLabel("PIN Number : 2024 ");
        pinnoex.setFont(new Font("arial",Font.BOLD,28));
        pinnoex.setBounds(100,600,500,20);
        add(pinnoex);
        JLabel pinnonotation = new JLabel("This is a example of pin number.");
//        pinnonotation.setBackground(Color.red);
        pinnonotation.setFont(new Font("arial",Font.BOLD,10));
        pinnonotation.setBounds(130,630,500,10);
        add(pinnonotation);
        JLabel Subheading2= new JLabel("Additional Benefits : ");
        Subheading2.setFont(new Font("arial",Font.BOLD,24));
        Subheading2.setBounds(100,360,500,40);
        add(Subheading2);
        C1= new JCheckBox("Internet Banking");
        C1.setFont(new Font("arial",Font.BOLD,18));
        C1.setBounds(150, 420,200,20);
        add(C1);
        C2= new JCheckBox("Online payment");
        C2.setFont(new Font("arial",Font.BOLD,18));
        C2.setBounds(550, 420,200,20);
        add(C2);
        C3= new JCheckBox("E-Statements");
        C3.setFont(new Font("arial",Font.BOLD,18));
        C3.setBounds(150, 460,200,20);
        add(C3);
        C4= new JCheckBox("Passbook");
        C4.setFont(new Font("arial",Font.BOLD,18));
        C4.setBounds(550, 460,200,20);
        add(C4);
        C5= new JCheckBox("Credit Card");
        C5.setFont(new Font("arial",Font.BOLD,18));
        C5.setBounds(150, 500,200,20);
        add(C5);
        C6= new JCheckBox("E-mail and SMS Alerts");
        C6.setFont(new Font("arial",Font.BOLD,18));
        C6.setBounds(550, 500,200,20);
        add(C6);
        Finish = new JButton("Finish");
        Finish.setFont(new Font("Raleway",Font.BOLD,22));
        Finish.setBounds(600,660,150, 30);
        Finish.addActionListener(this);
        add(Finish);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Formno= formno;
        String AccountType=null;
        if(T1.isSelected()){
            AccountType="Current Account";
        } else if (T2.isSelected()) {
            AccountType="Saving Account";
        }else if (T3.isSelected()) {
            AccountType="Fixed Deposit Account";
        }else if (T4.isSelected()) {
            AccountType="Recurring Deposit Account";
        }else if (T5.isSelected()) {
            AccountType="Salary Account";
        }
        String AdditionalBenefits=" ";
        if(C1.isSelected()){
            AdditionalBenefits += " Internet Banking";
        } else if (C2.isSelected()) {
            AdditionalBenefits +=" Online payment";
        }else if (C3.isSelected()) {
            AdditionalBenefits +=" E-Statements";
        }else if (C4.isSelected()) {
            AdditionalBenefits +=" Passbook";
        }else if (C5.isSelected()) {
            AdditionalBenefits +=" Credit Card";
        }else if (C6.isSelected()) {
            AdditionalBenefits +=" E-mail and SMS Alerts";
        }
        String Cardno=""+cardno;
        String Pinno=""+ pinno;

        try{
            if(AccountType.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type must be selected");
            }else{
                conn con = new conn();
                String q="insert into additionalAccDetail values('"+Formno+"','"+AccountType+"','"+AdditionalBenefits+"')";
                System.out.println(AdditionalBenefits);
                String query="insert into accounts values('"+Formno+"','"+Cardno+"','"+Pinno+"')";
                con.s.executeUpdate(q);con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Your Card Number :-"+Cardno+"\n " +
                        "PIN  :-"+Pinno);super.setVisible(false);new Window().setVisible(true);
            }
        }catch (Exception err){
            System.out.println(err);
        }
    }

}
