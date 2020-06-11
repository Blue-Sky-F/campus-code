import java.io.*;
import java.util.*;
import java.text.Collator;
/**
 * ����һ�������Ա����ڴ洢ѧ����Ϣ
 * @author �����
 */
public class ArrayList_Stu {
	Student student []=null;
	int capacity;
	int current;
	
	//ʵ����һ����n��ͬѧ������
    ArrayList_Stu(int n){
		this.student= new Student[n];
		for (int i=0;i<student.length; i++){
			student[i]=new Student();
		}
		this.capacity=n;
		this.current=0;
    }
    //���ļ���ʽ����ѧ����Ϣ
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
    				System.out.print("�ļ���ʽ����");
    			}
    		}
    	}
    	catch(Exception exp){
    		System.out.println(exp);
    	}
    	//����ɼ���ͬʱ����ƽ���ɼ�
    	for (int j =0; j<=this.current;j++){
    		student[j].average=(student[j].English+student[j].Java+student[j].Math+student[j].Computer)/4;
    	}
    	
    	
    }
    
    /**
     * ��ӡѧ����Ϣ
     * @param  list
     */
 public void printMessage(ArrayList_Stu list){
		 System.out.println("        ѧ��                   ����        ��ѧ      Ӣ��     Java  �����      ƽ����"+"\n");
		 
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
     * ��ѧ���ò�����������
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
     * �������ò�����������
     * @param  list
     */   
    void orderByName(ArrayList_Stu list){
    	Student student[] =list.student;
    	Collator collator = Collator.getInstance(Locale.CHINA);//���ӽ����࣬����ƴ���жϺ��Ӽ�Ĵ�С
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
     * ���ɼ��ò�����������
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
     * �ö��ַ���ѧ�Ų���ѧ����Ϣ
     * @param ArrayList_Stu list
     * @param String number
     * @return Student
     */
    Student dichotomySearchByNumber(ArrayList_Stu list, String number){
    	 list.orderByNumber(list);//���ַ�����ǰ�ȱ�֤ѧ������ 
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
    /**�ö��ַ�����������ѧ����Ϣ
     * @param list
     * @param name
     * @return Student []
     */
    Student [] dichotomySearchByName(ArrayList_Stu list, String name){
    	 list.orderByName(list);//���ַ�����ǰ�ȱ�֤��������
    	 Collator collator = Collator.getInstance(Locale.CHINA);//���ӽ����࣬����ƴ���жϺ��Ӽ�Ĵ�С
    	 Student [] student = list.student;
    	 Student [] student1 = new Student[4]  ;//����һ������ͬ��ѧ����Ϣ������
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
                 while(student1[i].name.equals(student[attemp1].name) && attemp1<list.current){//������Ѱ���Ƿ���ͬ��ѧ��
                	 attemp1++;
                	 if(student1[i].name.equals(student[attemp1].name)){
                		 i++;
                		 student1[i]=student[attemp1];
                	 } 
                 }
                 while(student1[i].name.equals(student[attemp2].name) && attemp2>0){//������Ѱ���Ƿ���ͬ��ѧ��
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
     * ���ո���ѧ��ɾ����ͬѧ�ķ���
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
    		//System.out.println("�޸�ѧ�ŵ�ѧ��!");
    	}
    	
    }
    
    /**
     * ������������ɾ����ͬѧ�ķ���
     * @param list
     * @param name
     */
    void deleteByName(ArrayList_Stu list, String name){
    	 orderByName(list);
    	 Student [] student = dichotomySearchByName(list,name);//���ض�Ӧ������ѧ����Ϣ���������ڣ��򷵻�NULL
    	 if(student == null){
    		// System.out.println("�޸�������ѧ��!");
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
 * ����һ���࣬��ʾ����ѧ������Ϣ
 * @author �����
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

