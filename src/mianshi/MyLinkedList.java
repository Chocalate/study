package mianshi;

import java.util.LinkedList;
import java.util.List;

class People{
	public People(){}
	private int age;
	private String name;
	
	public void print(){
		System.out.println("name=" + name );
	}
}
public class MyLinkedList {
	static String b;
	private String banji;
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList();
		list.add("a");
		list.add(1,"b");
		System.out.println(list.toString());
		
		String s = null;//String s;//һ��Ҫ��ʼ��������ᵼ�±����쳣
		System.out.println("s=" + s);
		System.out.println("b=" + b);
		
		
		String [] str = new String[]{"����","lisi","wangwu"};
		for(String a : str){
			System.out.println(a);
		}
		
		People people =new People();
		people.print();
		
		MyLinkedList my = new MyLinkedList();
		System.out.println(my.banji);
	}

}
