/*	Description: This class creates and stores information for customers of the company
 *		J. Jacks Tire Service. Information stored include first name, last name, customer number,
 *		vehicle(s) owned that have been worked on by company.
 *
 *	Variable Descriptions:
 *		customerNum: int = stores a predetermined customer number
 *
 */
import java.util.Scanner;

 public class Customer extends Person{
 	//private member variables
 	private int customerNum;
	private Vehicle headVehicle;	//head pointer for list of vehicles owned by customer

 	//constructor
 	public Customer(){
 		super();
 		this.customerNum = 0;
 		headVehicle = null;
 		headVehicle.nextVehicle = null;
 	}

 	//methods
 	public void setCustomerNum(int newNum){
 		this.customerNum = newNum;
 	}

 	public int getCustomerNum(){
 		return this.customerNum;
 	}

 	//add vehicle information
	public void addVehicle(){
		/*	Description: Add a vehicle owned by customer to customer object
		 *	Precondition: Customer must be created
		 *	Postcondition: New default vehicle will be created
		 */
		 Scanner input = new Scanner(System.in);
		 Boolean done = false;
		 Vehicle newVehicle = new Vehicle();
		 //prompt for vehicle information
		 updateVehicle(newVehicle);

		 if(headVehicle == null){
		 	//no vehicles owned by customer have been saved yet
		 	System.out.println("This is the first vehicle to be saved to customer's account.");
		 	headVehicle = newVehicle;
		 }
		 else{
		 	//a vehicle already exists, add to end of list
		 	Vehicle curr = headVehicle;
		 	//locate end of list
		 	while(curr.nextVehicle != null){
		 		curr = curr.nextVehicle;
		 	}
		 	//should be at end of list now
		 	curr.nextVehicle = newVehicle;
		 }

	}//end addVehicle method

	//update vehicle information
	public void updateVehicle(Vehicle newVehicle){

		Scanner input = new Scanner(System.in);
		Boolean done = false;
		String update;

		while(!done){
		 	System.out.println("Enter (1)make, (2)model, (3)year, (4)tire size, (5)date of last tire rotation, \n" +
		 		"(6)date of last tire balance, (7)date of last tire alignment, (8)mileage, (9)EXIT" );
		 	int choice = input.nextInt();
		 	if(choice>=1 && choice < 9){
		 		//chosen to input data
		 		if(choice == 1){
		 			//enter make
					System.out.println("Enter make:");
					update = input.nextLine();
					newVehicle.setMake(update);
		 		}
		 		else if(choice == 2){
		 			//enter model
					System.out.println("Enter model:");
					update = input.nextLine();
					newVehicle.setModel(update);
		 		}
		 		else if(choice == 3){
		 			//enter year
					System.out.println("Enter year:");
					update = input.nextLine();
					newVehicle.setYear(update);
		 		}
		 		else if(choice == 4){
		 			//enter tire size
					System.out.println("Enter tire size:");
					update = input.nextLine();
					newVehicle.setTireSize(update);
		 		}
		 		else if(choice == 5){
		 			//enter date of last tire rotation
					System.out.println("Enter date of last tire rotation service:");
					update = input.nextLine();
					newVehicle.setRotationDate(update);
		 		}
		 		else if(choice == 6){
		 			//enter date of last tire balance
					System.out.println("Enter date of last tire balance service:");
					update = input.nextLine();
					newVehicle.setBalancingDate(update);
		 		}
		 		else if(choice == 7){
		 			//enter date of last tire alignment
					System.out.println("Enter date of last tire alignment service:");
					update = input.nextLine();
					newVehicle.setAlignmentDate(update);
		 		}
		 		else{
		 			//enter mileage
					System.out.println("Enter make:");
					update = input.nextLine();
					newVehicle.setMileage(update);
		 		}
		 	}
		 	else if(choice == 9){
		 		//chosen to stop data input
		 		done = true;
		 	}
		 	else{
		 		//incorrect choice
		 		System.out.println("Incorrect entry. Please try again.");
		 	}
		 }

	}//end updateVehicle method

 	//get vehicle information
	public void displayAllVehicles(){
		/*	Description: Display all vehicles owned by customer
		 *	Precondition: Customer must be instantiated
		 *	Postcondition: All vehicles will be displayed if not empty
		 */

		 if(headVehicle != null){
		 	//customer has atleast one vehicle to print
		 	int i = 1;
		 	Vehicle curVehicle = headVehicle;
		 	while(curVehicle != null){
		 		System.out.println("Vehicle " + i + ": \n\tMake: " + curVehicle.getMake() +
			 		"\n\tModel: " + curVehicle.getModel() + "\n\tYear: " + curVehicle.getYear() +
			 		"\n\tTire Size: " + curVehicle.getTireSize() + "\n\tLast Rotation Date: " +
			 		curVehicle.getRotationDate() + "\n\tLast Balancing Date: " +
			 		curVehicle.getBalancingDate() + "\n\tLast Alignment Date: " + curVehicle.getAlignmentDate() +
			 		"\n\tMileage: " + curVehicle.getMileage());
			 	System.out.println();
			 	curVehicle = curVehicle.nextVehicle;
			 	i++;
		 	}
		 }
		 else{
		 	//no vehicles saved yet
		 	System.out.println("Customer has no vehicles currently saved.");
		 }

	}//end displayAllVehicles method
 }//end class