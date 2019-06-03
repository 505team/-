/*
 * Auther:李琳
 * Date：2018-10-30
 * Title:<<抽象类及抽象方法>>
 * 关键字：abstract
 * PS:抽象方法必须在抽象类里，
 *    抽象方法在父类中时，不能有函数体
 * 	      抽象方法的实现必须是在子类中，
 *    如果子类也是抽象类，可以不用实现抽象方法
 * 	     抽象方法不能通过super关键字调用
 *    Java中的abstract方法基本等同于C++中的纯虚函数
 * 知识扩展：虚函数、纯虚函数的区别
 *    类里声明为虚函数的话,这个函数是实现的，哪怕是空实现，它的作用就是为了能让这个函数在它的子类里面可以被重载，这样的话，这样编译器就可以使用后期绑定来达到多态了
纯虚函数只是一个接口，是个函数的声明而已，它要留到子类里去实现。
 */
public abstract class PetAbstract {
	String name;
	int age;
 public abstract void print();//抽象方法必须在抽象类中；并且不能实现方法体
	
    //抽象子类
 	abstract class Dog extends Pet{
		String strain;
	}
 	//非抽象子类
    class  Cat extends Pet{
    	String sex;
    	public  void print(){
    		System.out.print(name);
    		System.out.print(age);
    		System.out.print(sex);

    	}
    }
	public static void main(String[] args) {
		

	}

}
