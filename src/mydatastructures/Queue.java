
package mydatastructures;

import java.util.*;

public class Queue {

	Stack<Integer> stack_push ;
	Stack<Integer> stack_pop ;
	
	public  Queue()
	{
		stack_push = new Stack<Integer>();
		stack_pop = new Stack<Integer>();
	}
	
	public void Push(Integer val)
	{
	 	
		stack_push.add(val);
		
	}

	public Integer Pop()
	{
		
	  if(stack_pop.size() ==0 )
	  {
		  Iterator<Integer> iter = stack_push.iterator();

		  while (iter.hasNext()){
		      stack_pop.push(stack_push.pop());
		  }
	  }
		
	return stack_pop.pop();	
	}
	
	
}
