/*	This class records all employees for J. Jacks Tire Service
 *
 *
 *
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

 public class EmployeeList{
	//private member variables
	private Employee headEmp;
	Scanner input = new Scanner(System.in);

	//constructor
	public EmployeeList(){
		headEmp = null;
	}

	public boolean isEmpty(){
		return headEmp == null;
	}//end isEmpty method

	public void addEmployee(String fName, String lName){
		/*	Description: Add a new employee to list by prompts to user
		 *	Precondition: Employee list must have been initialized, first name and last name provided
		 *	Postcondition: Employee will be added
		 */
		Employee newEmployee = new Employee();
		newEmployee.setFirstName(fName);
		newEmployee.setLastName(lName);
		if(isEmpty()){
		 	//list is empty
			headEmp = newEmployee;
		}
		else{
			//list is not empty
			Employee cur = new Employee();
			//find end of list and add new employee
			cur = headEmp;
			while(cur.nextEmployee != null){
				cur = cur.nextEmployee;
			}
			//cur.next is now null, add employee
			cur.nextEmployee = newEmployee;
			//prompt for additional information
			System.out.println("Enter employee's middle name: ");
			newEmployee.setMiddleName(input.nextLine());
			System.out.println("Enter employee's phone number, 9 digits long, integers only:");
			newEmployee.setPhone(input.nextLine());
			System.out.println("Enter employee's email address:");
			newEmployee.setEmail(input.nextLine());
			System.out.println("Enter employee's address, including street, city, zip and state: ");
			newEmployee.setAddress(input.nextLine());
			System.out.println("Enter employee's SSN, integers only, no spaces or dashes: ");
			newEmployee.setSsn(input.nextLine());
			System.out.println("Enter employee's position title: " );
			newEmployee.setPositionTitle(input.nextLine());
			System.out.println("Enter employee's rate of pay:");
			newEmployee.setPayrate(input.nextDouble());

		}

	}//end addEmployee method

	public void addEmployee(String fName, String mName, String lName, String sss, String phone, String address, String email,
		String title, double pay){
			/*
			 *
			 */

		Employee newEmployee = new Employee();
		newEmployee.setFirstName(fName);
		newEmployee.setLastName(lName);
		newEmployee.setMiddleName(mName);
		newEmployee.setSsn(sss);
		newEmployee.setPhone(phone);
		newEmployee.setAddress(address);
		newEmployee.setEmail(email);
		newEmployee.setPositionTitle(title);
		newEmployee.setPayrate(pay);
		if(isEmpty()){
		 	//list is empty
			headEmp = newEmployee;
		}
		else{
			//list is not empty
			Employee cur = new Employee();
			//find end of list and add new employee
			cur = headEmp;
			while(cur.nextEmployee != null){
				cur = cur.nextEmployee;
			}
			//cur.next is now null, add employee
			cur.nextEmployee = newEmployee;
		}
	}//end addEmployee method

	public void deleteEmployee(String fName, String lName){
		/*	Description: Delete an employee
		 *	Precondition: Provide first and last name of employee, assuming no duplicates
		 *	Postcondition: Employee will be deleted if found
		 */
		 Employee cur = headEmp;
		 Employee prev = headEmp;
		 if(isEmpty()){
		 	//list is empty
		 	System.out.println("Error in delete: List is empty, cannot delete employee");
		 }
		 else{
		 	//list is not empty, search for employee
		 	//special case, head is employee node to be deleted
		 	if(cur.getFirstName().toLowerCase().compareTo(fName.toLowerCase()) == 0){
		 		if(cur.getLastName().toLowerCase().compareTo(lName.toLowerCase()) == 0){
		 			//delete head
		 			headEmp = headEmp.nextEmployee;
		 			cur = null;
		 		}
		 	}
		 	else{
		 		while(cur != null){
			 		if(cur.getFirstName().toLowerCase().compareTo(fName.toLowerCase()) == 0){
			 			if(cur.getLastName().toLowerCase().compareTo(lName.toLowerCase()) == 0){
			 				//match found, delete employee pointed to by cur
			 				prev.nextEmployee = cur.nextEmployee;
			 				cur = null;
			 			}
			 		}
			 		//match not found yet, look at next employee
			 		prev = cur;
			 		cur = cur.nextEmployee;
		 		}
		 	}
		 }
	}//end deleteEmployee method

	public void displayAllIncomeTaxInfo(){
		/*
		 *
		 *
		 */
		Employee cur = headEmp;
		if(!isEmpty()){
			//list is not empty, display information
			while(cur != null){
				System.out.println(cur.displayIncomeTaxInfo());
				System.out.println();
				cur = cur.nextEmployee;
			}
		}

	}//end displayAllEmployees method

	public void saveEmployeeList(){
    	/*	Description: Saves the current list to a file called EmployeeSavedList.txt
    	 *	Precondition: List must not be empty
    	 *	Postcondition:	List will be saved to a file, each parameter will be separated by a comma
    	 */
     	 try{
		     PrintWriter writer = new PrintWriter("EmployeeSavedList.txt","UTF-8");
		     Employee cur = headEmp;
		     while(cur != null){
			     writer.println(cur.getFirstName() + "," + cur.getMiddleName() + "," + cur.getLastName() +
			     	"," + cur.getSsn() + "," + cur.getPhone() + "," + cur.getAddress() + "," + cur.getEmail() + "," +
			     	cur.getPositionTitle() + "," + cur.getPayrate());
			     cur = cur.nextEmployee;
		     }
		     writer.close();
	     }
      	catch(IOException e){
      		System.out.println("Error: Could not save employee data");
      	}
    }//end saveList method

	public void loadList(){
    	/*	Description: Load a list saved to a text file
    	 *	Precondition: File must exist in same folder
    	 *	Postcondition:	List in file will be saved to a list to be examined
    	 */
    	File file = new File("EmployeeSavedList.txt");
    	try {
	        Scanner sc = new Scanner(file);
	        while (sc.hasNextLine()) {
	        	//file has data within it
	            String st = sc.nextLine();

	            String temp[] = st.split(","); //save line of data to a string array
	            String fName = temp[0];
	            String mName= temp[1];
	            String lName = temp[2];
	            String ssn = temp[3];
	            String phone = temp[4];
	            String address = temp[5];
	            String email = temp[6];
	            String title = temp[7];
	            double pay = Double.parseDouble(temp[8]);
	            addEmployee(fName,mName,lName,ssn,phone,address,email,title,pay);	//add to new list
	        }
	        sc.close();	//close file
	    }
    	catch (FileNotFoundException e) {
    		//file does not exist
       		e.printStackTrace();
    	}
    }//end loadList method



 }//end class