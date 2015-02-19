package javatrain;
import java.util.Scanner;

public class Vowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String alpha, vow;
		boolean cons;
		
		System.out.println("Please enter an alphabet");
		
		Scanner input = new Scanner(System.in);
		
		alpha = input.next();
		
		System.out.println(alpha);
		
	cons = alpha.equals("a") || alpha.equals("e") || alpha.equals("i") || alpha.equals("o") || alpha.equals("u");
		
		System.out.println(cons);
		
		if (alpha.equals("a") || alpha.equals("e") || alpha.equals("i") || alpha.equals("o") || alpha.equals("u")) {
			
			vow = "vowel";
		} 
		
		else {
			vow = "consonant";
		}
		
		System.out.println(alpha + " is a "+ vow);
		
	}

	
	
}
