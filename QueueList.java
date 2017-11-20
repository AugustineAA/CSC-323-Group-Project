import java.io.*;
import java.util.*;
class QueueList extends Queue
{
    private Queue head;
    private Queue curr;
    //private Queue tail;

    //QueueList constructor
    public QueueList() 
    {
        head = null;
        curr = null;
        //tail = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() 
    {
        return head == null;
    }

    //Inserts a new item at the end of the list
    public void insert(String item,int numStock, int minInv)
    {
        Queue link = new Queue(item,numStock,minInv);
        if(curr!=null)
        {
        curr.nextQueue=link;
        curr=curr.nextQueue;
        //tail=curr.nextQueue;
        }
        else
        {
        head = link;
        curr=head;
        //tail = curr;
        }
    }
    //prints item,stock,min order
    public void print(String item)
    {
      curr=head;
      boolean stop=true;
      while(stop)
      {
        curr=curr.nextQueue;
        if(curr.getItem().equals(item))
          stop=false;
      }
            System.out.println(curr.getItem()+","+curr.getNumStock()+","+curr.getMinInv());
    }
    //saves list for future reference
    public void saveList()
    {
      try
      {
      PrintWriter writer = new PrintWriter("test.txt","UTF-8");
      curr=head;
      while(curr!=null)
      {
      writer.println(curr.getItem()+", "+curr.getNumStock()+", "+curr.getMinInv());
      curr=curr.nextQueue;
      }
      writer.close();
      }catch(IOException e){System.out.println("Could not save data");}
    }
    //loads file if exists
    public void loadList()
    {
      File file = new File("test.txt");
    try {

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String st = sc.nextLine();
            
            String temp[] = st.split(",");
            String temp1 = temp[0];
            int temp2 = Integer.parseInt(temp[1]);
            int temp3 = Integer.parseInt(temp[2]);
            insert(temp1,temp2,temp3);
            
        }
        sc.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}