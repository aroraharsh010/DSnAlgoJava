package pep1_23Dec;
import java.util.Scanner;
public class ReverseOfNum {


 

   public static void main(String args[])
   {
      int n, r = 0;
 
      
      Scanner scn = new Scanner(System.in);
      n = scn.nextInt();
 
      while( n != 0 )
      {
          r = r * 10;
          r = r + n%10;
          n = n/10;
      }
 
      System.out.println(r);
   }
}


