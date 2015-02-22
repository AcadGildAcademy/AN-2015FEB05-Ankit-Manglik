package tread.com;

public class Treadchild implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int c =1;c<10;c++){
			int count = c;
			
			System.out.println("Count - " + count);
			
		}
		
		
		
	}

}
