/*
 * Date:2018-11-4
 * Auther:李琳
 * Description：定义一个接口，并使用数组和链表两种方法来实现接口
 */


package lin.li.task1.test5;



public interface MyList {
	
	//包含六个抽象方法
	void add(Object obj);//往列表尾部添加对象
	void addFirst(Object obj);//向列表头部添加对象
	Object get(int index);//从列表中获取索引为 index 的对象
	void clear();//清空所有的对象
	boolean isEmpty();//判断列表中是否有对象
	int size();//获取列表中对象的个数
	int capacity();//所分配的空间大小
}
