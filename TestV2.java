/*	This is Test.java Version 2 which includes employee update information
 *
 */

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TestV2{

	public static void main(String args[]) throws Exception{
		boolean go = true;
	 	ImageIcon icon = new ImageIcon("tire.png");
	 	Scanner input = new Scanner(System.in);

	   	while(go){
		   	String[] options = new String[] {"Add Item", "Add User", "Add Employee", "Display Employee Info", "Display Item List"};
		    int response = JOptionPane.showOptionDialog(null, "Select a Command", "Think of a Title",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        icon, options, options[0]);
		    if(response==0)
		      	addItem();
		    else if(response==1)
		      	go=false;
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
	     //Others to be implemented
	}//end main method

 	public static void addItem(){//add item to list
	   List item = new List();
	   item.loadList();

	   boolean addAnother=true;

	   while(addAnother){
		   JTextField int1 = new JTextField(5); //number in stock
		   JTextField int2 = new JTextField(5);	//minimum allowed in inventory
		   JTextField input = new JTextField(20); //item name

		   ImageIcon icon = new ImageIcon("tire.png");

		   JPanel myPanel = new JPanel();
		      myPanel.add(Box.createHorizontalStrut(30)); // a spacer
		      myPanel.add(new JLabel("Item Name:"));
		      myPanel.add(input);
		      myPanel.add(new JLabel("Stock Amount:"));
		      myPanel.add(int1);
		      myPanel.add(Box.createVerticalGlue()); // a spacer
		      myPanel.add(new JLabel("Min Inv Amount till Reorder:"));
		      myPanel.add(int2);
		   JOptionPane.showMessageDialog(null,myPanel,"Add New Item",JOptionPane.PLAIN_MESSAGE,icon);

		   int stockAmount = Integer.parseInt(int1.getText());
		   int minAmount = Integer.parseInt(int2.getText());
		   item.itemExists(input.getText(),stockAmount,minAmount);
		   if(JOptionPane.showConfirmDialog(null,"Enter another item?", "Add Another",
		        	JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		     	addAnother=true;
		   else
				addAnother=false;
	   }
	   item.sortList();
	   item.saveList();
	}//end addItem method

	public static void addEmployee(){//add item to list
	   EmployeeList list = new EmployeeList();
	   list.loadList();

	   boolean addAnother=true;

	   while(addAnother){
		   JTextField fName = new JTextField(15);
		   JTextField mName = new JTextField(15);
		   JTextField lName = new JTextField(15);
		   JTextField ssn = new JTextField(9);
		   JTextField phone = new JTextField(10);
		   JTextField address = new JTextField(25);
		   JTextField email = new JTextField(20);
		   JTextField title = new JTextField(18);
		   JTextField pay = new JTextField(6);

		   ImageIcon icon = new ImageIcon("tire.png");

		   JPanel myPanel = new JPanel();
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
		      myPanel.add(new JLabel("Position Title:"));
		      myPanel.add(title);
		      myPanel.add(new JLabel("Hourly Rate of Pay:"));
		      myPanel.add(pay);
		   JOptionPane.showMessageDialog(null,myPanel,"Add New Employee",JOptionPane.PLAIN_MESSAGE,icon);

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
		EmployeeList list = new EmployeeList();
		try{
			list.loadList();
			list.displayAllIncomeTaxInfo();
		}
		catch(Exception ex){
			System.out.println("Exception on displayEmployee method: File not found");
		}

	}//end displayEmployee method

	public static void disList(){
		//sorts and displays list
		List item = new List();
		item.sortList();
		item.loadList();
		item.displayList();
 	}//end disList method


}//end class
