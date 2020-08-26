package thread;
/**
 * �߳�ͨ�ŵ�Ӧ�ã� �������⣺ ������/������
 * ������(Productor)����Ʒ������Ա(Clerk)����������(Customer)�ӵ�Ա��ȡ�߲�Ʒ��
 * ��Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ(����:20���������������ͼ��������Ĳ�Ʒ����Ա
 * ���������ͣһ�£���������п�λ�Ų�Ʒ����֪ͨ�����߼����������������û�в�Ʒ
 * �ˣ���Ա����������ߵ�һ�£���������в�Ʒ����֪ͨ��������ȡ�߲�Ʒ��
 * 
 * ������
 * 1���Ƿ��Ƕ��߳����⣿ �ǣ��������̡߳��������߳�
 * 2���Ƿ��й������ݣ��ǣ���Ա�������߲�Ʒ��
 * 3����ν���̰߳�ȫ���⣿ͬ�����ƣ������ַ���:ͬ������顢ͬ��������Lock
 * 4���Ƿ��漰�߳�ͨ�ţ���  wait()��notify()��notifyAll()
 * 
 * @author ������
 *
 */

class Clerk{
	
	private int  proudeCount = 0;

	public synchronized void produce() {
//		System.out.println("�����߿�ʼ����----------------");
		
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
//		System.out.println("�����߿�ʼ����----------------");
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
		   System.out.println(getName() + ":��ʼ������Ʒ.....");
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
		 System.out.println(getName() + ":��ʼ���Ѳ�Ʒ.....");
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
		
		t1.setName("�������߳�");
		t2.setName("������1�߳�");
		t3.setName("������2�߳�");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	

	
}
