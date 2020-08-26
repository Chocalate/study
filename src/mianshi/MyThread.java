package mianshi;

public class MyThread extends Thread {

	private int ticket =5;
	//static int ticket=5;//如果把ticket定义为static类型，就离正确结果有近了一步
	                    //（因为是多线程同时访问一个变量会有同步问题，加上锁才是最终正确的代码）。
	
	public void run(){
		/*while(true) {
			System.out.println(Thread.currentThread().getName() + "卖票---->" + ticket--);
			if(ticket < 0){
				break;
			}
		}*/
		if(ticket > 0){
			synchronized (this){
				if(ticket > 0){
				while(true) {
					try {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName() + "卖票---->" + ticket--);
						if(ticket < 0){
							break;
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		/*new MyThread().start();
		new MyThread().start();*///创建了两个MyThread对象，每个对象都有自己的ticket成员变量，当然会多卖1倍
		new Thread(mt).start();//这样虽然是卖了5张票，但是却是有线程同步问题
		new Thread(mt).start();
		new Thread(mt).start();
	}

}
