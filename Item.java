/* Changes made:
 * added new constructor with 2 parameters
 */

public class Item{

    public Item nextItem;
    private String item; //holds item name
    private int numStock; //holds number in stock
    private int minInv;  //holds minimum number in stock allowed before reorder required

 //default constructor
    public Item(){
    }
        //constructor that creates an item
    public Item(String newItem, int newStock){
     this.item = newItem;
     this.numStock = newStock;
     this.nextItem = null;
    }
    //constructor that creates an item
    public Item(String newItem, int newStock, int newMinInv){
     this.item = newItem;
     this.numStock = newStock;
     this.minInv = newMinInv;
     this.nextItem = null;
    }

    //Methods
    public void setItem(String newItem){
     this.item = newItem;
    }

    public void setNumStock(int newStock){
     this.numStock = newStock;
    }

    public void setMinInv(int newMin){
     this.minInv = newMin;
    }

    public String getItem(){
     //returns item name
      return item;
    }

    public int getNumStock(){
     //returns number of item in stock
     return numStock;
    }

    public int getMinInv(){
     //returns minimun item till reorder
     return minInv;
    }
}//end class
