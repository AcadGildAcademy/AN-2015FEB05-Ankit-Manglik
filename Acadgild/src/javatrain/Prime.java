package javatrain;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	//for (int num = 1; num<101;num++ ) {
	
	//	if (num%2!=0 && num%3!=0 && num%5!=0 && num%7!=0){
			
	//		System.out.println("Count is: " + num);	
	//	}
				
	//}

		int i =0;
	    int num =0;
	    
	    String primenum ="";
	    
	    for (i = 1; i<=100; i++) {
	    	
	    	int count=0;
	    	System.out.println("i - " + i + "count - " + count);
	    	for( num=i;num>=1;num-- ) {
	    		System.out.println("num - " + num );
	    		if (i%num==0){
	    			count = count +1;
	    			System.out.println("count n- " + count );
	    		}
	    	}
	    	if (count ==2) {
	    		
	    		primenum = primenum + i + " ";
	    		
	    	}
	    	
	    }
	    
		System.out.println(primenum);
		
		
	}
}
