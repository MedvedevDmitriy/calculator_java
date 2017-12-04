package calculator;

import java.awt.Toolkit;

import javax.swing.*;

@SuppressWarnings("serial")
public class Calc_Frame extends JFrame
{
	public Calc_Frame()
	{
		setTitle("CALCULATOR");
		//setBounds(500, 50, 400, 600);
		int width = 390;
		int height = 390;	
		setSize(width, height);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		add(new Calc_Panel(new Calc_Commands()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}