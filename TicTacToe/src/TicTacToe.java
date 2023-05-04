
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean playerTurn;

	public TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		frame.getContentPane().setBackground(Color.gray);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(Color.black);
		textField.setForeground(Color.white);
		textField.setFont(new Font("Arial", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(Color.white);
		
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);		
		frame.add(buttonPanel);
		
		firstTurn();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 9; i++) {
			
			if (e.getSource() == buttons[i]) {
				
				if (playerTurn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.red);
						buttons[i].setText("X");
						playerTurn = false;
						textField.setText("O turn.");
					}
				}
				else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.blue);
						buttons[i].setText("O");
						playerTurn = true;
						textField.setText("X turn.");
						check();
					}
				}
			}
		}
	}
	
	public void firstTurn() {
		int randomNum = random.nextInt(2);
		
		disableButtons();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enableButtons();
		
		if (randomNum == 0) {
			playerTurn = true;
			textField.setText("X Turn.");
		}
		
		else {
			playerTurn = false;
			textField.setText("O Turn.");
		}
	}
	
	private void disableButtons() {
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
	}

	private void enableButtons() {
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(true);
		}
	}

	public void check() {
		
		int a = 0;
		int b = 1;
		int c = 2;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
		a = 3;
		b = 4;
		c = 5;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
		a = 6;
		b = 7;
		c = 8;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
		a = 0;
		b = 3;
		c = 6;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}

		a = 1;
		b = 4;
		c = 7;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
		a = 2;
		b = 5;
		c = 8;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
		a = 0;
		b = 4;
		c = 8;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
		a = 2;
		b = 4;
		c = 6;
		if ((buttons[a].getText() == "X") && (buttons[b].getText() == "X") && (buttons[c].getText() == "X")) {
			XWins(a, b, c);
		}
		if ((buttons[a].getText() == "O") && (buttons[b].getText() == "O") && (buttons[c].getText() == "O")) {
			OWins(a, b, c);
		}
		
	}
	
	public void XWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		disableButtons();
		textField.setText("X wins!");
	}
	
	public void OWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		disableButtons();
		textField.setText("O wins!");
		
	}
	

	
	
	
}
