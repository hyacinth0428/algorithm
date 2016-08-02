package Threading;

public class Consumer implements Runnable{
	private MyQueue queue;
	public Consumer(MyQueue q) {this.queue = q;}
	@Override
	public void run(){
		System.out.println("trying to read");
		while(true){
			try {
				System.out.println("Consumer reads : " + queue.read());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("failed!");
			}
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
