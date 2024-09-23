import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Window extends JFrame implements ActionListener{
    JButton loginButton,signupButton,resetButton;
    JTextField cardTextFeild;
    JPasswordField pinTextFeild;
    Window(){
//        setting widow title
        super.setTitle("Bank Management System");
        super.setSize(800,700);
        super.setLayout(null);
        super.setVisible(true);
//        inserting image at the top
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l= new JLabel(i3);
        l.setBounds(70,20,100,100);
        add(l);

//        inserting heading
        JLabel text= new JLabel("Welcome to ATM...");
        text.setFont(new Font("arial",Font.BOLD,48));
        text.setBounds(250,20,450,100);
        add(text);
//          inserting textfeilds
        JLabel cardno= new JLabel("Card No.");
        cardno.setFont(new Font("arial",Font.BOLD,38));
        cardno.setBounds(150,60,200,300);
        add(cardno);

        cardTextFeild= new JTextField();
        cardTextFeild.setFont(new Font("arial",Font.BOLD,22));
        cardTextFeild.setBounds(350,180,250,40);
        add(cardTextFeild);

        JLabel pin= new JLabel("PIN");
        pin.setFont(new Font("arial",Font.BOLD,38));
        pin.setBounds(150,100,150,400);
        add(pin);

        pinTextFeild= new JPasswordField();
        pinTextFeild.setFont(new Font("arial",Font.BOLD,22));
        pinTextFeild.setBounds(350,280,250,40);
        add(pinTextFeild);

//        inserting buttons
        loginButton=new JButton("log in");
        loginButton.setFont(new Font("arial",Font.BOLD,28));
        loginButton.setBounds(200,380,150,40);
        loginButton.addActionListener(this);
        add(loginButton);
        signupButton=new JButton("Sign up");
        signupButton.setFont(new Font("arial",Font.BOLD,28));
        signupButton.setBounds(500,380,150,40);
        signupButton.addActionListener(this);
        add(signupButton);
        resetButton=new JButton("Reset");
        resetButton.setFont(new Font("arial",Font.BOLD,28));
        resetButton.setBackground(Color.BLUE);
        resetButton.addActionListener(this);
        resetButton.setBounds(350,480,200,40);
        add(resetButton);

        super.getContentPane().setBackground(Color.cyan);
//        window location on the screen
        super.setLocation(200,50);
//     for auto terminating program when ever the cross symbol is clicked.
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == resetButton){
            System.out.println("clicked on reset button...");
            cardTextFeild.setText("");
            pinTextFeild.setText("");
        } else if (e.getSource()== loginButton) {
            System.out.println("clicked on log in button...");
            String CardNo= cardTextFeild.getText();
            String PinNo= pinTextFeild.getText();
            conn c = new conn();
            String q= "select * from accounts where Cardno='"+CardNo+"' and Pinno='"+PinNo+"'";
            try {

                ResultSet R= c.s.executeQuery(q);
                System.out.println(R);
                if(R.next()){
                    String ID=R.getString("Formno");
                    super.setVisible(false);
                    new homescreen(ID).setVisible(true);
                    System.out.println(ID);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Details");
                    cardTextFeild.setText("");
                    pinTextFeild.setText("");
                }


            } catch (Exception ex) {

                System.out.println(ex);
            }




        } else if (e.getSource()== signupButton) {
            System.out.println("clicked on sign up button");

            setVisible(false);
            new Registration("").setVisible(true);

        }
    }
}
