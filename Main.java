import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel whosTurn;

  JTextField playerOne;
  JTextField playerTwo;
  JTextField[] oneGems;
  JTextField[] twoGems;

  JButton[] aButtons;
  JButton[] bButtons;
  JButton startButton;

  Font biggerText;


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
    playerOne.setBounds(50, 50, 50, 500);
    playerTwo.setBounds(700, 50, 50, 500);
    // add the text areas to the main panel
    mainPanel.add(playerOne);
    mainPanel.add(playerTwo);

    // create a bigger font to use
    biggerText = new Font("arial",Font.BOLD, 30);

    // set the font on the area I want to use it
    playerOne.setFont(biggerText);
    playerTwo.setFont(biggerText);

    // sets the size of the arrays
    aButtons = new JButton[7];
    bButtons = new JButton[7];
    
    // creating accumulator variable for A buttons bounds
    int j = 120;

    // creating the A Buttons
    for(int i = 1; i < aButtons.length; i++){
      aButtons[i] = new JButton("A" + i);
      // add the A buttons to the main panel
      mainPanel.add(aButtons[i]);
      // set the actions command
      aButtons[i].setActionCommand("A" + i);
      // add ActionListener
      aButtons[i].addActionListener(this);
      // set bigger font for a Buttons
      aButtons[i].setFont(biggerText);
      // set the location and size
      aButtons[i].setBounds(j, 100, 80, 80);
      j = j + 100;
    }

    // creating accumulator variable for B buttons bounds
    int k = 120;


    // creating the B Buttons
    for(int i = 1; i < bButtons.length; i++){
      bButtons[i] = new JButton("B" + i);
      // add the B buttons to the main panel
      mainPanel.add(bButtons[i]);
      // set the actions command
      bButtons[i].setActionCommand("B" + i);
      // add ActionListener
      bButtons[i].addActionListener(this);
      // set bigger font for b Buttons
      bButtons[i].setFont(biggerText);
      // set the location and size
      bButtons[i].setBounds(k, 300, 80, 80);
      k = k + 100;
    }

    // sets the size of the arrays for the gem areas
    oneGems = new JTextField[14];
    twoGems = new JTextField[7];

    // accumulator variable for text areas
    int l = 120;

    // creating player ones text areas
    for(int i = 1; i < 7; i++){
      oneGems[i] = new JTextField("4");
      // add the gem areas to the main panel
      mainPanel.add(oneGems[i]);
      // set the actions command
      oneGems[i].setActionCommand("" + (14 - i));
      // add ActionListener
      oneGems[i].addActionListener(this);
      // set bigger font for one text areas
      oneGems[i].setFont(biggerText);
      // set the location and size
      oneGems[i].setBounds(l, 200, 80, 80);
      l = l + 100;
    }

    // accumulator variable for text areas
    int h = 120;

    // creating player ones text areas
    for(int i = 1; i < twoGems.length; i++){
      twoGems[i] = new JTextField("4");
      // add the gem areas to the main panel
      mainPanel.add(twoGems[i]);
      // set the actions command
      twoGems[i].setActionCommand("" + i);
      // add ActionListener
      twoGems[i].addActionListener(this);
      // set bigger font for one text areas
      twoGems[i].setFont(biggerText);
      // set the location and size
      twoGems[i].setBounds(h, 400, 80, 80);
      h = h + 100;
    }

    // initialize the JButton
    startButton = new JButton("Start");
    // set the location and size
    startButton.setBounds(100, 500, 100, 20);
    // add an action listener to the button
    startButton.addActionListener(this);
    // set the action command on the button
    startButton.setActionCommand("Start");
    // add the JButton to the main panel
    mainPanel.add(startButton);

    // initialize the label for whos turn
    whosTurn = new JLabel("Who's turn?");
    // set the location and size
    whosTurn.setBounds(300, 500, 300, 30);
    // add the label to the main panel
    mainPanel.add(whosTurn);


    // add the main panel to the window
    frame.add(mainPanel);
 

  
 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("Start")){
      // create variable used for player one and two
      int whichPlayer = 1;
      while(whichPlayer >= 0){
        while(whichPlayer == 1){
         // set the whos turn text to whos turn
          whosTurn.setText("Its player one's turn!");

          for(int i = 1; i < bButtons.length; i++){
           // disable the b buttons so player one can not touch them
           bButtons[i].setEnabled(false);
          }
          // disable player 2 text area
          playerTwo.setEnabled(false);
         // player one clicks button
         // if statement to see if laned in pit
         whichPlayer = whichPlayer + 1;
        }
        while(whichPlayer == 2){
         //player 2 clicks button
         // if statement to see if it landed in the pit
         whichPlayer = whichPlayer - 1;
        }
      }
     
    }

  }


  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread 
    SwingUtilities.invokeLater(gui);
  }
}

