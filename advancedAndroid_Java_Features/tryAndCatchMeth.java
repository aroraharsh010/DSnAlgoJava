package advancedAndroid_Java_Features;

import java.util.Arrays;

public class tryAndCatchMeth {

	public static void main(String[] args) 
	{
      int[] A=new int[3];
      try {
      for(int i=0;i<4;i++)
      {
    	  A[i]=i;
      }
      
      
	}
      catch(Exception e)
      {
    	  System.out.println(e);
      }
      System.out.println(Arrays.toString(A));
      }
      

}
