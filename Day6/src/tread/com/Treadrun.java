package tread.com;

class Treadrun {

public static void main(String[] args) {
	
	Thread d = new Thread(new Treadeg(), "dummy");
	Thread b = new Thread(new Treadeg(), "boost");
	Thread l = new Thread(new Treadeg(), "last");
	Thread c = new Thread(new Treadchild(), "count");
	
	d.setPriority(9);
	b.setPriority(5);
	l.setPriority(1);
	
	l.start();
	d.start();
	b.start();
	c.start();
	
}

}