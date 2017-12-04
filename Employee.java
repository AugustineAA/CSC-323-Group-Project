/* Description: This class represents an employee for the company J.Jacks Tires. It extends the
 *  person class to include additional information relevant to the employee
 *
 * Variable Descriptions:
 *  middleName:String = stores middle name of employee
 *  ssn:String = stores the social security number of employee
 *  positionTitle:String = stores employee's position title
 *  payRate: double = stores employee's hourly rate of pay
 *  totalHoursCurrentYear: double = stores the cumulative of hours worked by employee for current year
 *  hoursTwoWeeks: double = stores the cumulative of hours worked by employee for two weeks - to be used
 *   when generating summary every two weeks for pay
 *
 */


//package TireCompany;

import java.util.Date;
import java.text.DateFormat;

public class Employee extends Person{
 //private member variables
 private String middleName;
 private String ssn;
 private String positionTitle;
 private double payRate;
 private double totalHoursCurrentYear;
 private double hoursTwoWeeks;
 public Employee nextEmployee;

 //constructor
 public Employee(){
  super();
  this.totalHoursCurrentYear = 0;
  this.hoursTwoWeeks = 0;
  this.payRate = 0;
  this.ssn = "unknown";
  this.middleName = "";
  this.nextEmployee = null;
 }

 //methods
 public void setMiddleName(String name){
  /* Description: Set the middle name for employee to be used for payroll
   * Precondition: Employee entity must be created and string provided
   * Postcondition: Middle name will be set
   */
  this.middleName = name;
 }//end setMiddleName method

 public String getMiddleName(){
  /* Description: Return the middle name of employee
   * Precondition: Middle name must have been set
   * Postcondition: Middle name will be returned as String
   */
  return this.middleName;
 }//end getMiddleName method

 public void setSsn(String social){
  /* Description: Sets the social security number of employee for payroll
   * Precondition: Employee must be created. Provide ssn as String of length 9.
   * Postcondition: Ssn will be set
   */
  if(social.length() == 9){
   this.ssn = social;
  }
  else{
   System.out.println("Error setting ssn for employee: Ssn must be 9 digits. Please try again.");
  }
 }//end setSsn method

 public String getSsn(){
  /* Description: Return the value of employee's ssn
   * Precondition: Ssn must have been set
   * Postcondition: Ssn will be returned
   */
  return this.ssn;
 }//end getSsn method

 public void setPositionTitle(String title){
  /* Description: Set the title of employee's position within company
   * Precondition: Provide a string of title name
   * Postcondition: Position title will be set
   */
  this.positionTitle = title;
 }//end setPositionTitle method

 public String getPositionTitle(){
  /* Description: Return the title of empoyee's position within company
   * Precondition: Title must have been set
   * Postcondition: Title will be returned
   */
  return this.positionTitle;
 }//end getPositionTitle method

 public void setPayrate(double rate){
  /* Description: Sets the hourly rate of pay for employee
   * Precondition: Provide a double value representing pay rate
   * Postcondition: Pay rate will be set
   */
  this.payRate = rate;
 }//end setPayrate method

 public double getPayrate(){
  /* Description: Return the hourly rate of pay for employee
   * Precondition: pay rate must have been set
   * Postcondition: rate of pay will be returned
   */
  return this.payRate;
 }//end getPayrate method

 public void addHoursWorked(double hours){
  /* Description: Add hours to employees total yearly hours and hours worked for two week
   *  pay period. Gets the current date and determines how to add the hours to the pay
   *  period and yearly hours. Hours added must be for hours worked same day method is
   *  called.
   * Precondition: Provide a double value for hours. Whole number represents hours, decimal
   *  part represents partial hour.
   * Postcondition: Hours will be added to both yearly hour accumulation and two week hour
   *  accumulation for pay cycle depending on date
   * Note: Does not yet keep record of all pay employee has earned, only current year and two week pay
   */
  Date currentDate = new Date();
  String dateString = DateFormat.getInstance().format(currentDate); //convert date to string
  System.out.println("Current date is " + dateString); //format for date is mm/dd/yy hh:mm am/pm
  //scan dateString for day of month
  boolean dat = false;
  int i = 0;
  char[] day = new char[2];
  char[] month = new char[2];
  while(!dat && i<dateString.length()){
   //locate first forward slash
   if(dateString.charAt(i) == '/'){
    day[0] = dateString.charAt(i+1);
    day[1] = dateString.charAt(i+2);
    dat = true;
   }
   i++;
  }
  month[0] = dateString.charAt(0);
  month[1] = dateString.charAt(1);

  /*add hours to totalHoursCurrentYear
   * if it is the 1st of the year, start count over and continue to end of year
   */

  /*add hours to hoursTwoWeeks
   check date, if 1st or 15th of month, start hoursTwoWeeks at 0 and add,
   if date between 2nd and 14th, or 16th and end of month, add to hoursTwoWeeks
  */
  if(day[0] == '0' && day[1] == '1'){
   //first day of month, determine if first day of year
   if(month[0] == 0 && month[1] == '1'){
    //first day of the year
    totalHoursCurrentYear = hours; //start overs over to current hours being added
    hoursTwoWeeks = hours;
   }
   else{
    //start hoursTwoWeeks over to current hours being added and add to totalHoursCurrentYear
    totalHoursCurrentYear += hours;
    hoursTwoWeeks = hours;
   }
  }
  else if(day[0] == '1' && day[1] == '5'){
   //15th of month
   totalHoursCurrentYear += hours;
   hoursTwoWeeks = hours;
  }
  else{
   //other day of month, add hours
   totalHoursCurrentYear += hours;
   hoursTwoWeeks += hours;
  }

 }//end addHoursWorked method

