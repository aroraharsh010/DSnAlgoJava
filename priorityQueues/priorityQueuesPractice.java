package priorityQueues;

import java.util.*; 


public class priorityQueuesPractice {

	public static void main(String[] args) {
		/*Student[] students = new Student[5];
		students[0] = new Student(1, 100, "A");
		students[1] = new Student(4, 1, "D");
		students[2] = new Student(9, 60, "B");
		students[3] = new Student(5, 50, "C");
		students[4] = new Student(2, 10, "E");
		Arrays.sort(students);
		for (Student s : students) { 

			s.display();
		}*/
		int[] arr={4,3,66,5,12,56,89};
		//printKLargestElements(arr, 3);
		printKSmallestElements(arr, 4);

	}

	// compareTo function rules
	// if
	// s1.compareTo(s2) is equal then ==0
	static class Student implements Comparable<Student> {
		int rank;
		int coolness;
		String name;

		Student(int rank, int coolness, String name) {
			this.rank = rank;
			this.coolness = coolness;
			this.name = name;
		}
        @Override  
		public int compareTo(Student o) {
			//return o.rank - this.rank;
			return this.name.compareTo(o.name);  
		}

		public void display() {

			System.out.println(this.name+" "+this.rank+" "+this.coolness);
		}
	}
	public static void printKLargestElements(int[] arr,int k){
	 PriorityQueue<Integer> pq=new PriorityQueue<>();
	 for(int i=0;i<k;i++){
		 pq.add(arr[i]);
	 }
	 for(int i=k;i<arr.length;i++){
		 if(arr[i]>pq.peek()){
			 pq.remove();
			 pq.add(arr[i]);
		 }
			 
	 }
	 for(int i=0;i<k;i++){ 
		 System.out.println(pq.remove());
	 }
	}  
	public static void printKSmallestElements(int[] arr,int k){
		 PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		 for(int i=0;i<k;i++){
			 pq.add(arr[i]); 
		 }
		 for(int i=k;i<arr.length;i++){
			 if(arr[i]<pq.peek()){
				 pq.remove();
				 pq.add(arr[i]); 
			 }
				 
		 }
		 for(int i=0;i<k;i++){ 
			 System.out.println(pq.remove()); 
		 }
		}
	 
}
