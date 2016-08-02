package Threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyQueue<T> {
	private Queue<T> queue;
	private int capacity = 20;
	//private Object lock;
	private final ReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock rLock = rwl.readLock();
	private final Lock wLock = rwl.writeLock();
	//private final Object mutex = new Object();
	//private final Object mutex1 = new Object();
	public MyQueue(){
		this.queue  = new LinkedList<>();
		//this.lock = new Object();
		//this.capacity = capacity;
	}
	
	public synchronized void add(T obj) throws InterruptedException{
		wLock.lock();
		//while(this.queue.size() == this.capacity){
		//		wait();
		//}
		queue.offer(obj);
		//notifyAll();
		wLock.unlock();
		//System.out.println("writing done");
	}
	public synchronized T read() throws InterruptedException{
		//while(queue.size() == 0){
		//	wait();
		//}
		rLock.lock();
		T res = queue.poll();
		//notifyAll();
		rLock.unlock();
		return res;
	}
}
