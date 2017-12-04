package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc_Commands
{
	public Calc_Panel calcPanel = null;
	
	boolean flag = true;
	double numA = 0;
	Double numB = null;
	String opeR = null;
	double res = 0;
	int count = 0;
	
	PressNum pressNum  = new PressNum();
	Operation operation = new Operation();
	
	ActionAC ac = new ActionAC();
	ActionCE ce = new ActionCE();
	ActionPercent percent = new ActionPercent();
	ActionBackspace backspace = new ActionBackspace();
		
	class ActionPercent implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (numB == 0) 
			{
		        numB = 1.0;
		        numA = numB * (numA / 100);
		        calcPanel.display.setText(""+numA);
		    }
		    else 
		    {
		        numB = numB * (numA / 100);
		        calcPanel.display.setText(""+numB);
		    }		
		}
	}
	
	class ActionBackspace implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (opeR == null) 
			{
		        if (numA % (int)(numA) > 0) 
		        {
		            for (int i = 0; i < count-2; i++) 
		            {
		                numA *= 10;
		            }
		            numA = (int)(numA);
		            for (int i = 0; i < count-2; i++) 
		            {
		                numA /= 10;
		            }
		            count--;
		        }
		        else
		        {
		            numA = (int)(numA / 10);
		        }
		        calcPanel.display.setText(""+numA);
		    }
		    else if (numB != null)
		    {
		        if (numB % numB.intValue() > 0) 
		        {
		            for (int i = 0; i < count-2; i++) 
		            {
		                numB *= 10;
		            }
		            numB = (double)(numB.intValue());
		            for (int i = 0; i < count-2; i++) 
		            {
		                numB /= 10;
		            }
		            count--;
		        }
		        else 
		        {
		            numB = (double)(numB.intValue() / 10);
		        }
		        calcPanel.display.setText(""+numB);
		    }	
		}
	}
	
	class ActionCE implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			numB = null;
			calcPanel.display.setText(""+numB);		
		}
	}
	
	class ActionAC implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			clean();	
		}
	}
	
	public void blockedOperations(boolean hoolean)
	{ 
		String[] array = {"/", "*", "-", "+"};
		flag = hoolean;
		if (!flag) 
		{
			calcPanel.display.setText("Error");
			for (int i = 0; i < array.length; i++) {
				calcPanel.operationPanel.getComponent(i).setEnabled(flag);
			}
		}
		else {
			for (int i = 0; i < array.length; i++) {
				calcPanel.operationPanel.getComponent(i).setEnabled(flag);
			}
		}
	}
	
	public void clean()
	{
		res = 0;
	    numA = 0;
	    numB = null;
	    opeR = null;
	    count = 0;
	    calcPanel.display.setText(""+res);
	    blockedOperations(true);
	}
	
	class PressNum implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String cmd = e.getActionCommand();
			if (flag == false) 
			{
		       clean();
		    }

		    if (cmd.equals(".")) 
		    {
		        if (count == 0) 
		        {
		            count = 1;
		        }
		    }
		    else 
		    {
		        int tmp = Integer.parseInt(cmd);
		        if (opeR == null) 
		        {
		            if (count == 0) 
		            {
		                numA = numA*10 + tmp;
		            }
		            else 
		            {
		                numA = numA + tmp / Math.pow(10, count);
		                count++;
		            }
		            calcPanel.display.setText(""+numA);
		        }
		        else 
		        {
		        	numB = new Double(0);
		            if (count == 0) 
		            {
		                numB = numB*10 + tmp;
		            }
		            else 
		            {
		                numB = numB + tmp / Math.pow(10, count);
		                count++;
		            }
		            calcPanel.display.setText(""+numB);
		        }
			}
		}
	}
	
	class Operation implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String cmd = e.getActionCommand();
			if (opeR != null) 
			{
		        if (cmd.equals("=")) 
		        {
		            if (numB == null) 
		            {
		                numB = numA;
		            }
		        }    
		        if (numB != null && opeR == "/" && numB == 0) 
		        {
		            blockedOperations(false);
		        }  
		        else if (numB != null)
		        {
		            res = Calc_API.calc(numA, numB.doubleValue(), opeR);
		            calcPanel.display.setText(""+res);
		            numA = res;
		        }
		        if (!cmd.equals("=")) 
		        {
		            opeR = cmd;
		            count = 0;
		        }
		        numB = null;
		    }
		    else 
		    {
		        if (!cmd.equals("=") && !cmd.equals("%")) 
		        {
		            opeR = cmd;
		            count = 0;
		        }
		        numB = null;
		    }
		}
	}
}