package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 有，账户（或账户余额）
 * 3.是否有线程安全问题？有
 * 4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 * 
 * 
 * @author 古丽丽
 *
 */

class Account implements Runnable{

	private int account = 0;
	private ReentrantLock lock = new ReentrantLock();
	
	@Override
	//public synchronized void run() {
	public  void run() {
		//synchronized(this){
		try{
			lock.lock();
			for(int i = 0 ; i < 3; i++){
				account += 1000;
				
			System.out.println(Thread.currentThread().getName() + ":"  + account);
			}
		}finally{
			lock.unlock();
		}
		
	}
	//}
}

public class BankCount {

	public static void main(String[] args) {
		Account account = new Account();
		Thread t1 = new Thread(account);
		Thread t2 = new Thread(account);
		
		t1.setName("甲");
		t2.setName("乙");
		t2.setPriority(10);
		
		t1.start();
		t2.start();
	}
}


