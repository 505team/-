



/*Date:2018-10-30
 * Auther:李琳
 * TiTle:<<宠物之家>>
 * 继承及继承的使用
 */
import java.util.Scanner;
public class Pet {
	private String name = "Unknow";
	private int health = 100;
	private int love = 0;
	public void print(){
		System.out.println("=======================");
		System.out.println("name :" + name );
		System.out.println("health :" + health );
		System.out.println("love :" + love );

	}
	Pet(){
		
	}
	Pet(String name){
		this.setName(name);
	}
	
	//继承
	class Dog extends Pet{
		private String strain;

		public String getStrain() {
			return strain;
		}

		public void setStrain(String strain) {
			this.strain = strain;
		}
		Dog(){
			super();//因为构造函数不能被继承，所以若想要继承使用父类的构造函数，请使用super关键字，放在子类构造方法的第一句
			//dogcount ++ ;
		}
		
		 Dog(String name){
			this.setName(name);
			//dogcount ++   ;
		}
		
		public void print(){
			//System.out.println("----这是第 " + dogcount + " 只 dog----");
			super.print();//继承父类的方法
			System.out.println("strain:" + strain);//添加新的功能	
		}
		
		
		
	}
	
	
	
	class Penguin extends Pet{
		private String sex;
		static final String SEX_MALE = "Q仔";
		static final String SEX_FEMALE = "Q妹";
		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}
		Penguin(){
			super();//继承父类的构造函数
		}
		public void print(){
			super.print();//继承父类的方法
			System.out.println("sex:" + sex);//添加新的功能
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
	
	System.out.println("**************宠物之家***********");
	int petcount  = 0 ;
	System.out.println("您打算领取几个宠物？");
	Scanner input = new Scanner(System.in);
	petcount = input.nextInt();
	for(int i = 0 ; i < petcount ; i++){
		System.out.println("宠物分类\n1.Dog\n2.Penguin\n输入选项：");
		Pet pet = new Pet();
		int isright = 0;
		do{
		String  choose = input.nextLine();
		switch(choose){
		case "1":
			Dog dog1 = pet.new Dog("旺财");
			dog1.setHealth(95);
			dog1.setLove(30);
			dog1.setStrain("接飞盘");
				dog1.print();
			isright = 0 ;
			break;
		case "2":
			 Penguin p1 = pet.new Penguin();
				    p1.sex = p1.SEX_MALE;
				    p1.setHealth(90);
				    p1.setLove(10);
				    p1.setName("小Q");
				    p1.print();
			isright = 0 ;
			break;
		default:
			isright = 1;//控制循环，预防非法输入
			break;
		}
		}while(isright == 1);

	}
	
	System.out.println("          **********>>领养完成，请好好爱护它哦！！<<**********");
	
	
	
	
	/*
	Pet pet = new Pet();
    pet.print();
	Dog dog3 =pet. new Dog("旺财")	;
	Dog dog4 = pet.new Dog();
		dog3.print();
		dog4.print();
   Penguin p4 = pet.new Penguin();
   Penguin p5 = pet.new Penguin();
   Penguin p6 = pet.new Penguin();
	    p4.sex = p4.SEX_MALE;
	    p4.setName("小Q");
	    p5.setName("大Q");
		p5.sex = p5.SEX_FEMALE;
		p4.print();
		p5.print();
		p6.print();
		*/
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public void setName(String name) {
		this.name = name;
	}

}
