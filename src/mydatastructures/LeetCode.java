package mydatastructures;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class LeetCode {
	
	public LeetCode()
	{}

	/*
	public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2] ;
        for(int i=0;i<=(nums.length-1) ;i++)
        {
            for (int j=1; j<=(nums.length-1) ;j++)
            {
                if(i==j) continue;
                
                if(nums[i]+nums[j] == target)
                {
                   ret = new int[]{i,j};
                   return ret;
                }
            }
        }
        return ret;
              
    }
	
	*/
	
	/// This is O(N) . This takes only one pass to compute the value. Best Approch
	
	public int[] twoSum(int[] nums, int target)
	{
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	        //map.remove(key)
	        
	        //map.isEmpty()
	       
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	
public String reverseString(String s)
{
	char[] in = s.toCharArray();
    int begin=0;
    int end=in.length-1;
    char temp;
    while(end>begin){
        temp = in[begin];
        in[begin]=in[end];
        in[end] = temp;
        end--;
        begin++;
    }
    return new String(in);
}

public String reverseSentance(String s)
{
	
	String[] split = s.split(" ");
	String result = "";
	for (int i = split.length - 1; i >= 0; i--) {
	  result += (split[i] + " ");
	}
	
	return result;
}
	
public int lengthOfLongestSubstring(String s) 
{
	int substr_len = 0;
    String  subst = null;
    Map<Character, Integer> hmap = new HashMap<>();
    
    int i =0;
    int l = s.length();
    int startInd =0;
   
    while(i <= (l-1) )
    {
    	if(hmap.containsKey(s.charAt(i)))
        {
    		if(hmap.get(s.charAt(i)) >= startInd)
    		{	
    			if(i- startInd > substr_len)
    			{
    				subst = s.substring(startInd, i); 
    				substr_len = subst.length();
    			}
    			startInd = hmap.get(s.charAt(i))+1;
        	}
    		hmap.replace(s.charAt(i), i);
    	 }
    	 else
    	 {
    	   hmap.put(s.charAt(i), i);
    	 }
    	i = i+1;    	
      }
     if((i- startInd) > substr_len)
     {
    	 subst=s.substring(startInd, i);
    	 substr_len =subst.length();
     }
    
    return substr_len;
        
}

///Solution from leetcode.for length of longest substring..
	

  public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
  }

  ///Find the median of 2 sorted arrays..:My code
  
  public double findMedianSortedArrays1(int[] nums1, int[] nums2) 
  {
	  int nums1_len = nums1.length;
	  int nums2_len = nums2.length;
	  boolean isEven = false;
	  int i=0,j =0 ,loop_conter=0 ; 
	  int count =   (nums1_len + nums2_len-1)/2;
	  int[] res = new int[nums1.length +nums2.length];
	
	  isEven  = ((nums1_len + nums2_len)%2 == 0) ? true :false;
	  
      while (loop_conter < (nums1_len+nums2_len))
	  {
		 if(i < nums1_len && j <nums2_len)
		 {
			 if(nums1[i] <= nums2[j])
			 	{
				 res[loop_conter] = nums1[i];
				 i= i+1;
			 	}
			 else
				 if(nums1[i] > nums2[j])
				 {
					 res[loop_conter] = nums2[j];
					 j= j+1;
				 }
	    }
	    else
		   if(i < (nums1_len))
	    {
			res[loop_conter] = nums1[i];  
			i= i+1;
	    }
	    else
	     if(j < (nums2_len))
	     {
	       res[loop_conter] = nums2[j];  
	       j= j+1;
		 }   
		 loop_conter = loop_conter +1;
	  }
      
	 double median =0.0 ;
	  
	  if(isEven)
	  {
		  median = (double) (res[count] +res[(count +1)]) / 2;
		  
	  }
	  else
	  {
		  median =  res[count];
		  
	  }
	  return median;
      
  }
  
  
  // LeetCode version...findMedianSortedArrays
  
  public  double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public  int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	 // LeetCode version...findMedianSortedArrays
	
	
	//Convert from Postfix to Infix.
	
	private boolean isOperator(String c)
	{
	   if(c.equals("+") || c.equals("-")  || c.equals("*") || c.equals("/") || c.equals("^"))
		   return true;
		
	   return false;
	}
	
	public String postFixToInfix(String s1)
	{
		 Stack<String> s = new Stack<>();
		 
		 String[] arr = s1.split(" ");
		
		 for(int i = 0; i < arr.length; i++){
		   String c = arr[i];
		   if(isOperator(c)){
		    String b = s.pop();
		    String a = s.pop();
		    s.push("("+a +""+c+""+b+")");
		   }
		   else
		    s.push(""+c);
		 }
		  return s.pop();
	}
	
	public String postFixToPrefix(String s1)
	{
		 Stack<String> s = new Stack<>();
		 
		 Boolean isOpn = false;
		 
		 String[] arr = s1.split(" ");
		
		 for(int i = 0; i < arr.length; i++){
		   String c = arr[i];
		   
		   if(isOperator(c)){
			  String b = s.pop();
		      String a = s.pop();
			  s.push("("+c+""+a+""+b+")");
		    }
		   else
			   s.push(""+c);
		 }
		  return s.pop();
	}
	
	public String infixToPostfix(String s1)
	{
		int opnCount =0;
		
		Stack<String> s = new Stack<>();
		
		String[] arr = s1.split(" ");
		
		 for(int i = 0; i < arr.length; i++){
		   String c = arr[i];
		   
		   if(c.equals("(")) 
		    {
			    opnCount = opnCount +1;
			    continue;
		    }
		    
		   if(c.equals(")") && opnCount > 0 ) 
		   {
			   String a = s.pop();
			   String b = s.pop();
			   String d = s.pop();
			   s.push(d+" "+a+" "+b);
			   opnCount = opnCount - 1;
		   }
		   else
			   s.push(""+c);
		 }
		  return s.pop();
	}
	
	public String infixToPrefix(String s1)
	{
		int opnCount =0;
		
		Stack<String> s = new Stack<>();
		
		String[] arr = s1.split(" ");
		
		 for(int i = 0; i < arr.length; i++){
		   String c = arr[i];
		   
		   if(c.equals("(")) 
		    {
			    opnCount = opnCount +1;
			    continue;
		    }
		    
		   if(c.equals(")") && opnCount > 0 ) 
		   {
			   String a = s.pop();
			   String b = s.pop();
			   String d = s.pop();
			   s.push("("+" "+ b+" "+d+" "+a+" "+")");
			   opnCount = opnCount - 1;
		   }
		   else
			   s.push(""+c);
		 }
		  return s.pop();
	}
	
	public String PrefixToInfix(String s1)
	{
		int opnCount =0;
		
		Stack<String> s = new Stack<>();
		
		String[] arr = s1.split(" ");
		
		 for(int i = 0; i < arr.length; i++){
		   String c = arr[i];
		   
		   if(c.equals("(")) 
		    {
			    opnCount = opnCount +1;
			    continue;
		    }
		    
		   if(c.equals(")") && opnCount > 0 ) 
		   {
			   String a = s.pop();
			   String b = s.pop();
			   String d = s.pop();
			   s.push("("+" "+ b+" "+d+" "+a+" "+")");
			   opnCount = opnCount - 1;
		   }
		   else
			   s.push(""+c);
		 }
		  return s.pop();
	}
	
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	private String helper(String s, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isValidElement(String s) 
	  {
		
		String[]  numOfChains = s.split(";");
		
		String[]  numElements ;

	    Map<String, String> hmap = new HashMap<>();
	    
	    int l = numOfChains.length;
	    int i =0;
	   
	    while(i <= (l-1))
	    {
	        
	        //Get each chain and parse..
	        numElements = numOfChains[i].split("-");
	    
	        for ( int j = 0 ;j<=1 ;j++)
	        {
	          if(!numElements[j].equals("BEGIN") && ! numElements[j].equals("END"))
	          {
	            if(hmap.containsKey(numElements[j]))
	            {
	               hmap.remove(numElements[j]);
	            }
	            else
	            {
	               hmap.put(numElements[j],numElements[j]);
	            }
	          }
	        }
	       
	        i = i+1;
	        
	    }
	  
	     return (hmap.isEmpty());

	}
	
	
	public static Boolean isSquare( Point p1 , Point p2, Point p3, Point p4)
	  {
	      
	      int d2 = distS(p1,p2);
	      int d3 = distS(p1,p3);
	      int d4 = distS(p1,p4);
	      
	      
	      if(d2 == d3 && 2*d2 == d4)
	      {
	        int d = distS(p2,p4);
	        
	        return (d == distS(p3,p4) && d == d2);
	      }
	          
	      if(d3 == d4 && 2*d3 == d2)
	      {
	        int d = distS(p2,p3);
	        
	        return (d == distS(p2,p4) && d == d3);
	      }    
	      
	       if(d2 == d4 && 2*d2 == d3)
	      {
	        int d = distS(p2,p3);
	        
	        return (d == distS(p3,p4) && d == d2);
	      }    
	      
	      return false;
	      
	  }
	  
	  public static int distS(Point p, Point q)
	  {
	      
	      return (p.x - q.x) * (p.x - q.x) + (p.y -q.y)*(p.y - q.y) ;
	  }
	      
	  
	  public class AlphabetTest 
	    {
	        public   String Alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
	        public   int Base = Alphabet.Length();

	        public  String Encode(int i)
	        {
	            if (i == 0) return Alphabet[0].ToString();

	            String s = null;

	            while (i > 0)
	            {  
	                s += Alphabet[i % Base];
	                i = i / Base;
	            }

	            return String.Join("", s.Reverse());
	        }

	        public static int Decode(string s)
	        {
	            var i = 0;

	            foreach (var c in s)
	            {
	                i = (i * Base) + Alphabet.IndexOf(c);
	            }

	            return i;
	        }      
	  

	
}
