import java.util.ArrayList;
import java.util.Arrays;

public class Addition {

	public static void main(String[] args) {

		/*
		 * Test of the addition algorithm 
		 * 
		 *  a =  {2,3,4,3} 
		 *  +
		 *  b =  {5,8,1,9}
		 *  --------------
		 *  r = {0,8,1,6,2}
		 *  
		 */
		
		int[] a = {1,9}; 
		int[] b = {1,1,1}; 
		
		
		int[] c = addition(a,b); 
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("b: " + Arrays.toString(b));

		System.out.println("Addition of a and b: " + Arrays.toString(c) );
		
		
	}
	
	// addition algorithm
	public static int[] addition(int[] a, int[] b) { 
		
		// resize the arrays if they are not the same length
		// they will have zeroes at the beginning if resized
		if(a.length < b.length ) { 
			a = resizeIntArr(a,b.length); 
		} else if(b.length < a.length) {
			b = resizeIntArr(b,a.length); 
		}
		
		// create new result array with extra length + 1
		int[] r = new int[ a.length + 1] ; 
		
		int carry = 0 ; 
		
		// go backwards adding elements
		for(int i = a.length -1 ; i >= 0; i-- ) { 
			
			// end for
			if(i == 0) { 
				r[i+1] = (a[i] + b[i] + carry) % 10; // mod 10  
				carry = (a[i] + b[i] + carry) / 10; // integer division 10
				r[0] = carry;  // add the last element
				break; 
			}
			
			// mod gets printed in the result
			// integer division ignores mod and gives the value to carry
			r[i+1] = (a[i] + b[i] + carry) % 10; // mod 10  
			carry = (a[i] + b[i] + carry) / 10; // integer division 10
		
		}
		
		return r ; 
	}

	// copies all the elements and insert zeroes to the beginning of the array
	public static int[] resizeIntArr(int[] a, int length) { 

		
		if(length <= a.length) { 
			return a; 
		} else { 
			
			int[] copy = new int[length]; 
			int difference = (length - a.length ) ; 
			
			for(int i = 0 ; i < a.length; i++) { 
				
				copy[difference + i ] = a[i]; 
				
			}
			
			return copy; 
			
		}
		
	}
	
