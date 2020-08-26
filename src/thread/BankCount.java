package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * ������һ���˻���
 * �����������ֱ���ͬһ���˻���3000Ԫ��ÿ�δ�1000����3�Ρ�ÿ�δ����ӡ�˻���
 * ������
 * 1.�Ƿ��Ƕ��߳����⣿ �ǣ����������߳�
 * 2.�Ƿ��й������ݣ� �У��˻������˻���
 * 3.�Ƿ����̰߳�ȫ���⣿��
 * 4.��Ҫ������ν���̰߳�ȫ���⣿ͬ�����ƣ������ַ�ʽ��
 * 
 * 
 * @author ������
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
		
		t1.setName("��");
		t2.setName("��");
		t2.setPriority(10);
		
		t1.start();
		t2.start();
	}
}


