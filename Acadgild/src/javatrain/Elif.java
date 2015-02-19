package javatrain;
import java.util.Scanner;


public class Elif {

	
	public static void main(String[] args) {
		
		int age;
		
		System.out.println("Please enter age");
		
		Scanner age1 = new Scanner(System.in);
		
		age= age1.nextInt();
		
		if (age>18){
			System.out.println("you can vote");
			
		}
		
		else {
			System.out.println("you are too young to vote");
		}
			
		System.out.println(age);
		
		age1.close();
	}

}
