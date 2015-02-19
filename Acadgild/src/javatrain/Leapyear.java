package javatrain;
import java.util.Scanner;



public class Leapyear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int year;
		System.out.println("Please give year");
		
		Scanner input = new Scanner(System.in);
		
		year = input.nextInt();
		
		if (year%100==0){
			
			if (year%400==0){
				System.out.println(year + " is a leap year");
				
			}
			else if(year%4==0) {
				
				System.out.println(year + " is a leap year");
			}
		
		
		}
		
		else {
			System.out.println(year + " is not a leap year");
			
		}
	}

}
