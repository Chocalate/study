package mianshi;

import java.util.Scanner;

public class Test01 {
	     static String s;
	     String x= "8";
	     String y;
	     /*string�����ڴ��������ھֲ���������ô�ֲ��������븳ֵ��������null,�������ͨ�����ģ�
	      * ����ʾ˵�˱���δ��ʼ�����������ĳ�Ա����������Բ���ֵ��������Ĭ��ֵ�ġ�
	javaΪ�˹��һЩ�����ڼ�Ŀ�ָ����󣬶���ǿ���ֲ��������븳ֵ��
	���������������������ʾ�û��޸ġ� */
	    public static void main (String[] args){

	       Test01 t = new Test01();
	        System.out.println(t.s);//���null
	        System.out.println(t.x);//���null
	     //   System.out.println(y);//����,û�г�ʼ��,���߲����ྲ̬����
	        //�����в��ܵ�����ķǾ�̬��������??�����Ѿ���ʼ��.
	        System.out.println("s=" + s);//���null
	        
	        float x=4;
	        double b=1;
	        
	        System.out.println((short)x/b*2);
	        

	        Scanner scanner = new Scanner(System.in);
	        
	        int nextInt = scanner.nextInt();
	    }

	}