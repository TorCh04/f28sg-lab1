// exception used for Q5
class CalculateException extends RuntimeException{    
	public CalculateException(String err) {
		super(err);
	}
}

public class Calculator {

	/*
	 *  Methods for Part 3
	 */
	public static int calculate(String [] cmds){
		Stack pstack = new Stack(100);
		// Reverses all items in cmds
		Reverse.reverse(cmds);

		// For all items in the list
		for (int i = 0; i < cmds.length; i++) 
		{
			// Checks if it is a number
			if (isNumber(cmds[i]))
			{
				// If it is a number push it into the stack
				pstack.push(cmds[i]);
			}
			else
			{
				// If it's an operation it pops the next 2 number off the stack
				String fst = (String) pstack.pop();
				String snd = (String) pstack.pop();
				String op =  cmds[i];
				// Calculate using the op and pushes it back into the stack
				pstack.push(String.valueOf(applyOp(fst, op, snd)));
			}
		
		}
		// Converts the top of the stack (i.e the caculated number) to an Interger 
		return Integer.parseInt((String)pstack.top());
	}	

	public static int convert(String s) throws NumberFormatException{
		// Converts String (s) to an Interger
		return Integer.parseInt(s); 
	}

	public static boolean isNumber(String s){
		
		// Tries to convert String to an Integer, works if it's a number
		try 
		{
			Integer.parseInt(s);
		// If it isn't a number fails
		} catch (NumberFormatException e) {
			return false;
		}
		// Returns true if it's a number ofc
		return true; 
	}

	// apply the operator after converting the numbers
	public static int applyOp(String fst,String op,String snd){
		
		// Does a different arithmatic calculation depending on the operation and returns it
		switch (op) {
			// If it's a + sign add the two numbers
			case "+":
				return (convert(fst)+convert(snd));
			// If it's a - sign minus the two numbers
			case "-":
				return (convert(fst)-convert(snd));
			// If it's a * sign multiply the two numbers
			case "*":
				return (convert(fst)*convert(snd));
			// If it's neither of the signs above divide the two numbers
			default:
				return (convert(fst)/convert(snd));
		}
	}

	// main operation to calculate using Polish notation directly
    public static int calculatePolish(String [] cmds){
    	return -1; // dummy value
    }
}
