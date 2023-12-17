
public class Reverse {

	// Part 2
	//
	// TODO Where N is the length of array 'arr' the complexity is:
	//
	// O(?)
	public static void reverse(String[] arr){ 
		Stack stack = new Stack(arr.length);
		// Loops for the length of the array
		for (int i = 0; i < arr.length; i++)
		{
			// Pushes each value of the array into the stack
			stack.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) 
		{
			// Pops the stack into the new array ("Reverses" the array)
			arr[i]=stack.pop().toString();
		}

	}
	
}
