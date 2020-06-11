import java.io.*;
import java.util.*;
import java.text.Collator;
/**
 * 定义一个用线性表，用于存储学生信息
 * @author 徐翼飞
 */
public class ArrayList_Stu {
	Student student []=null;
	int capacity;
	int current;
	
	//实例化一个含n名同学的数组
    ArrayList_Stu(int n){
		this.student= new Student[n];
		for (int i=0;i<student.length; i++){
			student[i]=new Student();
		}
		this.capacity=n;
		this.current=0;
    }
    //以文件形式读入学生信息
    void readMessage(String filePath){
    	File file= new File(filePath);
    	Scanner sc=null;
    	try{
    		sc=new Scanner(file);
    		for (int i=0; i<student.length && sc.hasNext(); i++){
    			try{
    				student[i].number=sc.next();
    				student[i].name=sc.next();
    				student[i].Math=sc.nextInt();
    				student[i].English=sc.nextInt();
    				student[i].Java=sc.nextInt();
    				student[i].Computer=sc.nextInt();
    				this.current=i;
    			}
    			catch(InputMismatchException exp){
    				System.out.print("文件格式有误！");
    			}
    		}
    	}
    	catch(Exception exp){
    		System.out.println(exp);
    	}
    	//读入成绩的同时计算平均成绩
    	for (int j =0; j<=this.current;j++){
    		student[j].average=(student[j].English+student[j].Java+student[j].Math+student[j].Computer)/4;
    	}
    	
    	
    }
    
    /**
     * 打印学生信息
     * @param  list
     */
 public void printMessage(ArrayList_Stu list){
		 System.out.println("        学号                   姓名        数学      英语     Java  计算机      平均分"+"\n");
		 
		 for(int i=0;i<list.current+1;i++){
			 System.out.print(list.student[i].number);
			 System.out.printf("%6s",list.student[i].name);		 
			 System.out.printf("%12d", list.student[i].Math);
			 System.out.printf("%6d",list.student[i].English);
			 System.out.printf("%6d",list.student[i].Java);
			 System.out.printf("%6d",list.student[i].Computer);
			 System.out.printf("%10.2f",list.student[i].average);
			 System.out.printf("\n");
		 }
		 System.out.println("");
    }
    
    
    /**
     * 按学号用插入排序法排序
     * @param  list
     */
    void orderByNumber(ArrayList_Stu list){
    	Student student[] =list.student;
    	int i,j,target;
    	int n =list.current;
    	Student attemp=new Student();
    	  for (i = 1; i <= n; i++)
    	    {
    	        j = i;
    	        int s=student[i].number.length();
    	        attemp=student[i];
    	        target = Integer.parseInt(student[i].number.substring(s-2,s));
    	        while (j > 0 && target < Integer.parseInt(student[j-1].number.substring(s-2,s)))
    	        {
    	          student[j] = student[j - 1];
    	            j--;
    	        }
    	 
    	        student[j] = attemp;
    	    }
    	}
    
    /**
     * 按姓名用插入排序法排序
     * @param  list
     */   
    void orderByName(ArrayList_Stu list){
    	Student student[] =list.student;
    	Collator collator = Collator.getInstance(Locale.CHINA);//汉子解析类，按照拼音判断汉子间的大小
    	int i,j;
    	String target;
    	int n= list.current;
    	Student attemp=new Student();   //target.compareTo(student[j-1].name))<0
    	for(i=1; i <=n; i++){
    		j=i;
    		attemp=student[i];
    		target =student[i].name;
    		while(j>0 && (collator.compare(target,student[j-1].name ))<0){
    			student[j] = student[j-1];
    			j--;
    		}
    		student[j]=attemp;
    		
    	}
    }
    
    /**
     * 按成绩用插入排序法排序
     * @param  list
     */
    void orderByGrade(ArrayList_Stu list){
    	Student student[] =list.student;
    	int i,j;
    	float target;
    	int n= list.current;
    	Student attemp=new Student();
    	for(i=1; i <=n; i++){
    		j=i;
    		attemp=student[i];
    		target =student[i].average;
    		while(j>0 && target< student[j-1].average){
    			student[j] = student[j-1];
    			j--;
    		}
    		student[j]=attemp;
    		
    	}
    }
    
