/*	Description: This class creates a vehicle object that stores information pertaining
 *		to a vehicle owned by a customer
 *
 *
 */

 public class Vehicle{
 	//private member variables
 	private String make;
 	private String model;
 	private String year;
 	private String tireSize;	//example size is 205/55R16
 	private String lastRotationDate; //date of most recent tire rotation service
 	private String lastBalancingDate;	//date of most recent tire balancing service
 	private String lastAlignmentDate; 	//date of most recent vehicle alignment service
 	private String mileage;
 	public Vehicle nextVehicle;	//allows for a list of vehicles

 	//constructor
 	public Vehicle(){
 		this.make = "unknown";
 		this.model = "unknown";
 		this.year = "unknown";
 		this.tireSize = "unknown";
 		this.lastRotationDate = "unknown";
 		this.lastBalancingDate = "unknown";
 		this.lastAlignmentDate = "uknown";
 		this.mileage = "unknown";
 	}

 	//methods
 	public void setMake(String newMake){
 		this.make = newMake;
 	}//end setMake method
 	public String getMake(){
 		return this.make;
 	}//end getMake method

 	public void setModel(String newModel){
 		this.model = newModel;
 	}//end setModel method
 	public String getModel(){
 		return this.model;
 	}//end getModel method

 	public void setYear(String newYear){
 		this.year = newYear;
 	}//end setYear method
 	public String getYear(){
 		return this.year;
 	}//end getYear method

 	public void setTireSize(String newTireSize){
 		this.tireSize = newTireSize;
 	}//end setTireSize method
 	public String getTireSize(){
 		return this.tireSize;
 	}//end getTireSize method

 	public void setRotationDate(String newDate){
 		this.lastRotationDate = newDate;
 	}//end setRotationDate method
 	public String getRotationDate(){
 		return this.lastRotationDate;
 	}//end getRotationDate method

 	public void setBalancingDate(String newDate){
 		this.lastBalancingDate = newDate;
 	}//end setBalancingDate
 	public String getBalancingDate(){
 		return this.lastBalancingDate;
 	}//end getBalancingDate

 	public void setAlignmentDate(String newDate){
 		this.lastAlignmentDate = newDate;
 	}//end setAlignmentDate method
 	public String getAlignmentDate(){
 		return this.lastAlignmentDate;
 	}//end getAlignmentDate method

 	public void setMileage(String newMile){
 		this.mileage = newMile;
 	}//end setMileage method
 	public String getMileage(){
 		return this.mileage;
 	}//end getMileage method

 }//end class