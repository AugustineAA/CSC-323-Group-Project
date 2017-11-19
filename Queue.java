public class Queue
{
    public Queue nextQueue;
    public Queue prevQueue;
    String item;
    int numStock;
    int minInv;

    public Queue()
    {
      
    }
    //Queue constructor
    public Queue(String item,int numStock, int minInv) 
    {
      this.item=item;
      this.numStock=numStock;
      this.minInv=minInv;
    }
    //returns item name
    public String getItem()
    {
      return item;
    }
    //returns number of item in stock
    public int getNumStock()
    {
      return numStock;
    }
    //returns minimun item till reorder
    public int getMinInv()
    {
     return minInv; 
    }
}