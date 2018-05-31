package pep4_29Dec;

import java.util.Scanner;

public class PlayWithBits {

	public static void main(String[] args) 
	{
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     int biPos=scn.nextInt();
     int bitMask=1<<biPos;
     int bitmask2=~bitMask;
     int numSwitchon=n;
     int numSwitchoff=n;int numSwitchToggle=n;
     numSwitchon=numSwitchon|bitMask;
     numSwitchoff=numSwitchoff&bitmask2;
     numSwitchToggle^=bitMask;
     
     /*if ((bitMask&n)==0)
    	 numSwitchToggle=numSwitchToggle|bitMask;
     else 
    	 numSwitchoff=numSwitchoff&bitmask2;*/
     System.out.println(Integer.toBinaryString(n));
     System.out.println(Integer.toBinaryString(numSwitchon));
     System.out.println(Integer.toBinaryString(numSwitchoff));
     System.out.println(Integer.toBinaryString(numSwitchToggle));
        
     
	}

}
