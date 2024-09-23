import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Registration extends JFrame implements ActionListener{
    Random r=new Random();
    long Formno= Math.abs((r.nextLong() %9000L) +1000L);
    Font F = new Font("Raleway",Font.ITALIC,16);
    JTextField nameTextFeild, emailTextFeild, addressTextFeild, pincodeTextFeild, countryTextFeild,cityTextFeild;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried, otherCatagory;
    JButton nextPage;

    Registration(String m){
//creating window for registration from...
        super.setTitle("Registration form");
        super.setSize(1200,1200);
        super.setLocation(200,50);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(null);
//        adding content of the form...
        JLabel heading= new JLabel("Registration form...");
        heading.setFont(new Font("arial",Font.BOLD,38));
        heading.setBounds(200,30,500,40);
        JLabel text= new JLabel("Page no. 1 | Personal Details");
        text.setFont(new Font("arial",Font.BOLD,18));
        text.setBounds(120,90,500,30);
        add(text);
        JLabel formno=new JLabel("Form No. : "+Formno);
        formno.setFont(new Font("italic",Font.BOLD,12));
        formno.setBounds(400,60,200,30);
        add(formno);
        System.out.println(Formno);
        JLabel name= new JLabel("Name: ");
        name.setFont(new Font("arial",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        nameTextFeild= new JTextField();
        nameTextFeild.setFont(F);
        nameTextFeild.setBounds(330,140,250,30);
        add(nameTextFeild);
        JLabel DOB= new JLabel("Date of Birth : ");
        DOB.setFont(new Font("arial",Font.BOLD,22));
        DOB.setBounds(100,200,200,30);
        add(DOB);
        dateChooser= new JDateChooser();
        dateChooser.setFont(F);
        dateChooser.setBounds(330,200,250,30);
        add(dateChooser);
        JLabel Gender= new JLabel("Gender: ");
        Gender.setFont(new Font("arial",Font.BOLD,22));
        Gender.setBounds(100,260,200,30);
        add(Gender);
        male= new JRadioButton("Male");
        male.setFont(F);
        male.setBounds(330,260,100,30);
        add(male);
        female= new JRadioButton("Female");
        female.setFont(F);
        female.setBounds(440,260,100,30);
        add(female);
        other= new JRadioButton("Other");
        other.setFont(F);
        other.setBounds(550,260,100,30);
        add(other);
        ButtonGroup genderGroup= new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        JLabel email= new JLabel("E-mail : ");
        email.setFont(new Font("arial",Font.BOLD,22));
        email.setBounds(100,320,200,30);
        add(email);
        emailTextFeild= new JTextField();
        emailTextFeild.setFont(F);
        emailTextFeild.setBounds(330,320,200,30);
        add(emailTextFeild);
        JLabel maritailStatus= new JLabel("Maritail Status : ");
        maritailStatus.setFont(new Font("arial",Font.BOLD,22));
        maritailStatus.setBounds(100,380,200,30);
        add(maritailStatus);
        married= new JRadioButton("Married");
        married.setFont(F);
        married.setBounds(330,380,120,30);
        add(married);
        unmarried= new JRadioButton("Unmarried");
        unmarried.setFont(F);
        unmarried.setBounds(460,380,120,30);
        add(unmarried);
        otherCatagory= new JRadioButton("Other");
        otherCatagory.setFont(F);
        otherCatagory.setBounds(590,380,90,30);
        add(otherCatagory);
        ButtonGroup marrageStatus=new ButtonGroup();
        marrageStatus.add(married);
        marrageStatus.add(unmarried);
        marrageStatus.add(otherCatagory);
        JLabel address= new JLabel("Address : ");
        address.setFont(new Font("arial",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        addressTextFeild= new JTextField();
        addressTextFeild.setFont(F);
        addressTextFeild.setBounds(330,440,200,30);
        add(addressTextFeild);
        JLabel City= new JLabel("City : ");
        City.setFont(new Font("arial",Font.BOLD,22));
        City.setBounds(100,500,200,30);
        add(City);
        cityTextFeild= new JTextField();
        cityTextFeild.setFont(F);
        cityTextFeild.setBounds(330,500,200,30);
        add(cityTextFeild);
        JLabel Contry= new JLabel("Contry : ");
        Contry.setFont(new Font("arial",Font.BOLD,22));
        Contry.setBounds(100,560,200,30);
        add(Contry);
        countryTextFeild= new JTextField();
        countryTextFeild.setFont(F);
        countryTextFeild.setBounds(330,560,200,30);
        add(countryTextFeild);
        JLabel pincode= new JLabel("Pincode : ");
        pincode.setFont(new Font("arial",Font.BOLD,22));
        pincode.setBounds(100,620,200,30);
        add(pincode);
        pincodeTextFeild= new JTextField();
        pincodeTextFeild.setFont(F);
        pincodeTextFeild.setBounds(330,620,200,30);
        add(pincodeTextFeild);
        nextPage=new JButton("Next Page");
        nextPage.setFont(F);
        nextPage.setBounds(200,680,150,30);
        nextPage.setBackground(Color.GREEN);
        nextPage.addActionListener(this);
        add(nextPage);




//        heading.setHorizontalAlignment(SwingConstants.CENTER);//This is not working check why????....
        add(heading);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+ Formno;
        String name = nameTextFeild.getText();
        String Dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender="Male";
        } else if (female.isSelected()){
            gender="Female";
        } else if (other.isSelected()){
            gender="Other";
        }
        String email= emailTextFeild.getText();
        String marital_status=null;
        if (married.isSelected()){
            marital_status="Married";
        } else if (unmarried.isSelected()){
            marital_status="Unmarried";
        } else if (otherCatagory.isSelected()){
            marital_status="Others";
        }
        String address= addressTextFeild.getText();
        String city= cityTextFeild.getText();
        String country= countryTextFeild.getText();
        String pincode= pincodeTextFeild.getText();
        try {
            if(name.equals("")){
                JOptionPane.showConfirmDialog(null, "Name is Required.");
            }else{
                conn c= new conn();
                String q="insert into user values('"+name+"','"+Dob+"','"+gender+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+country+"','"+pincode+"','"+formno+"')";
                c.s.executeUpdate(q);
                super.setVisible(false);
                new AdditionalInfo(formno).setVisible(true);
                System.out.println(formno +" is you form number.");
                System.out.println("Redirecting to Additional info page");

            }
        }catch (Exception E){
            System.out.println("fucked...0");
            System.out.println(E);
        }
    }
}
