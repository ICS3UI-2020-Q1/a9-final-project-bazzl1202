import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel whosTurn;

  JTextField playerOne;
  JTextField playerTwo;

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
      aButtons[i] = new JButton("4");
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
      bButtons[i] = new JButton("4");
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
        while(whichPlayer <=1){
         // set the whos turn text to whos turn
          whosTurn.setText("Its player one's turn!");

          // for loop to able all aButtons
          for(int i = 1; i < aButtons.length; i++){
           // able the a buttons so player one can play
           aButtons[i].setEnabled(true);
          }
          // able player 1 text area
          playerOne.setEnabled(true);

          // for loop to disable all bButtons
          for(int i = 1; i < bButtons.length; i++){
           // disable the b buttons so player one can not touch them
           bButtons[i].setEnabled(false);
          }
          // disable player 2 text area
          playerTwo.setEnabled(false);

         // player one clicks button
         if(command.startsWith("A")){
           // separate the A from the number
           String number = command.substring(1);
           // set string to integer
           int buttonNum = Integer.parseInt(number);
           // set button vlaue to zero
           aButtons[1].setText("" + buttonNum);

           
          }
         // if statement to see if laned in pit
         whichPlayer = whichPlayer + 1;
        }
        while(whichPlayer >= 2){
          // set the whos turn text to whos turn
          whosTurn.setText("Its player two's turn!");

          // for loop to able all bButtons for player two
          for(int i = 1; i < bButtons.length; i++){
           // able the b buttons so player two can play
           bButtons[i].setEnabled(true);
          }
          // able player 2 text area
          playerTwo.setEnabled(true); 

          // for loop to disable all aButtons
          for(int i = 1; i < aButtons.length; i++){
           // disable the a buttons so player two can not touch them
           aButtons[i].setEnabled(false);
          }
          // disable player 1 text area
          playerOne.setEnabled(false);

         
         // if statement to see if it landed in the pit
         whichPlayer = whichPlayer - 1;
        }
        whichPlayer = -1;
      }
     
    }
    //player 2 clicks button
    if(command.startsWith("B")){
      // separate the B from the number
      String number = command.substring(1);
      // change string to integer
      int buttonNum = Integer.parseInt(number);
      // get the text from the button
      String bButtonsText = bButtons[buttonNum].getText();
      // change the string into an integer
      int gemsInHand = Integer.parseInt(bButtonsText);
      // set button value to zero
      bButtons[buttonNum].setText("" + 0);

      for(int i = gemsInHand; i <= 0; i--){
        buttonNum = (buttonNum + 1);
        // get the text from the button
       bButtonsText = bButtons[buttonNum].getText();
       // change the string into an integer
       int bButtonsGems = Integer.parseInt(bButtonsText);
       // add gems together with one 
       int sum = bButtonsGems + 1;
       //set button values
       bButtons[buttonNum].setText("" + sum);
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

