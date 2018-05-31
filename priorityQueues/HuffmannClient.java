package priorityQueues;

public class HuffmannClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmannEncoder enc=new HuffmannEncoder("aaaaaaaaaaaaaaaaaabbbbbbcccd"); 
		enc.encode("ababbacd");
		enc.decode("101101011001000"); 
		

	}

}
