/*	Description: This class represents that basic data to be saved for a person
 *		The person class should be extended by the employee class and customer class
 *		to add aditional details pertaining to either child class
 *	Note: Extra error checking has not been added, such as verifying that phone contains only numbers
 *		and that email follows proper email formate
 *
 *	Variable Descriptions:
 *		firstName:String = store the first name of person
 *		lastName:String = store the last name of person
 *		phone: String = store the ten digit phone number of person
 *		email:String = store the email address of person
 *		address:String = store the mailing address of person, including street, city, state, and zipcode
 */

//package TireCompany;

public class Person{
	//private member variables
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;


	//default constructor
	public Person(){
	}

	//methods
	public void setFirstName(String name){
		//Description: Set the first name of person
		//Precondition: First name must be a string
		//Postcondition: First name will be set
		this.firstName = name;
	}//end setFirstName method

	public String getFirstName(){
		//Description: Return the first name of customer
		//Precondition: First name must have been set previously
		//Postcondition: If first name was set then it will be returned
		return this.firstName;
	}//end getFirstName method

	public void setLastName(String name){
		//Description: Set the last name of person
		//Precondition: Last name must be a string
		//Postcondition: Last name will be set
		this.lastName = name;
	}//end setLastName method

	public String getLastName(){
		//Description: Return the last name of person
		//Precondition: Last name must have been set previously
		//Postcondition: If last name was set then it will be returned
		return this.lastName;
	}//end getLastName method

	public void setPhone(String phone){
		/*	Description: set a phone number of length ten, including 3 chars for area code
		 *		and 7 chars for phone number
		 *	Precondition: Provide a string of length ten representing phone number
		 *	Postcondition: If length ten then phone will be set, otherwise error message will be returned
		 */
		 if(phone.length() == 10){
		 	this.phone = phone;
		 }
		 else{
		 	System.out.println("Error: Phone number was not set. It must include area code and be in the format:" +
		 		" 1234567890");
		 }
	}//end setPhone method

	public String getPhone(){
		//Description: Return the phone of person
		//Precondition: Phone must have been set previously
		//Postcondition: If phone was set then it will be returned
		return this.phone;
	}//end getPhone method

	public void setEmail(String em){
		//Description: Set the email address of person
		//Precondition: Email must be a string
		//Postcondition: Email will be set
		this.email = em;
	}//end setEmail method

	public String getEmail(){
		//Description: Return the email of person
		//Precondition: Email must have been set previously
		//Postcondition: If email was set then it will be returned
		return this.email;
	}//end getEmail method

	public void setAddress(String addr){
		//Description: Set the address of person
		//Precondition: Address must be a string
		//Postcondition: Address will be set
		this.address = addr;
	}//end setAddress method

	public String getAddress(){
		//Description: Return the address of person
		//Precondition: Address must have been set previously
		//Postcondition: If address was set then it will be returned
		return this.address;
	}//end getAddress method

}//end class
