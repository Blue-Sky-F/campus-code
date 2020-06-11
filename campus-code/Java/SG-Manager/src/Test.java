
public class Test {
	public static void main(String args[]){
		 ArrayList_Stu list= new  ArrayList_Stu(15);
		 list.readMessage("学生信息.txt"); 
//		 System.out.println("********************原信息表为********************");
		 list.printMessage(list);
//		 list.orderByNumber(list);
//		 System.out.println("******************按学号排序为********************");
//		 list.printMessage(list);
//		 list.orderByGrade(list);
//		 System.out.println("******************按成绩排序为********************");
//		 list.printMessage(list);
//	 list.orderByName(list);
//		 System.out.println("******************按姓名排序为********************");
//		 list.printMessage(list);
//		 Student student1 = list.dichotomySearchByNumber(list, "2220162680");
//		 if(student1!=null){
//		     System.out.println(student1.number);
//		     }
		 Student [] student1 = list.dichotomySearchByName(list, "屈原");
		 int i = 0;
		 while(student1[i]!=null){
			 System.out.println(student1[i].number+"    "+student1[i].name+"          "+student1[i].Math+"    "+student1[i].English+"    "+student1[i].Java+"     "+student1[i].Computer+"     "+student1[i].average);
			 i++;
			 }
//		 list.deleteByNumber(list, "2220162665");
//		 list.printMessage(list);
//		 list.orderByName(list);
//		 list.deleteByName(list, "李白");
//		 list.printMessage(list);
//		 
//		 
//
//		 
	}
	
	
	
	
}
