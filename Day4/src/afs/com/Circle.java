package afs.com;

import java.util.Scanner;

public class Circle implements Shape{
	int r;
	int l;
	int b;
	final float pi=3.14f;

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		System.out.println("Give Len");
		Scanner inputl= new Scanner(System.in);
		l = inputl.nextInt();
		
		System.out.println("Give Breath");
		Scanner inputb= new Scanner(System.in);
		b = inputb.nextInt();
		inputl.close();
		inputb.close();
	}
	
	void getRadius() {
		System.out.println("Give Radius");
		Scanner inputrad= new Scanner(System.in);
		r = inputrad.nextInt();
	//	inputrad.close();
	}
	
	@Override
	public void getArea() {
		// TODO Auto-generated method stub
		float area;
		
		area = (pi * r);
		System.out.println("Area " + area);
	}

	
}