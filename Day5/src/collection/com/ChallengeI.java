package collection.com;

import java.util.ArrayList;
import java.util.Iterator;

public class ChallengeI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> i = new ArrayList();
		
		i.add("A");
		i.add("c");
		i.add("d");
		i.add("b");
		i.add("x");
		i.add("f");
		
		System.out.println("Original list: ");
		
		Iterator it = i.iterator();
		while (it.hasNext()){
			Object element = it.next();
			System.out.println(element + " ");
		
		}
	
		
		
		
	}

}
