import java.util.Scanner;
import java.util.InputMismatchException;
class Q4{
	static int addone(int a){
		System.out.println("int input");
		return a+1;
	}
	static double addone(double a){
		System.out.println("double input");
		return a+1.0;
	}
	public static void main(String args[]){
		System.out.println(addone(1.0));//compile time polymorphism
		System.out.print("Add one to : ");
		String userInput=new Scanner(System.in).nextLine();
		if(userInput.indexOf('.')==-1)//runtime polymorphism
			System.out.println(addone(new Scanner(userInput).nextInt()));
		else
			System.out.println(addone(new Scanner(userInput).nextDouble()));
	}
}
