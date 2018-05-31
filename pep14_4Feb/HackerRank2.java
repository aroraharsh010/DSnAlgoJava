package pep14_4Feb;

import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;
public class HackerRank2 {
	static Scanner scn = new Scanner(System.in);;
	static int counter=0;
	public static void main(String[] args) {
		/*int n = scn.nextInt();
		int[] arr = new int[n];
		inputArr(arr);
		int n2 = scn.nextInt();
		int[] hArr = new int[n2];
		inputArr(hArr);
		for(int i=0;i<hArr.length;i++)
		{
			HIT(hArr[i], arr);
		}
		display(arr);*/
		/*Scanner input = new Scanner(System.in);
		   Integer n = input.nextInt();
		   ArrayList<String> list = new ArrayList<String>();
		       
		   for (int i = 1;i<n;i++){
		     list.add(""+i);
		   }
		        
		  Collections.sort(list);
		        
		  for (String j: list){
		    System.out.println(j);*/
		/*String s=scn.nextLine();
		System.out.print(removeDuplicate(s, ""));
		                            System.out.print(s.charAt(s.length()-1));*/
		//String s=scn.next();
		/*char x=scn.next().charAt(0);
		int n=scn.nextInt();
		String a=restructureString(s, "", x);
		for(int i=0;i<counter;i++)
		{
			a+=x;
		}
		System.out.println(a.charAt(n));
		System.out.println(a);*/
		//System.out.println(removeHi("hijhij", ""));
		
		System.out.println(paranthesis("abcd(abc)def", ""));
		  }
	public static void HIT(int x,int[] arr) {
		for(int i=0;i<arr.length;i++) 
		{
			if(x<arr[i])
				arr[i]--;
		}
	}
	public static void display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	public static void inputArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
	}
    public static String removeDuplicate(String s,String a)
    {
    	if(s.length()==1)
    		return a;
    	char ch=s.charAt(0);
    	String ros=s.substring(1);
    	if(ch==ros.charAt(0))
    		 a=removeDuplicate(ros, a);
    	else 
    		a=removeDuplicate(ros, a+ch);
    	return a;
    	
    }
    
    public static String restructureString(String s,String a,char x)
    {
    	if(s.length()==0)
    	{
    		return a;
    	}
    	char ch=s.charAt(0);
    	String ros=s.substring(1);
    	if(ch==x)
    		{a=restructureString(ros, a, x);counter++;}
    	else
    		a=restructureString(ros, a+ch, x);
    	return a;
    	
    }
 
    public static String removeHi(String s,String a)
    {
    	if(s.length()==1)
    		return a;
    	String ros;
    	char ch=s.charAt(0),ch1=s.charAt(1);
       if(ch=='h'&&ch1=='i')
    	 { ros=s.substring(2);removeHi(ros, a);}
       else 
       { ros=s.substring(1);removeHi(ros, a+ch);}
      
       return a;
       
    	
    }
    public static int countHi(String s,int a)
    {
    	if(s.length()==0)
    		return a;
    	
    	String b=s.substring(0, 2);
    	String ros=s.substring(2);
    	if(b.equals("hi"))
    	  a=countHi(ros, a+1);
    	else
    		a=countHi(ros, a);
    	return a;
    }
    
    public static int count1aaa(String s,int a)
    {
    	if(s.length()-3==0)
    		return a;
    	String ques=s.substring(0, 3),ros=s.substring(1);
    	if(ques.equals("aaa"))
    		a=count1aaa(ros, a+1);
    	else 
    		a=count1aaa(ros, a+1);
    	return a;
    }

    public static String paranthesis(String s,String a)
    {
    	if(s.length()==0)
    		return a;
    	
    	char ch=s.charAt(0);
    	String ros=s.substring(1);
    	if(ch=='(')
    	{
    		for(int i=0;i<s.length();i++)
    		{
    			if(ch!=')')
    				a=paranthesis(ros,a+s.charAt(i));
    			else
    				{a=paranthesis(ros, a);break;}
    		}
    		
    	
    	}
    	else
			a=paranthesis(ros, a);
    	return a;
    }
}
