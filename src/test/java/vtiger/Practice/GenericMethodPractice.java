package vtiger.Practice;

public class GenericMethodPractice {
	
	public static void main(String[] args) {//caller function
		
	  int sum = add(209,400);	
	  System.out.println(sum);
		
	}
	
	public static int  add(int a, int b) // not run unless called in main
	{                         // called function
		
		int c=a+b;
		return c;
	}

}