    /**
     * 用二分法按学号查找学生信息
     * @param ArrayList_Stu list
     * @param String number
     * @return Student
     */
    Student dichotomySearchByNumber(ArrayList_Stu list, String number){
    	 list.orderByNumber(list);//二分法查找前先保证学号有序 
    	 Student student[] = list.student;
    	 int start = 0;
    	 int end = list.current;
    	 int s=student[1].number.length();
    	 int key = Integer.parseInt(number.substring(s-2,s));
         while (start <= end) {
             int middle = (start + end) / 2;
             if (key <Integer.parseInt(student[middle].number.substring(s-2,s))) {
                 end = middle - 1;
             } else if (key > Integer.parseInt(student[middle].number.substring(s-2,s))) {
                 start = middle + 1;
             } else {
                 return student[middle];
             }
         }
         return null;
     }
    /**用二分法按姓名查找学生信息
     * @param list
     * @param name
     * @return Student []
     */
    Student [] dichotomySearchByName(ArrayList_Stu list, String name){
    	 list.orderByName(list);//二分法查找前先保证姓名有序
    	 Collator collator = Collator.getInstance(Locale.CHINA);//汉子解析类，按照拼音判断汉子间的大小
    	 Student [] student = list.student;
    	 Student [] student1 = new Student[4]  ;//返回一个包含同名学生信息的数组
    	 int start = 0;
    	 int i=0, middle;
    	 int end = list.current;
         while (start <= end) {
             middle = (start + end) / 2;
             if (collator.compare(name, student[middle].name)<0) {
                 end = middle - 1;
             } else if (collator.compare(name, student[middle].name)>0) {
                 start = middle + 1;
             } else {
                 student1[i] = student[middle];
                 int attemp1 = middle;
                 int attemp2 = middle;
                 while(student1[i].name.equals(student[attemp1].name) && attemp1<list.current){//往右搜寻，是否有同名学生
                	 attemp1++;
                	 if(student1[i].name.equals(student[attemp1].name)){
                		 i++;
                		 student1[i]=student[attemp1];
                	 } 
                 }
                 while(student1[i].name.equals(student[attemp2].name) && attemp2>0){//往左搜寻，是否有同名学生
                	 attemp2--;
                	 if(student1[i].name.equals(student[attemp2].name)){
                		 i++;
                		 student1[i]=student[attemp2];
                	 }
                 }
                 return student1;
             }
         }
         return null;
    }
         
    /**
     * 按照给定学号删除该同学的分数
     * @param list
     * @param name
     */
    void deleteByNumber(ArrayList_Stu list, String number){
    	orderByNumber(list);
    	if(dichotomySearchByNumber(list,number)!=null){
    		int goal=0;
    		while(!list.student[goal].number.equals(number) && goal<list.current){
    			goal++;
    		}
    		list.student[goal].English = 0;
    		list.student[goal].Computer = 0;
    		list.student[goal].Java = 0;
    		list.student[goal].Math = 0;
    		list.student[goal].average = 0;
    	}
    	else{
    		//System.out.println("无该学号的学生!");
    	}
    	
    }
    
    /**
     * 按给定的姓名删除该同学的分数
     * @param list
     * @param name
     */
    void deleteByName(ArrayList_Stu list, String name){
    	 orderByName(list);
    	 Student [] student = dichotomySearchByName(list,name);//返回对应姓名的学生信息，若不存在，则返回NULL
    	 if(student == null){
    		// System.out.println("无该姓名的学生!");
    	 }
    	 else{
    		 int i =0;
    		 while( student[i]!=null){
    			 int goal=0;
        		 while(!student[i].number.equals(list.student[goal].number)){
        			 goal++;
        		 }      		 
        	   		 list.student[goal].English = 0;
            		 list.student[goal].Computer = 0;
            		 list.student[goal].Java = 0;
            		 list.student[goal].Math = 0;
            		 list.student[goal].average = 0;
            		 i++;
    		 }    
    	    
    	 }
    }
    	    	   	
    

}

/**
 * 定义一个类，表示单个学生的信息
 * @author 徐翼飞
 *
 */
class Student{
	String number;
	String name;
	int Math;
	int English;
	int Java;
	int Computer;
	float average;
	
}

