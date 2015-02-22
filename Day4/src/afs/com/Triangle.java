package afs.com;

class Triangle extends Rectangle {
	int length, breath;
	float area;
	
	public Triangle(int l, int b) {
		super(l, b);
		length = l;
		breath = b;
		
		
		// TODO Auto-generated constructor stub
	}
	
@Override
void Display()
     {
           
	
	super.Display();    
	area = (float) 1/2 * length* breath;
	System.out.println("Area of T: " + area);
	
	
     }
	 
	}
	
		
		
		

		
		

