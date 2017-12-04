 Changes-By-Guerrero
/*	This is Test.java Version 2 which includes employee update information

 *
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TestV2{

 Changes-By-Guerrero
 public static void main(String args[]) throws Exception{
  Command login = new Command();
  login.login();
   boolean go = true;
   ImageIcon icon = new ImageIcon("tire.png");
   Scanner input = new Scanner(System.in);

     while(go){
       String[] options = new String[] {"Add Item", "Add User", "Add Employee", "Display Employee Info", "Display Item List","Quit"};
      int response = JOptionPane.showOptionDialog(null, "Select a Command", "Prototype",
          JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
          icon, options, options[0]);
      if(response==0)
         addItem();
      else if(response==1)
         JOptionPane.showMessageDialog(null,"To be implemented","Protoype",JOptionPane.PLAIN_MESSAGE);
      else if(response==2)
       //add new employee to list
    addEmployee();
      else if (response==3)
         displayEmployee();
      else if (response==4)
         disList();
      else
         go=false;
    }
    System.out.println("To be implemented");
    input.close();
      //Others to be implemented
 }//end main method

  public static void addItem(){//add item to list
    Command cmd =new Command();
    cmd.commandList();
 }//end addItem method

 public static void addEmployee(){//add item to list
    EmployeeList list = new EmployeeList();
    list.loadList();

    boolean addAnother=true;

    while(addAnother){
     JTextField fName = new JTextField(15);
     JTextField mName = new JTextField(15);
     JTextField lName = new JTextField(15);
     JTextField ssn = new JTextField(15);
     JTextField phone = new JTextField(15);
     JTextField address = new JTextField(15);
     JTextField email = new JTextField(15);
     JTextField title = new JTextField(15);
     JTextField pay = new JTextField(15);

     ImageIcon icon = new ImageIcon("tire.png");

     JPanel p = new JPanel();
     JPanel myPanel = new JPanel(new GridLayout(3,3));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("First Name:"));
        myPanel.add(fName);
        myPanel.add(new JLabel("Middle Name:"));
        myPanel.add(mName);
        myPanel.add(new JLabel("Last Name:"));
        myPanel.add(lName);
        //************need to move the rest to new row*******************************
        myPanel.add(Box.createVerticalGlue()); // a spacer
        myPanel.add(new JLabel("SSN:"));
        myPanel.add(ssn);
        myPanel.add(new JLabel("Phone Number:"));
        myPanel.add(phone);
        myPanel.add(new JLabel("Address:"));
        myPanel.add(address);
        myPanel.add(new JLabel("Email:"));
        myPanel.add(email);
        //************need to move the rest to new row*******************************
        myPanel.add(Box.createVerticalGlue()); // a spacer
        myPanel.add(new JLabel("Position Title:"));
        myPanel.add(title);
        myPanel.add(new JLabel("Hourly Rate of Pay:"));
        myPanel.add(pay);
        p.add(myPanel);
     JOptionPane.showMessageDialog(null,p,"Add New Employee",JOptionPane.PLAIN_MESSAGE,icon);

     double payRate = Double.parseDouble(pay.getText());
     list.addEmployee(fName.getText(),mName.getText(),lName.getText(),ssn.getText(),phone.getText(),address.getText(),
       email.getText(),title.getText(), payRate);
     if(JOptionPane.showConfirmDialog(null,"Enter another employee?", "Add Another",
           JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        addAnother=true;
     else
    addAnother=false;
    }

    list.saveEmployeeList();
 }//end addItem method

 public static void displayEmployee() throws Exception{
   UIManager.put("OptionPane.okButtonText","Ok");
  EmployeeList list = new EmployeeList();
  try{
   list.loadList();
   JOptionPane.showMessageDialog(null,list.displayAllIncomeTaxInfo(),"Protoype",JOptionPane.PLAIN_MESSAGE);
  }
  catch(Exception ex){
   System.out.println("Exception on displayEmployee method: File not found");
  }

 }//end displayEmployee method

 public static void disList(){
  //sorts and displays list
   List item = new List();
   UIManager.put("OptionPane.okButtonText","Ok");
   item.loadList();
   JOptionPane.showMessageDialog(null,item.displayList(),"Protoype",JOptionPane.PLAIN_MESSAGE);
  }//end disList method
}//end class
