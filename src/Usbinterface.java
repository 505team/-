/*
 * Auther:李琳
 * Date：2018-10-30
 * Title：<<接口>>
 * 使用interface关键字定义接口
 * PS：
 * 	接口的特点;所有方法都是public和abstract的，不能实现方法体
 *  接口中可以定义变量，并且变量自动是静态的
 *  接口不可以被直接实例化，但是可以当成类型使用
 *  实现类必须实现接口的所有方法
 *  抽象类可以不实现接口的方法
 *  一个实现类可以实现多个接口，这是Java中多继承的实现方法
 */

//import java.util.Date;
public interface  Usbinterface {
   /*
    * USB接口提供的服务
    */
	void service();//不能实现函数体
	
	//实现类必须实现接口的所有方法
	public class UDisk implements Usbinterface{
		public void service(){
			System.out.println("连接USB口，开始传输数据。");
		}
	
	}
	//实现“充电数据线插入USB接口”
	public class ULine implements Usbinterface{
		private double electric ;//充电量0%- 100%
		private int  date;// 充电时间1-2小时
		
		public void service(){
			System.out.println("连接USB口，开始传输数据。");
	
		}
		
		
		//添加Line接口自身的特殊方法
		public void  show_ULine_Infor(){//现实Line的信息
			//将"充电数据线(Line)"插入Usbinterface
			System.out.println("已连接，正在充电");
            setDate(1);//设置已连接时间
            setElectric(0.80);
			System.out.println("充电量:" + electric);
			System.out.println("充电时间:" + date);
		}

		public double getElectric() {
			return electric;
		}

		public void setElectric(double electric) {
			this.electric = electric;
		}

		public int getDate() {
			return date;
		}

		public void setDate(int date) {
			this.date = date;
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args){
		//先编码实现UDisk接口；然后进行如下的使用
		Usbinterface uDisk = new UDisk();
		uDisk.service();
		Usbinterface uLine = new ULine();

	}
}
