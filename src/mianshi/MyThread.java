package mianshi;

public class MyThread extends Thread {

	private int ticket =5;
	//static int ticket=5;//�����ticket����Ϊstatic���ͣ�������ȷ����н���һ��
	                    //����Ϊ�Ƕ��߳�ͬʱ����һ����������ͬ�����⣬����������������ȷ�Ĵ��룩��
	
	public void run(){
		/*while(true) {
			System.out.println(Thread.currentThread().getName() + "��Ʊ---->" + ticket--);
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
						System.out.println(Thread.currentThread().getName() + "��Ʊ---->" + ticket--);
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
		new MyThread().start();*///����������MyThread����ÿ���������Լ���ticket��Ա��������Ȼ�����1��
		new Thread(mt).start();//������Ȼ������5��Ʊ������ȴ�����߳�ͬ������
		new Thread(mt).start();
		new Thread(mt).start();
	}

}
