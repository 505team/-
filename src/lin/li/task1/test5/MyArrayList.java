


package lin.li.task1.test5;

import java.util.regex.Pattern;

public  class MyArrayList implements MyList {
		private static int incSize = 5;//数组增量
        private static Object[] dates = null;//内部数组，用于装对象
        int count = 0 ;//size()函数里面用于计数
        
        //构造函数
		MyArrayList(int incSize){
		if(incSize < 1){
			this.incSize = 5;//输入数字不合法时，默认设置为5
			this.dates = new Object[5];
			this.count = 0 ;
		}
		else{
		this.incSize = incSize;
		this.dates = new Object[incSize];
		}
		}
		

		public static void main(String[] args){
			MyArrayList arraylist = new MyArrayList(10);
		    
		
		}
		
		@Override
		public void add(Object obj) {
			// TODO Auto-generated method stub
		for(int i = 0 ;i < this.dates.length ; i ++ ){
			if(this.dates[i] == null){
				this.dates[i] = obj;
				System.out.println("在内部数组尾部增加了一个对象！"+obj);
				return ;
			}
		}
            		
		}
		@Override
		public void addFirst(Object obj) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Object get(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int capacity() {
			
			return 0;
		}
		
	

	
	
	
	public  int getIncSize() {
		return incSize;
	}

	public void setIncSize(int incSize) {
		MyArrayList.incSize = incSize;
	}
	
}
