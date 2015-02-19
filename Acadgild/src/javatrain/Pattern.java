package javatrain;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x =0;
		int y=0;
		String disp ="";
		String dis [] = new String[5];
				
		for (x=1;x<=5;x++){
		
			disp = disp + x ;
			dis [(x-1)] = disp;
			
			System.out.println(disp);
					}
		
		for (y=3;y>=0;y--) {
			
			System.out.println(dis[y]);
		} 
	
		
	}

}
