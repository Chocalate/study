package mianshi;

public class MyRunnable implements Runnable {

	private int ticket = 10;
	
	@Override
	public void run() {
		//if(ticket > 0){
			

			synchronized (this){
				while(ticket > 0){
			try {
				Thread.sleep(100);
				System.out.println("Runnable" + " " + Thread.currentThread().getName() + " ---" + (this.ticket--) );
				if(ticket < 0) break;
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				//}
			}
		}
		
	}
public static void main(String[] args) {
	MyRunnable mr = new MyRunnable();
	new Thread(mr).start();
	new Thread(mr).start();
	new Thread(mr).start();
}
}
