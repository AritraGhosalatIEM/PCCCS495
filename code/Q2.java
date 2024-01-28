class Parent{
	String parent_var;
	Parent(){
		parent_var="Parent";
	}
	void parent_method(){
		System.out.println("Method defined in different class");
	}
}
class Sub extends Parent{
	void display(){
		parent_method();
		System.out.println("This variable is defined in : "+parent_var);
	}
}
class Q2 extends Parent{
	public static void main(String args[]){
		Sub sub=new Sub();
		sub.display();
	}
}
