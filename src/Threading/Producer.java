package Threading;

import java.util.Queue;

public class Producer implements Runnable{
	private MyQueue queue;
	private long sleep;
	private String name;
	public Producer(MyQueue q, long sl, String name){
		this.queue = q;
		this.sleep = sl;
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(name + " is started");
		// TODO Auto-generated method stub
		int cnt = 0;
		while(cnt < 100){
			System.out.println(name + "adding to queue");
			try {
				queue.add(name + " " + String.valueOf(cnt++));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
