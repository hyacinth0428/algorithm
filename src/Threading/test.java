package Threading;

import java.util.Arrays;

// 56.KMP.
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] repeatTable = {1,2,3,45};
		//System.out.println(Arrays.asList(repeatTable).toString());
		double k = Math.random() * 5;
		MyQueue<String> q = new MyQueue<String>();
		Producer p1 = new Producer(q,400,"Producer #1");
		Producer p2 = new Producer(q,800,"Producer #2");
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	
	}

}
