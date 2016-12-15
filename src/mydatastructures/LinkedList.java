
package mydatastructures;

import java.util.*;
import java.awt.image.ColorConvertOp;
import java.io.*;


public class LinkedList 
{
    ListNode head = null;
    
    public LinkedList()
    {
    	
    }
   
  public void AddNode(long l )
  {
	  ListNode ln = new ListNode(l) ;
	  
	  if (head == null)
	  {
		head = ln;  
	  }
	  else
	  {
		  ln.next = head;
		  head = ln;
	  }
  }
    
 
  public void DisplayList(ListNode head)
  {
	  ListNode current = head;
	  
	  System.out.println();
	  
	  while(current != null)
	  {
		  System.out.print(Long.toString(current.val)); 
		  current = current.next;
	  }  
  }
  
  public LinkedList addTwoNumbers(ListNode first, ListNode sec)
  {
	 
	 LinkedList ret = new LinkedList();
	 long res ;
	 
	  
	 
	 long firstval = GetNumberFromList(first);
	 long secval = GetNumberFromList(sec);
    
	 res = firstval + secval ;
	 
	 while(res > 0)
	 {
		ret.AddNode(res % 10);
		res = res /10;
	 }
	 
	 return ret;
	  
  }
  
  
  protected long GetNumberFromList(ListNode ls)
  {
	  long res = 0;
	 
	 int counter = 0;
	 
	  ListNode current = ls;
	  
	  while(current != null)
	  {
		  res =  (long)(res + (current.val * Math.pow(10, counter)));
		  counter++;
		 
	       current = current.next;
	  } 
	  
	  return res;
  }
  
    
}

final  class ListNode
{
	long val;
     ListNode next;
     public ListNode(long l) 
     {
    	 val = l;
     }
}
