package afs.com;
import java.util.Scanner;

public class EntryClass {

	static int len;
	static int br;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Give Length");
		Scanner inputl = new Scanner(System.in);
		len= inputl.nextInt();
		System.out.println("Give Length");
		Scanner inputb = new Scanner(System.in);
		br=inputb.nextInt();
		
		
		Triangle t=new Triangle(len, br);
		Rectangle r=new Rectangle(len,br);
		t.Display();		
		r.Display();
		inputl.close();
		inputb.close();
	}

}