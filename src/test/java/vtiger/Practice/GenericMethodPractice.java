package vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		
		int sum = add(20,40);
		System.out.println(sum);
	}

	public static int add(int a, int b) {		//it'll not run unless called in main()
			
		int c = a+b;
		return c;
	}

}
