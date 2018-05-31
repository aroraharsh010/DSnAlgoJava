package pep4_29Dec;

public class FarenheitToCelsius {

	public static void main(String[] args) 
	{
     int farmin=0,farmax=300,step=20;
     for(int far=farmin;far<=farmax;far+=step)
     {
    	 int cel= (int)((5.0/9)*(far-32));
    	 System.out.println(far+"   "+cel);
     }
     
	}

}