 public void addHoursWorked(double hours, int month, int day, int year){
  /*  Description: Add hours worked with a specific date of work given by calling class.
   *  Determines how to add the hours to yearly and two week accumulations. Two week
   * Precondition: Provide the hours, month as integer, day as integer, and year as
   *  four digit integer (such as year 2017)
   * Postcondition: If date provided is acceptable, hours will be added
   *
   *
   */

   //Verify that date is acceptable
   if(month <= 12 && month >= 1){
    if(day >= 1 && day <= 31){
     if(month == 2){
      //days in month are 28 unless leapyear, not checking for leapyear yet
      if(day <= 28){
       //day is acceptable, determine how to add hours to yearly and twoWeek accumulation
       if(day == 1 || day == 15){
        //two week hours starts over; add to yearly hours
        hoursTwoWeeks = hours;
        totalHoursCurrentYear += hours;
       }
       else{
        //add directly to both hour accumulations
        hoursTwoWeeks += hours;
        totalHoursCurrentYear += hours;
       }
      }
      else{
       //too many days in february
       System.out.println("Error in addHoursWorked method: February has less than or equal to 28 days");
      }
     }
     else if(month == 4 || month == 6 || month == 9 || month == 11){
      //days in month are 30
      if(day < 31){
       //day is good
       if(day == 1 || day == 15){
        //two week hours starts over; add to yearly hours
        hoursTwoWeeks = hours;
        totalHoursCurrentYear += hours;
       }
       else{
        //add directly to both hour accumulations
        hoursTwoWeeks += hours;
        totalHoursCurrentYear += hours;
       }

      }
      else{
       //too many days in month
       System.out.println("Error in addHoursWorked method: Too many days in month");
      }
     }
     else{
      //month must be 1, 3, 5, 7, 8, 10, or 12 with 31 days in month
      if(month == 1){
       if(day == 1){
        //two week hours starts over; add to yearly hours
        hoursTwoWeeks = hours;
        totalHoursCurrentYear = hours; //new year accumulation
       }
       else if(day == 15){
        hoursTwoWeeks = hours;
        totalHoursCurrentYear += hours;
       }
       else{
        //add directly to both hour accumulations
        hoursTwoWeeks += hours;
        totalHoursCurrentYear += hours;
       }
      }
      else{
       //not first month of year
       if(day == 1 || day == 15){
        //two week hours starts over; add to yearly hours
        hoursTwoWeeks = hours;
        totalHoursCurrentYear += hours;
       }
       else{
        //add directly to both hour accumulations
        hoursTwoWeeks += hours;
        totalHoursCurrentYear += hours;
       }
      }
     }
    }
    else{
     //day is outside acceptable range
     System.out.println("Error in addHoursWorked method: Day is outside range");
    }
   }
   else{
    //month is outside acceptable range
    System.out.println("Error in addHoursWorked method: Month is outside range");
   }
 }//end addHoursWorked method

 public double getHoursTwoWeeks(){

  return this.hoursTwoWeeks;
 }//end getHoursTwoWeeks method

 public double getHoursForYear(){

  return this.totalHoursCurrentYear;
 }//end getHoursForYear method

 public double calculateBimonthlyPay(){
  /* Description: Calculates pay based on current hours recorded, does not forecast
   * Precondition: Must invoke method at the end of the month and on the 14th to get full pay
   * Postcondition: Pay will be returned
   */
   double pay = this.hoursTwoWeeks * this.payRate;
   return pay;

 }//end calculateBimonthlyPay method

 public double calculateCurrentNetPay(){
  /* Description: Calculates current pay accumulated for entire year as of date method is called
   * Precondition:
   * Postcondition: Net pay will be returned
   */
   double pay = this.totalHoursCurrentYear * this.payRate;
   return pay;

 }//end calculateCurrentNetPay method

 public String displayIncomeTaxInfo(){
  /* Description: Displays all employee information for income tax purposes
   * Precondition: Employee info must have been set
   * Postcondition: Information will be displayed
   */

 /*  System.out.println("Employee Name: " + super.getFirstName() + " " + getMiddleName() + " " + super.getLastName() +
    "\nSSN: " + getSsn() + "\nAddress: " + super.getAddress() + "\nPhone: " + super.getPhone() +
    "\nEmail: " + super.getEmail() + "\nPosition Title: " + getPositionTitle() +
    "\nNet Hours Worked as of Today: " + getHoursForYear() + "\nNet Pay as of Today: " + calculateCurrentNetPay());
 */
  return ("Employee Name: " + super.getFirstName() + " " + getMiddleName() + " " + super.getLastName() +
    "\nSSN: " + getSsn() + "\nAddress: " + super.getAddress() + "\nPhone: " + super.getPhone() +
    "\nEmail: " + super.getEmail() + "\nPosition Title: " + getPositionTitle() +
    "\nNet Hours Worked as of Today: " + getHoursForYear() + "\nNet Pay as of Today: " + calculateCurrentNetPay()+"\n\n");
 }//end displayIncomeTaxInfo method

}//end class