package overr.com;


// Method Overriding problem
import java.util.Scanner;

public class Bank {
	double rbirt;
	
	void intrate(){ 
		System.out.println("Input int rate");
		Scanner inputi = new Scanner(System.in);
		rbirt = inputi.nextDouble();
		inputi.close();
	}

	void display(){
		System.out.println("Int Rate: " + rbirt);
	}
	
}