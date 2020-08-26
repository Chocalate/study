package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;



/**
 * �����̵߳ķ�ʽ�ģ�ʹ���̳߳�
 *
 * �ô���
 * 1.�����Ӧ�ٶȣ������˴������̵߳�ʱ�䣩
 * 2.������Դ���ģ��ظ������̳߳����̣߳�����Ҫÿ�ζ�������
 * 3.�����̹߳���
 *      corePoolSize�����ĳصĴ�С
 *      maximumPoolSize������߳���
 *      keepAliveTime���߳�û������ʱ��ౣ�ֶ೤ʱ������ֹ
 *
 *
 * �����⣺�������߳��м��ַ�ʽ�����֣�
 * @author shkstart
 * @create 2019-02-15 ���� 6:30
 */

class Number1{
	
}

class NumberThread1 implements Runnable{

	@Override
	public void run() {
		synchronized(Number1.class){
		for(int i = 0; i<= 100 ; i++){
			if(i % 2 != 0){
				System.out.println(Thread.currentThread().getName() + ": " + i);
				(Number1.class).notify();
			}else{
				try {
					(Number1.class).wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	}
	
}

class NumberThread2 implements Runnable{

	@Override
	public void run() {
		synchronized(Number1.class){
		for(int i = 0; i<= 100 ; i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() + ": " + i);
				(Number1.class).notify();
			}else{
				try {
					(Number1.class).wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	}
	
}

class NumberThread3 implements Callable{
  
	private int sum = 0;
	@Override
	public Object call() throws Exception {
		for(int i = 0; i< 10 ; i++){
			sum += i;
		}
		return sum;
	}

	
	
}
public class ThreadPool {

	public static void main(String[] args) {
		//1. �ṩָ���߳��������̳߳�
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//2.ִ��ָ�����̵߳Ĳ�������Ҫ�ṩʵ��Runnable�ӿڻ�Callable�ӿ�ʵ����Ķ���
		service.execute(new NumberThread1());
		service.execute(new NumberThread2());
		
	   FutureTask future= (FutureTask) service.submit(new NumberThread3());
	   
	   try {
		   Object o = future.get();
		   System.out.println("sum=" + o);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		// //3.�ر����ӳ�
		service.shutdown();

	}

}
