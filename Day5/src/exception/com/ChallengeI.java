package exception.com;

import java.util.Arrays;

public class ChallengeI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result;
		int num[]= new int[5];
		num[1] = 6;
		
		try {
			
		num[6] = 12;
		} catch (ArrayIndexOutOfBoundsException e) {e.printStackTrace();
		}
		finally{
		result = num[1];
		System.out.println("Num " + result);
		}
	}

}
