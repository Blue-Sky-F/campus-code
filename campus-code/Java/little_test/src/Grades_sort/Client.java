package Grades_sort;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Stream;
public class Client {
	public static void main(String args[]) {
		//console_input();
		//file_input();
		words_count();
	}
	public static void console_input() {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			ArrayList<Student> list = new ArrayList();
			int n = input.nextInt();
			int tag = input.nextInt();
			for(int i=0; i<n; i++) {
				list.add((new Student(input.next(),input.nextInt())));
			}
			Collections.sort(list);
			for(Student stu: list)
				System.out.println(stu.get_name()+"\t"+stu.get_grades());
		}
	}
	public static void file_input() {
		// 逐行读取数据   
		String str1 = "C:\\Users\\xuyifei\\Desktop\\input.txt";
		String str2 = "C:\\Users\\xuyifei\\Desktop\\output1.txt";
		FileReader fr;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			fr = new FileReader(str1);
			BufferedReader br = new BufferedReader(fr); 
			while(br.read()!=-1) {
				String line = br.readLine();
				list.add(new Student(line.split(" ")[0],Integer.parseInt(line.split(" ")[1])));
			}
			Collections.sort(list);  
			fr.close();  
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}     	  
		try {   
			 FileWriter fw = new FileWriter(str2);   
			 for(Student stu: list) {
				 fw.write(stu.get_name()+"\t"+stu.get_grades()+"\n");
			 }
			fw.flush();   
			fw.close();    
			} catch (IOException e) {   
				e.printStackTrace();   
			}   	
		System.out.println("Mission Succeed！");
	}
	public static void words_count() {
		String str = "C:\\Users\\xuyifei\\Desktop\\article.txt";
		String str1 = "C:\\Users\\xuyifei\\Desktop\\words_count.txt";
		FileReader fr;
		HashMap<String,Integer> map = new HashMap();
		try {
			fr = new FileReader(str);
			BufferedReader br = new BufferedReader(fr); 
			while(br.read()!=-1) {
				String line = br.readLine();
				for(String s: line.split(" ")) {
					if(map.containsKey(s))
						map.put(s, map.get(s)+1);
					else
						map.put(s,1);
				}
			}
			map.remove(" ");
			map.remove(",");
			map.remove(".");
			map.remove(":");
			map.remove(null);
			fr.close();  
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		try {   
			 FileWriter fw = new FileWriter(str1);   
			 
			 ArrayList<HashMap.Entry<String, Integer>> list = new ArrayList(map.entrySet());
		        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
						// TODO Auto-generated method stub
						return o2.getValue() > o1.getValue()? 1:-1;
					}
		        });
			 
			for(HashMap.Entry<String, Integer> entry:list) {
				fw.write(entry.getKey()+":\t"+entry.getValue()+"\n");
			}
			fw.flush();   
			fw.close();    
			} catch (IOException e) {   
				e.printStackTrace();   
			}   	
		System.out.println("Mission Succeed！");
	}
}
