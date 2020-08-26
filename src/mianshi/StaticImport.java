package mianshi;

public class StaticImport {
		     
		       public StaticImport() {
		          System.out.println("a");//构造方法，new的时候才会出现，且后于变量的创建
		      }
		      
		      
		      
		     public static void sayOther(String s){
		          System.out.println(s);
		     }
		     
		     
		     
		     public int say(String s){
		         System.out.println(s);
		         return 0;
		     }
		      
		      
		      //初始化块，在new时，构造方法之前,变量之前执行
		      {
		          System.out.println("c");
		         inner.innerMethed("d");
		     }
		     
		      
		      private static inner t= new inner();//静态变量，这些都是在类加载完之前就放于内存中，且只加载这一次，new类对象时是不会再次执行的了。
		      static
		      {
		          System.out.println("e");
		          inner.innerMethed("f");//静态初始化块，整个静态的都是在加载之前就做好初始化。
		         new inner();
		     }
		     
		      
		     private int i=say("g");//在new时，先于构造但是后于初始化块的一个实例变量，也即：实例对象：（实例初始化块，实例变量）--->构造方法
		     private inner tt=new inner();//整个是在类加载ClassLoader之后初始化变量时，才做。每个new对象都会执行上面这个步骤
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
		         
		         //总结就是：类对象，变量的加载顺序
		         //在整个类加载完成之后，就初始化静态（静态变量，静态块），其中可以new对象，别的类调用静态方法。静态的只做这一次，然后类加载器ClassLoader就把类Class返还，执行main方法。
		          //在new类对象时，执行顺序是：（实例初始化块，实例变量）-->构造方法。每new一个对象时，都会执行这个步骤。
		        
		        //（静态变量、静态初始化块）—— 》 （变量、初始化块）—— 》 构造函数，（）中的内容是按照代码前后循序执行
		       
		         //当有继承关系时，还是基于这个原理，如new Son（）；
		        //父类的静态（块和变量）-->子类的静态（块和变量）-->父类的（块和变量+构造方法）-->子类的（块和变量+构造方法）
		         //	

		     }
		 }

