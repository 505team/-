/*
 * Date:2018-11-4
 * Auther:����
 * Description������һ���ӿڣ���ʹ��������������ַ�����ʵ�ֽӿ�
 */


package lin.li.task1.test5;



public interface MyList {
	
	//�����������󷽷�
	void add(Object obj);//���б�β����Ӷ���
	void addFirst(Object obj);//���б�ͷ����Ӷ���
	Object get(int index);//���б��л�ȡ����Ϊ index �Ķ���
	void clear();//������еĶ���
	boolean isEmpty();//�ж��б����Ƿ��ж���
	int size();//��ȡ�б��ж���ĸ���
	int capacity();//������Ŀռ��С
}
