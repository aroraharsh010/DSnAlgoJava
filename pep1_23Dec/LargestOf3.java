package pep1_23Dec;
public class LargestOf3 
 {

	public static void main(String[] args) 
	{
		int a = 30;
		int b = 20;
		int c = 10;
		/*if (a > b && a > c)
		{
			System.out.println("a = " + a + " is Largest no.");
			return;
		} if (b > a && b > c)
		{
			System.out.println("b= " + b + "is the Largest no.");
			return;

		} 
		{
			System.out.println("c =  " + c + "is the Largest no.");
			
		}*/
		if (a>=b && a>=c)
		     System.out.println("a = " + a + " is Largest no.");
		else if (b>=a && b >=c)
		     System.out.println("b= " + b + "is the Largest no.");	
		else
			 System.out.println("c =  " + c + "is the Largest no.");
			
	}   

}
