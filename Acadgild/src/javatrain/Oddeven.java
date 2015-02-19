package javatrain;
import java.util.Scanner;


public class Oddeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;
		
		System.out.println("Please enter a number");
		
		Scanner input = new Scanner(System.in);
		
		num = input.nextInt();
		
		if (num%2==0){
			System.out.println("This is a even number");
		}
		else {
			
			System.out.println("This is an odd number");
		}
		
		
	}

}
