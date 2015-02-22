package afs.com;

public class Rectangle {
		int length;
		int breath;
		int area;
	 public Rectangle(int l, int b)
	     {
	              length = l;
	              breath = b;
	              
	     }
		
		void Area(){
	 area = length * breath;
		 }
	    
		void Display()
	      { Area();
	    	  System.out.println("Lenght: " + length);
	    	  System.out.println("Breath: " + breath);
	    	  System.out.println("Area Rec: " + area);
	           
	       }
	}

