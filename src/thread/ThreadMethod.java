package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable{
	private int sum = 0;
	@Override
	public Object call() {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i< 10 ; i++){
		
			System.out.println(Thread.currentThread().getName() + ": " + i);
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}
	
}

public class ThreadMethod {

	public static void main(String[] args) {
		
		int sum = 0;
		MyThread t1 = new MyThread();
	    FutureTask<Integer> futuretask = new FutureTask<Integer>(t1);
	    new Thread(futuretask).start();
	    try {
			sum = futuretask.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i< 10 ; i++){
			sum += i;
				
			}
			/*if(i == 5){
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			
		System.out.println(Thread.currentThread().getName() + ": " + sum);

	}

}
