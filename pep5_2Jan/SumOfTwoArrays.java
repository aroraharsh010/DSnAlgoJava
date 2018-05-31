package pep5_2Jan;

public class SumOfTwoArrays {

	public static void main(String[] args) 
	{
      int[] a={3,6,8,5,9};
      int[] b={6,4,8,2};
      int max;
      if (a.length>b.length)
    	  max=a.length;
      else 
    	  max=b.length;
      int[] c= new int[max+1];
      int sum1=0,sum2=0,sum=0;
      for(int i=0;i<a.length;i++)
      {
    	  int p=(int)Math.pow(10, (a.length-i));
    	  sum1+=p;
      }
      for(int i=0;i<b.length;i++)
      {
    	  int p=(int)Math.pow(10, (b.length-i));
    	  sum2+=p;
      }
      sum=sum1+sum2;
      System.out.println(sum);
      for(int i=c.length-1;i>=0;i--)
      {
    	  c[i]=sum%10;
    	  sum/=10;
    	       }
      for(int i=0;i<c.length;i++)
      {
    	  System.out.print(c[i]+",");
      }
	}

}
