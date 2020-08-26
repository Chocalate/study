package mianshi;

import java.util.Scanner;

public class Test01 {
	     static String s;
	     String x= "8";
	     String y;
	     /*string类型在代码中属于局部变量，那么局部变量必须赋值，哪怕是null,否则编译通不过的，
	      * 会提示说此变量未初始化，如果是类的成员变量，则可以不赋值，它会有默认值的。
	java为了规避一些运行期间的空指针错误，都会强调局部变量必须赋值，
	否则编译器会立即报错，提示用户修改。 */
	    public static void main (String[] args){

	       Test01 t = new Test01();
	        System.out.println(t.s);//输出null
	        System.out.println(t.x);//输出null
	     //   System.out.println(y);//报错,没有初始化,或者不是类静态变量
	        //方法中不能调用类的非静态变量属性??哪怕已经初始化.
	        System.out.println("s=" + s);//输出null
	        
	        float x=4;
	        double b=1;
	        
	        System.out.println((short)x/b*2);
	        

	        Scanner scanner = new Scanner(System.in);
	        
	        int nextInt = scanner.nextInt();
	    }

	}