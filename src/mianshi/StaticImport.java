package mianshi;

public class StaticImport {
		     
		       public StaticImport() {
		          System.out.println("a");//���췽����new��ʱ��Ż���֣��Һ��ڱ����Ĵ���
		      }
		      
		      
		      
		     public static void sayOther(String s){
		          System.out.println(s);
		     }
		     
		     
		     
		     public int say(String s){
		         System.out.println(s);
		         return 0;
		     }
		      
		      
		      //��ʼ���飬��newʱ�����췽��֮ǰ,����֮ǰִ��
		      {
		          System.out.println("c");
		         inner.innerMethed("d");
		     }
		     
		      
		      private static inner t= new inner();//��̬��������Щ�������������֮ǰ�ͷ����ڴ��У���ֻ������һ�Σ�new�����ʱ�ǲ����ٴ�ִ�е��ˡ�
		      static
		      {
		          System.out.println("e");
		          inner.innerMethed("f");//��̬��ʼ���飬������̬�Ķ����ڼ���֮ǰ�����ó�ʼ����
		         new inner();
		     }
		     
		      
		     private int i=say("g");//��newʱ�����ڹ��쵫�Ǻ��ڳ�ʼ�����һ��ʵ��������Ҳ����ʵ�����󣺣�ʵ����ʼ���飬ʵ��������--->���췽��
		     private inner tt=new inner();//�������������ClassLoader֮���ʼ������ʱ��������ÿ��new���󶼻�ִ�������������
		     private innerOther ttt=new innerOther();
		     
		     
		     
		     static class inner{
		         
		         
		          public inner(){
		              System.out.println("h");
		         }
		         
		        
		        public static void innerMethed(String s){
		              System.out.println(s);
		         }
		        
		       
		         
		         {
		             System.out.println("i");
		         }
		        
		       
		         
		          static
		         {
		             System.out.println("j");
		         }
		         
		         
		     }
		     
		     
		      
		     class innerOther{
		         
		         
		         public innerOther(){
		            System.out.println("k");
		          }
		          
		          
		          {
		              System.out.println("l");
		          }
		       
		          
		     }
		     
		    public static void main(String[] args) {
		         System.out.println("m");
	             StaticImport outer = new StaticImport();
		         System.out.println("n");
		         
		         //�ܽ���ǣ�����󣬱����ļ���˳��
		         //��������������֮�󣬾ͳ�ʼ����̬����̬��������̬�飩�����п���new���󣬱������þ�̬��������̬��ֻ����һ�Σ�Ȼ���������ClassLoader�Ͱ���Class������ִ��main������
		          //��new�����ʱ��ִ��˳���ǣ���ʵ����ʼ���飬ʵ��������-->���췽����ÿnewһ������ʱ������ִ��������衣
		        
		        //����̬��������̬��ʼ���飩���� �� ����������ʼ���飩���� �� ���캯���������е������ǰ��մ���ǰ��ѭ��ִ��
		       
		         //���м̳й�ϵʱ�����ǻ������ԭ����new Son������
		        //����ľ�̬����ͱ�����-->����ľ�̬����ͱ�����-->����ģ���ͱ���+���췽����-->����ģ���ͱ���+���췽����
		         //	

		     }
		 }

