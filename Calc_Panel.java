package calculator;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calc_Panel extends JPanel
{
	Calc_Commands calcCommands = null;
	JPanel operationPanel = null;

	JTextField display;

	public Calc_Panel(Calc_Commands calcCommands)
	{	
		calcCommands.calcPanel = this;
		display = new JTextField();
		setLayout(null);
	
		// creating display panel
		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(10, 10, 350, 50);
		displayPanel.setLayout(new GridLayout(1, 1));
		displayPanel.add(display);
		display.setMargin(new Insets(2, 2, 2, 2));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("Arial", Font.BOLD, 20));
		add(displayPanel);
		// end of creating display panel

		// creating main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 80, 260, 40);
		mainPanel.setLayout(new GridLayout(1, 3, 10, 10));
		String[] strMain = {"AC", "CE", "%"};
		for(int i = 0; i < strMain.length; i++)
		{
			JButton button = new JButton(strMain[i]);
			button.setFont(new Font("Arial", Font.BOLD, 20));	
			if (i == 0) 
			{
				button.setBackground(Color.red);
				button.setForeground(Color.white);
				button.addActionListener(calcCommands.ac);
			}
			else if (i == 1) 
			{
				button.setBackground(Color.red);
				button.setForeground(Color.white);
				button.addActionListener(calcCommands.ce);
			}
			else
			{
				button.setBackground(Color.black);
				button.setForeground(Color.white);
				button.addActionListener(calcCommands.percent);
			}
			mainPanel.add(button);
		}
		add(mainPanel);
		// end of creating main panel

		// creating button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 130, 260, 190);
		buttonPanel.setLayout(new GridLayout(4, 3, 10, 10));
		//buttonPanel.setBackground(Color.red);
		String[] strButton = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "="};
		for(int i = 0; i < strButton.length; i++)
		{
			JButton button = new JButton(strButton[i]);
			button.setFont(new Font("Arial", Font.BOLD, 20));
			button.setBackground(Color.black);
			button.setForeground(Color.white);
			if (i == strButton.length - 1) 
			{
				button.addActionListener(calcCommands.operation);
			}
			else 
			{
				button.addActionListener(calcCommands.pressNum);
			}
			buttonPanel.add(button);
		}
		add(buttonPanel);
		// end of creating display panel

		// creating operation panel
		operationPanel = new JPanel();
		operationPanel.setBounds(280, 80, 80, 240);
		operationPanel.setLayout(new GridLayout(5, 1, 10, 10));
		String[] strOperation = {"/", "*", "-", "+", "B"};
		for(int i = 0; i < strOperation.length; i++)
		{
			JButton button = new JButton(strOperation[i]);
			button.setFont(new Font("Arial", Font.BOLD, 20));
			button.setBackground(Color.black);
			button.setForeground(Color.white);
			if (i == strOperation.length - 1) 
			{
				button.addActionListener(calcCommands.backspace);
			}
			else 
			{
				button.addActionListener(calcCommands.operation);
			}
			operationPanel.add(button);
		}
		add(operationPanel);
		// end of creating operation panel
	}
}