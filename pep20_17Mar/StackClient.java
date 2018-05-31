package pep20_17Mar;

public class StackClient {

	public static void main(String[] args) {
		// Stack s1 = new Stack(4);
		/*
		 * s1.push(10); s1.display(); s1.push(20); s1.display(); s1.push(30);
		 * s1.display(); s1.push(40); s1.display(); s1.push(50); s1.display();
		 * System.out.println(s1.pop()+" popped"); s1.display();
		 * System.out.println(s1.pop()+" popped"); s1.display();
		 * System.out.println(s1.pop()+" popped"); s1.display();
		 * System.out.println(s1.pop()+" popped"); s1.display();
		 * System.out.println(s1.pop()+" popped"); s1.display();
		 */
		System.out.println(isDuplicateParan("((a+b)+(c+d))+e)"));  

	}

	public static boolean areTheParanthesisBalanced(String s) {
		Stack stack = new Stack(s.length());
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '[' || ch == '{' || ch == '(')
				stack.push(ch);
			else if (ch == ']') {
				if (stack.top() == '[') {
					if (stack.size() != 0)
						stack.pop();
					else
						return false;
				} else
					return false;
			} else if (ch == '}') {
				if (stack.top() == '{') {
					if (stack.size() != 0)
						stack.pop();
					else
						return false;
				} else
					return false;
			} else if (ch == ')') {
				if (stack.top() == '(') {
					if (stack.size() != 0)
						stack.pop();
					else
						return false;
				}

				else
					return false; 
			}
		}
		if (stack.size() == 0) 
			return true; 
		else
			return false;
	}

	public static boolean isDuplicateParan(String s)
	{
		Stack stack=new Stack(s.length());
		for(int i=0;i<s.length();i++)
		{   char ch=s.charAt(i);
		    if(s.charAt(i)==')')
		    {
		    	int top=stack.top();
		    	stack.pop();
		    	if(top=='(')
		    		return true; 
		    	else
		    	{
		    		while(top!='(')
		    		{
		    			top=stack.top(); 
		    			stack.pop();  
		    		}
		    	}
		    	
		    	
		    }
		    else 
		    	stack.push(ch);    
			
		}
		return false;  
	}
}
