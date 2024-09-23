//import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalInfo extends JFrame implements ActionListener {
    public String ReligionVal [] ={"Hindu","Muslim","Christian","Sikh","Buddhism","Jain"};
    public String CategoryVal [] ={"General","OBC","SC","NT","Others"};
    public String IncomeVal [] ={"less than 10k","less than 30k","less than 50k","less than 100k","more than 100k"};
    public String EducationVal [] ={"10th pass","12th pass","Graduaction","Post-Graduaction","PhD"};
    public String OcupationVal [] ={"Service","Self employed","emplyee","Bussiness","Others"};
    JComboBox ReligionFeild, CategoryFeild, IncomeFeild, EducationFeild, OcupationFeild ;
    JRadioButton yes,no;
    JTextField PANTextFeild,AdhaarTextFeild;
    JButton NextPage;
    String formno;
    Font F=new Font("Railway",Font.ITALIC,18);
    AdditionalInfo(String formno){
        this.formno=formno;
        super.setTitle("Registration form");
        super.setSize(1200,1200);
        super.setLocation(200,50);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(null);
//        adding content of the form...
        JLabel heading= new JLabel("Additional details..");
        heading.setFont(new Font("arial",Font.BOLD,38));
        heading.setBounds(200,30,500,40);
        JLabel text= new JLabel("Page no. 2 | Additional Details");
        text.setFont(new Font("arial",Font.BOLD,18));
        text.setBounds(120,90,500,30);
        add(text);
        JLabel Religion= new JLabel("Religion: ");
        Religion.setFont(new Font("arial",Font.BOLD,22));
        Religion.setBounds(100,140,100,30);
        add(Religion);
        ReligionFeild= new JComboBox(ReligionVal);
        ReligionFeild.setFont(F);
        ReligionFeild.setBounds(330,140,250,30);
        add(ReligionFeild);
        JLabel Category= new JLabel("Category : ");
        Category.setFont(new Font("arial",Font.BOLD,22));
        Category.setBounds(100,200,200,30);
        add(Category);
        CategoryFeild= new JComboBox(CategoryVal);
        CategoryFeild.setFont(F);
        CategoryFeild.setBounds(330,200,250,30);
        add(CategoryFeild);
        JLabel Income= new JLabel("Income : ");
        Income.setFont(new Font("arial",Font.BOLD,22));
        Income.setBounds(100,260,200,30);
        add(Income);
        IncomeFeild= new JComboBox(IncomeVal);
        IncomeFeild.setFont(F);
        IncomeFeild.setBounds(330,260,200,30);
        add(IncomeFeild);
        JLabel Education= new JLabel("Educational Qualification : ");
        Education.setFont(new Font("arial",Font.BOLD,22));
        Education.setBounds(100,320,200,30);
        add(Education);
        EducationFeild= new JComboBox(EducationVal);
        EducationFeild.setFont(F);
        EducationFeild.setBounds(330,320,200,30);
        add(EducationFeild);
        JLabel Ocupation= new JLabel("Ocupation : ");
        Ocupation.setFont(new Font("arial",Font.BOLD,22));
        Ocupation.setBounds(100,380,200,30);
        add(Ocupation);
        OcupationFeild=new JComboBox(OcupationVal);
        OcupationFeild.setFont(F);
        OcupationFeild.setBounds(330,380,120,30);
        add(OcupationFeild);
        JLabel PAN= new JLabel("PAN Number : ");
        PAN.setFont(new Font("arial",Font.BOLD,22));
        PAN.setBounds(100,440,200,30);
        add(PAN);
        PANTextFeild= new JTextField();
        PANTextFeild.setFont(F);
        PANTextFeild.setBounds(330,440,200,30);
        add(PANTextFeild);
        JLabel Adhaar= new JLabel("Adhaar Number : ");
        Adhaar.setFont(new Font("arial",Font.BOLD,22));
        Adhaar.setBounds(100,500,200,30);
        add(Adhaar);
        AdhaarTextFeild= new JTextField();
        AdhaarTextFeild.setFont(F);
        AdhaarTextFeild.setBounds(330,500,200,30);
        add(AdhaarTextFeild);
        JLabel Senior= new JLabel("Senior Citizen: ");
        Senior.setFont(new Font("arial",Font.BOLD,22));
        Senior.setBounds(100,560,200,30);
        add(Senior);
        yes= new JRadioButton("Yes");
        yes.setFont(F);
        yes.setBounds(330,560,100,30);
        add(yes);
        no= new JRadioButton("No");
        no.setFont(F);
        no.setBounds(440,560,100,30);
        add(no);
        ButtonGroup marrageSeniorityStatus=new ButtonGroup();
        marrageSeniorityStatus.add(yes);
        marrageSeniorityStatus.add(no);
        JLabel Existed= new JLabel("Existing Account : ");
        Existed.setFont(new Font("arial",Font.BOLD,22));
        Existed.setBounds(100,620,250,30);
        add(Existed);
        yes= new JRadioButton("Yes");
        yes.setFont(F);
        yes.setBounds(400,620,100,30);
        add(yes);
        no= new JRadioButton("No");
        no.setFont(F);
        no.setBounds(520,620,100,30);
        add(no);
        ButtonGroup marrageExistenceStatus=new ButtonGroup();
        marrageExistenceStatus.add(yes);
        marrageExistenceStatus.add(no);
        NextPage=new JButton("Next Page");
        NextPage.setFont(F);
        NextPage.setBounds(200,680,150,30);
        NextPage.setBackground(Color.GREEN);
        NextPage.addActionListener(this);
        add(NextPage);




//        heading.setHorizontalAlignment(SwingConstants.CENTER);//This is not working check why????....
        add(heading);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Formno = formno;
        String sReligionFeild = (String)ReligionFeild.getSelectedItem();
        String sCategoryFeild =(String)CategoryFeild.getSelectedItem();
        String sIncomeFeild =(String)IncomeFeild.getSelectedItem();
        String sEducationFeild =(String)EducationFeild.getSelectedItem();
        String sOcupationFeild =(String)OcupationFeild.getSelectedItem();
        String Adhaar= AdhaarTextFeild.getText();
        String PAN= PANTextFeild.getText();
        String seniorCitizen = null;
        if (yes.isSelected()){
            seniorCitizen="Yes";
        } else if (no.isSelected()){
            seniorCitizen="No";
        }
        String ExistingAccount=null;
        if (yes.isSelected()){
            ExistingAccount="Yes";
        } else if (no.isSelected()){
            ExistingAccount="No";
        }
        try {
            if(PAN.equals("")){
                JOptionPane.showConfirmDialog(null, "Name is Required.");
            }else{
                conn c= new conn();
                String q="insert into additionalinfo values('"+Formno+"','"+sReligionFeild+"','"+sCategoryFeild+"','"+sIncomeFeild+"','"+sEducationFeild+"','"+sOcupationFeild+"','"+Adhaar+"','"+PAN+"','"+seniorCitizen+"','"+ExistingAccount+"')";
                c.s.executeUpdate(q);
                super.setVisible(false);
                new AccountInfo(Formno).setVisible(true);
            }
        }catch (Exception E){
            System.out.println("fucked...0");
            System.out.println(E);
        }
    }
}
