import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JTextField playerOne;
  JTextField playerTwo;

  JButton[] aButtons;
  JButton[] bButtons;

  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    // initialize the text areas
    playerOne = new JTextField("0");
    playerTwo = new JTextField("0");
    // set the location and size
    playerOne.setBounds(50, 50, 500, 50);
    playerTwo.setBounds(440, 50, 500, 50);
    // add the text areas to the main panel
    mainPanel.add(playerOne);
    mainPanel.add(playerTwo);

    // sets the size of the arrays
    aButtons = new JButton[7];
    bButtons = new JButton[7];

    // creating the A Buttons
    for(int i = 1; i < aButtons.length; i++){
      aButtons[i] = new JButton("A" + i);
      //// add the A Buttons to the main panel
      mainPanel.add(aButtons);
      // set the actions command
      aButtons[i].setActionCommand("A" + i);
      // add ActionListener
      aButtons[i].addActionListener(this);
    }

    // creating the B Buttons
    for(int i = 1; i < bButtons.length; i++){
      bButtons[i] = new JButton("B" + i);
      // add the B Buttons to the main panel
      mainPanel.add(bButtons);
      // set the actions command
      bButtons[i].setActionCommand("B" + i);
      // add ActionListener
      bButtons[i].addActionListener(this);
    }

    // set location and size for A Buttons
    aButtons[A1].setBounds(120, 300, 50, 50);

    // add the main panel to the window
    frame.add(mainPanel);
 

  
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
