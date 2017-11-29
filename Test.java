import javax.swing.*;

public class Test 
{
 public static void main(String args[])
 {
   boolean go = true;
   ImageIcon icon = new ImageIcon("dog.jpg");
   
   while(go){
   String[] options = new String[] {"Add Item", "Add User", "Add Employee", "Update Info", "Display List"};
    int response = JOptionPane.showOptionDialog(null, "Select a Command", "Think of a Title",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        icon, options, options[0]);
    if(response==0)
      addItem();
    else if(response==1)
      go=false;
    else if(response==2)
      go=false;
    else if(response==3)
      go=false;
    else if(response==4)
      disList();
    else
      go=false;
   }
   System.out.println("To be implemented");
     //Others to be implemented
 }
 public static void addItem()//add item to list
 {
   List item = new List();
   item.loadList();
   
   boolean addAnother=true;
   
   while(addAnother)
   {
   JTextField int1 = new JTextField(5);
   JTextField int2 = new JTextField(5);
   JTextField input = new JTextField(5);
   
   ImageIcon icon = new ImageIcon("dog.jpg");
   
   JPanel myPanel = new JPanel();
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Item Name:"));
      myPanel.add(input);
      myPanel.add(new JLabel("Stock Amount:"));
      myPanel.add(int1);
      myPanel.add(Box.createVerticalGlue()); // a spacer
      myPanel.add(new JLabel("Min Inv Amount till Reorder:"));
      myPanel.add(int2);
   JOptionPane.showMessageDialog(null,myPanel,"Think of a Title",JOptionPane.PLAIN_MESSAGE,icon);

   int stockAmount = Integer.parseInt(int1.getText());
   int minAmount = Integer.parseInt(int2.getText());
   item.itemExists(input.getText(),stockAmount,minAmount);
   if(JOptionPane.showConfirmDialog(null,"Enter another item?", "Add Another",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
     addAnother=true;
   else
     addAnother=false;
   }
   item.sortList();
   item.saveList();
 }
 public static void disList()//sorts and displays list
 {
   List item = new List();
   item.sortList();
   item.loadList();
   item.displayList();
 }
}