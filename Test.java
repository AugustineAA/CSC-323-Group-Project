import javax.swing.JOptionPane; 
public class Test 
{
 public static void main(String args[])
 {
   boolean go = true;
   while(go){
   String[] options = new String[] {"Add Item", "Add User", "Add Employee", "Update Info"};
    int response = JOptionPane.showOptionDialog(null, "Select a Command", "Title",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, options, options[0]);
    if(response==0)
      addItem();
    else if(response==1)
      go=false;
    else if(response==2)
      go=false;
    else if(response==3)
      go=false;
   }
   System.out.println("To be implemented");
     //Others to be implemented
 }
 public static void addItem()
 {
   List item = new List();
   item.loadList();
   
   boolean addAnother=true;
   
   while(addAnother)
   {
   String input = JOptionPane.showInputDialog(null,"Enter Item Name");
   String int1 = JOptionPane.showInputDialog(null,"Enter Stock Amount");
   String int2 = JOptionPane.showInputDialog(null,"Enter Min Amount until Reorder");
   int stockAmount = Integer.parseInt(int1);
   int minAmount = Integer.parseInt(int2);
   item.itemExists(input,stockAmount,minAmount);
   if(JOptionPane.showConfirmDialog(null,"Enter another item?", "Add Another",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
     addAnother=true;
   else
     addAnother=false;
   }
   item.saveList();
 }
}