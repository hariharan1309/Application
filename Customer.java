package bus;
import java.util.ArrayList;
public class Customer {
	String Uid;
	String Name;
	String gen;
	String num;
	ArrayList<String> arr; 
	String pass;
	Customer(String Uid,String Name,String gen,String num,String pass,ArrayList<String> arr){
		this.Uid=Uid;
		this.Name=Name;
		this.gen=gen;
		this.num=num;
		this.pass=pass;
		this.arr=arr;
	}
	static ArrayList<Customer> cust(){
		ArrayList<Customer> cus=new ArrayList<>();
		cus.add(new Customer("111","aaa","M","111","111",new ArrayList<String>()));
		cus.add(new Customer("222","bbb","M","222","222",new ArrayList<String>()));
		cus.add(new Customer("333","ccc","F","333","333",new ArrayList<String>()));
		return cus;
	}
}
