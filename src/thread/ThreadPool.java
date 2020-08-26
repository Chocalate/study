package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;



/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 * 面试题：创建多线程有几种方式？四种！
 * @author shkstart
 * @create 2019-02-15 下午 6:30
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
		//1. 提供指定线程数量的线程池
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
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
	  
		// //3.关闭连接池
		service.shutdown();

	}

}
