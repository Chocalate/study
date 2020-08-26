package thread;
/**
 * 线程通信的应用： 经典例题： 生产者/消费者
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * 
 * 分析：
 * 1、是否是多线程问题？ 是，生产者线程、消费者线程
 * 2、是否有共享数据？是，店员？（或者产品）
 * 3、如何解决线程安全问题？同步机制，有三种方法:同步代码块、同步方法、Lock
 * 4、是否涉及线程通信？是  wait()、notify()、notifyAll()
 * 
 * @author 古丽丽
 *
 */

class Clerk{
	
	private int  proudeCount = 0;

	public synchronized void produce() {
//		System.out.println("生产者开始生产----------------");
		
//		while(true){
//			synchronized(this){
				if(proudeCount < 20){
					/*try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					proudeCount++;
					System.out.println(Thread.currentThread().getName() + ":" + proudeCount);
					notify();
				}else{
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				}
//			}
			
		}
		
		
	}

	public synchronized void consumer() {
//		System.out.println("消费者开始消费----------------");
//		while(true){
//			synchronized(this){
				if(proudeCount > 0){
					/*try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					System.out.println(Thread.currentThread().getName() + ":" + proudeCount);
					proudeCount--;
					notify();
					
				}else{
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
//			}
//			}
			
		
	}
	
}

class Producer extends Thread{
	private Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		   System.out.println(getName() + ":开始生产产品.....");
		while(true){
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.produce();
		}
			
		
	}
	
}

class Consumer extends Thread{

	private Clerk clerk;

	public Consumer(Clerk clerk) {
		
			this.clerk = clerk;
		
		
	}
	
	@Override
	public void run() {
		 System.out.println(getName() + ":开始消费产品.....");
		while(true){
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumer();
		}
	}
}
public class ThreadTest {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer t1 = new Producer(clerk);
		Consumer t2 = new Consumer(clerk);
		Consumer t3= new Consumer(clerk);
		
		t1.setName("生产者线程");
		t2.setName("消费者1线程");
		t3.setName("消费者2线程");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	

	
}
