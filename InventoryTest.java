public class InventoryTest 
{
 public static void main(String args[])
 {
   QueueList tire = new QueueList();
   tire.insert("test",4,12);
   tire.insert("test2",2,16);
   tire.print("test2");
   tire.saveList();
 }
}