import java.util.*;
public class Bus {
	String t1;
	String t2;
	static Customer[][] arr;
	int fare;
	int avl;
	Bus(String t1,String t2,Customer[][] arr,int fare,int avl){
		this.t1=t1;
		this.t2=t2;
		this.arr=arr;
		this.fare=fare;
		this.avl=avl;
	}
	static void avail(Bus a) {
		for(int i=0;i<a.arr.length;i++) {
			for(int j=0;j<a.arr[i].length;j++) {
				if(a.arr[i][j]==null) {
					System.out.print("*");
				}
				else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
	static ArrayList<Bus> buses(){
		ArrayList<Bus> btp=new ArrayList<>();
		btp.add(new Bus("AC","sleeper",new Customer[5][5],650,25));
		btp.add(new Bus("Non-AC","sleeper",new Customer[5][5],500,25));
		btp.add(new Bus("AC","Non-sleeper",new Customer[5][5],500,25));
		btp.add(new Bus("Non-AC","Non-sleeper",new Customer[5][5],400,25));
		return btp;
	}
}
