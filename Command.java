import javax.swing.*;

public class Command
{
  public void login()//login screen should go here
  {
            commandList();
  }
  public void commandList()//lists all commands
  {
       boolean go = true;
   
   ImageIcon icon = new ImageIcon("tire.png");
   
   while(go){
   String[] options = new String[] {"Add Misc", "Add/Remove Tires", "Update Item", "Display List"};
    int response = JOptionPane.showOptionDialog(null, "Select a Command", "Protoype",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        icon, options, options[0]);
    if(response==0)//add misc
      addItem();
    else if(response==1)//add/remove tires
      addTire();
    else if(response==2)//update item
      updateItem();
    else if(response==3)//display list
      disList();
    else
      go=false;
   }
   System.out.println("Rest to be implemented");
     //Others to be implemented
 }
  public void addItem()//adds item to list
 {
   List item = new List();
   item.loadList();
   
   boolean addAnother=true;
   
   while(addAnother)
   {
   JTextField int1 = new JTextField(5);
   JTextField int2 = new JTextField(5);
   JTextField input = new JTextField(5);
   
   ImageIcon icon = new ImageIcon("tire.png");
   
   JPanel myPanel = new JPanel();
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Item Name:"));
      myPanel.add(input);
      myPanel.add(new JLabel("Stock Amount:"));
      myPanel.add(int1);
      myPanel.add(new JLabel("Min Inv Amount till Reorder:"));
      myPanel.add(int2);
   JOptionPane.showMessageDialog(null,myPanel,"Protoype",JOptionPane.PLAIN_MESSAGE,icon);

   int stockAmount = Integer.parseInt(int1.getText());
   int minAmount = Integer.parseInt(int2.getText());
   item.itemExists(input.getText(),stockAmount,minAmount);
   if(JOptionPane.showConfirmDialog(null,"Enter another item?", "Add Another",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
     addAnother=true;
   else
     addAnother=false;
   }
   item.saveList();
 }
 public void addTire()//adds tires to list
 {
   List item = new List();
   item.loadList();
   
   JPanel myPanel = new JPanel();
   String[] choices = { "BFGoodrich","Bridgestone", "Cooper", "Goodyear","Michelin", "Nexen" };
    
    JComboBox tireList = new JComboBox(choices);
    tireList.setSelectedIndex(0);
    myPanel.add(tireList);
    
    JTextField amount = new JTextField(5);
    myPanel.add(amount);
    JRadioButton add = new JRadioButton("Add");
    JRadioButton remove = new JRadioButton("Remove");
    ButtonGroup bg = new ButtonGroup();
    bg.add(add);
    bg.add(remove);
    myPanel.add(add);
    myPanel.add(remove);
    
    JOptionPane.showMessageDialog(null,myPanel,"Protoype",JOptionPane.PLAIN_MESSAGE);
    
    String value = tireList.getSelectedItem().toString();
    int stock = Integer.parseInt(amount.getText());
    
    if(add.isSelected())
    {
      item.itemExists(value,item.displayStock(value)+stock);
      JOptionPane.showMessageDialog(null,stock+" "+value+" tires has been added","Protoype",JOptionPane.PLAIN_MESSAGE);
    }
    else
    {
      item.itemExists(value,item.displayStock(value)-stock);
      JOptionPane.showMessageDialog(null,stock+" "+value+" tires has been removed","Protoype",JOptionPane.PLAIN_MESSAGE);
    }
    item.saveList();
 }
 public void updateItem()//updates stock for item in list
 {
   List item = new List();
   item.loadList();
   
   JPanel myPanel = new JPanel();
   String[] choices = new String[item.sendFirstItem().size()];
   choices = item.sendFirstItem().toArray(choices);
    
    JComboBox tireList = new JComboBox(choices);
    tireList.setSelectedIndex(0);
    myPanel.add(new JLabel("Select an Item:"));
    myPanel.add(tireList);
    
    JTextField amount = new JTextField(5);
    JTextField inStock = new JTextField(5);
    JRadioButton add = new JRadioButton("Add");
    JRadioButton remove = new JRadioButton("Remove");
    ButtonGroup bg = new ButtonGroup();
    
    myPanel.add(new JLabel("Input Amount:"));
    myPanel.add(amount);
    bg.add(add);
    bg.add(remove);
    myPanel.add(add);
    myPanel.add(remove);
    
    JOptionPane.showMessageDialog(null,myPanel,"Protoype",JOptionPane.PLAIN_MESSAGE);
    
    String value = tireList.getSelectedItem().toString();
    int stock = Integer.parseInt(amount.getText());
    
    if(add.isSelected())
    {
      item.itemExists(value,item.displayStock(value)+stock);
      JOptionPane.showMessageDialog(null,stock+" "+value+"'s has been added","Protoype",JOptionPane.PLAIN_MESSAGE);
    }
    else
    {
      item.itemExists(value,item.displayStock(value)-stock);
      JOptionPane.showMessageDialog(null,stock+" "+value+"'s has been removed","Protoype",JOptionPane.PLAIN_MESSAGE);
    }
    item.saveList();
 }
 public void disList()//sorts and displays list
 {
   List item = new List();
   item.sortList();
   item.loadList();
   item.displayList();
 }
}