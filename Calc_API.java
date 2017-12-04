package calculator;

public class Calc_API
{
	public static double calc(double a, double b, String op)
	{	
		double res = 0;
		
		switch(op) 
		{
			case "+": res = a + b; break;
			case "-": res = a - b; break;
			case "*": res = a * b; break;
			case "/": res = a / b; break;
		}
		
		return res;
	}
}