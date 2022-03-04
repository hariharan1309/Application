package bus;
import java.util.*;
public class Main {
	static Scanner get=new Scanner(System.in);
	static void uOp(Customer aa,ArrayList<Bus> bb) {
		int x=1;
		while(x<=7) {
			System.out.println("Enter the Operation");
			System.out.println("> 1_Booking\n> 2_Availability\n> 3_Cancellation\n> 4_Summary\n> 5_Logout");
			x=get.nextInt();
			get.nextLine();
			switch (x) {
				case 1: 
					boolean b3=true;
					System.out.println("AC/Non-AC");
					String a1=get.nextLine();
					System.out.println("sleeper/Non-sleeper");
					String b1=get.nextLine();
					for(Bus ak:bb) {
						if(ak.t1.equals(a1) && ak.t2.equals(b1)) {
							book(aa,ak);
							b3=false;
							break;
							}
						}
					if(b3==true) {
						System.out.println("Retry !!!");
					}
					break;
				case 2:
					boolean b=true;
					System.out.println("AC/Non-AC");
					String s=get.nextLine();
					System.out.println("sleeper/Non-sleeper");
					String s2=get.nextLine();
					for(Bus ak:bb) {
						if(ak.t1.equals(s) && ak.t2.equals(s2)) {
							System.out.println("Driver");
							Bus.avail(ak);
							b=false;
							break;
							}
						}
					if(b==true) {
						System.out.println("Retry !!!");
					}
					break;
				case 3:
					boolean b2=true;
					System.out.println("AC/Non-AC");
					String s1=get.nextLine();
					System.out.println("sleeper/Non-sleeper");
					String s11=get.nextLine();
					for(Bus ak:bb) {
						if(ak.t1.equals(s1) && ak.t2.equals(s11)) {
							cancel(aa,ak);
							b2=false;
							break;
							}
						}
					if(b2==true) {
						System.out.println("Retry !!!");
					}
					break;
				case 4:
					for(String str:aa.arr) {
						System.out.println(str);
					}
					break;
				case 5:
					main(null);
					
				default:
					System.out.println("You entered a Unvalid request");
			}
			
		}
	}
	static void uLogin(ArrayList<Customer> a,ArrayList<Bus> b){
		System.out.println("Enter the id");
		String id=get.nextLine();
		System.out.println("Enter the pass");
		String ps=get.nextLine();
		int t=0;
		for(Customer aa:a) {
			if(aa.Uid.equals(id)) {
				
				if(aa.pass.equals(ps)) {
					uOp(aa, b);
				}
				else {
					System.out.println("Password doesn't Match !!!");
					uLogin(a,b);
				}
				
			}
			else {
				t++;
			}
		}
		if(t==a.size()) {
			System.out.println("User not found\n Retry !!!");
			main(null);
		}
	}
	static void cancel(Customer a,Bus b) {
		int t=0;
		int k=0;
		for(int i=0;i<b.arr.length;i++) {
			for(int j=0;j<b.arr[i].length;j++) {
				if(b.arr[i][j]==a) {
					b.arr[i][j]=null;
					t=1;
					k++;
				}
			}
		}
		if(t==0) {
			System.out.println("Your Booking not found");
		}
		else {
			System.out.println(b.fare*k+" will be returned soon...");
			a.arr.add("Cancelled "+k+" seats ");
		}
	}
	static void book(Customer a,Bus b) {
		System.out.println("Enter the No of Seats:");
		int n=get.nextInt();
		if(b.avl-n<0) {
			System.out.println("No of seats are lesser ...\n Please Check the Availability");
		}
		else {
		int n1=n;
		int fr=0;
		Hari:
		while(n1>0) {
			System.out.println("Enter the seat Number :");
			int val=1;
			int sn=get.nextInt();
			for(int j=0;j<b.arr.length;j++) {
				for(int k=0;k<b.arr[j].length;k++) {
					if(val==sn) {
						if(b.arr[j][k]==null) {
							b.arr[j][k]=a;
							n1--;
							fr+=b.fare;
							System.out.println("The seat "+sn+" is Booked");
							continue Hari;
						}
						else {
							System.out.println("The seat Already is Booked Please Retry !!!");
							continue Hari;
						}
					}
					else {
						val++;
						}
					}
				}
			}
			System.out.println(fr+"will be charged !!!");
			a.arr.add("Booked the "+n1+"seats for"+fr);
		}
	}
	static void create(ArrayList<Customer> a,ArrayList<Bus> b) {
		System.out.println("Enter an Id Name");
		String s1=get.nextLine();
		System.out.println("Enter Your Name");
		String s2=get.nextLine();
		System.out.println("Enter your Gender");
		String gen=get.nextLine();
		System.out.println("Enter your Mobile Number");
		String num=get.nextLine();
		System.out.println("Enter a password");
		String p1=get.nextLine();
		System.out.println("Re-enter the password");
		String p2=get.nextLine();
		while(p1.equals(p2)!=true) {
			System.out.println("Miss match");
			System.out.println("Enter a password");
			p1=get.nextLine();
			System.out.println("Re-enter the password");
			p2=get.nextLine();
		}
		a.add(new Customer(s1,s2,gen,num,p1,new ArrayList<String>()));
		System.out.println("Signuped Successfully");
		uOp(new Customer(s1,s2,gen,num,p1,new ArrayList<String>()),b);
		
	}
	public static void main(String[] args) {
		ArrayList<Customer> cuss=Customer.cust();
		ArrayList<Bus> buss=Bus.buses();
		System.out.println("Welcome !!!");
		System.out.println("> 1_Sign-up\n> 2_Login\n> 3_Exit");
		int x=get.nextInt();
		get.nextLine();
		if(x==1) {
			create(cuss,buss);
		}
		else if(x==2){
			uLogin(cuss,buss);
		}
		else {
			System.out.println("Thank you !!!");
		}
	}
}
