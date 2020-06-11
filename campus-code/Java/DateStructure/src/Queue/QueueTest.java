package Queue;

public class QueueTest {
	public static void main(String args[]){
		Queue<String> q = new Queue(12);
		//q = new Queue(5+1);
		q.in("a");
		q.in("b");
		q.in("c");
		q.in("d");
		q.in("e");
		String p = new String();
//		System.out.println(q.out());
//		System.out.println(q.out());
//		System.out.println(q.out());
//		System.out.println(q.out());
//		System.out.println(q.out());
		  String number = new String();
	       String s = new String();
	       while(s!=null)
	       {
	           s =(String) q.out();
               if(s!=null)
	           number=number+s;
	       }
	      System.out.println(number); 
	    //System.out.println(q.out()+q.out()+q.out()+q.out()+q.out()+q.out());
	   
		
		
		
	}

}
