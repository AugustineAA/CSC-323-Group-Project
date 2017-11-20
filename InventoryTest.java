import javax.swing.JOptionPane; 
public class InventoryTest 
{
 public static void main(String args[])
 {
   QueueList item = new QueueList();
   item.loadList();
   
   boolean addAnother=true;
   
   while(addAnother)
   {
   String input = JOptionPane.showInputDialog(null,"Enter Item Name");
   String int1 = JOptionPane.showInputDialog(null,"Enter Stock Amount");
   String int2 = JOptionPane.showInputDialog(null,"Enter Min Amount until Reorder");
   int stockAmount = Integer.parseInt(int1);
   int minAmount = Integer.parseInt(int2);
   item.insert(input,stockAmount,minAmount);
   String another = JOptionPane.showInputDialog(null,"Enter another item?(Y,N)");
   if(another.equals("Y")||another.equals("y"))
     addAnother=true;
   else
     addAnother=false;
   }
   item.saveList();
 }
}