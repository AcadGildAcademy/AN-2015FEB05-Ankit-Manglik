package exception.com;

public class ChallengeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			int num=Integer.parseInt ("XYZ") ; 
			} 
		catch (NumberFormatException e){System.err.println("Error" + e.getMessage());}
			
		finally {
			System.out.println("/t");
			System.out.println("test");
			
		}
		}
		
		
	}


