import javax.swing.*;

public class Login{
  
  public static void main(String[] args){
    ImageIcon icon = new ImageIcon("tire.png");
    
    JTextField int1 = new JTextField(10);
    JTextField input = new JTextField(10);
    JButton b1 = new JButton("Login");
    JPanel myPanel = new JPanel();
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Employee Name:"));
      myPanel.add(input);
      myPanel.add(new JLabel("Password:"));
      myPanel.add(int1);
      UIManager.put("OptionPane.okButtonText","Login");
   JOptionPane.showMessageDialog(null,myPanel,"Login Screen",JOptionPane.PLAIN_MESSAGE,icon);
  }
}