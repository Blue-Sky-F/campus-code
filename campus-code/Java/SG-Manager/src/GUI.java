 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * 编写学生成绩管理的图形用户界面
 * @author 徐翼飞
 *
 */
public class GUI extends JFrame {
	JTextField text;
	JButton button;
	JComboBox comBox1,comBox2,comBox3;
	JTextArea area;
	
	JDialog jd ;//弹出的输入框
	JTextField text1 ;
	//添加新学生信息
	JButton button1;
	JTextField field1,field2,field3,field4,field5,field6;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6;
	ArrayList_Stu array = new ArrayList_Stu(15);
	public GUI(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		setLayout(new FlowLayout());
		add(new JLabel("信息表的路径："));
		text = new JTextField(20);
		add(text);
		button = new JButton("导入");
		add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String url = text.getText();
				array.readMessage(url);
				area.setText("");
				if(array.student[0].name==null){//路径错误
					area.append("系统找不到指定的文件！");
					
				}
			}
			
		});
		
		/************************排序操作************************/
		add(new JLabel("排序:"));
		comBox1 = new JComboBox();
		comBox1.addItem("按学号排序");
		comBox1.addItem("按姓名排序");
		comBox1.addItem("按分数排序");
		add(comBox1);
		comBox1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(comBox1.getSelectedIndex()==0){
					array.orderByNumber(array);
				}
				else if (comBox1.getSelectedIndex()==1){
					array.orderByName(array);
				}
				else{
					array.orderByGrade(array);
				}
				printMessage(array);
				
			}
		});
		/**********************查找操作*********************************/
		add(new JLabel("查找:"));
		comBox2 = new JComboBox();
		comBox2.addItem("按学号查找");
		comBox2.addItem("按姓名查找");
		add(comBox2);
		comBox2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(comBox2.getSelectedIndex()==0){//选择按学号查找
					JButton button1= new JButton("确定:");	
					jd = new JDialog();
					jd.getContentPane().setLayout(new FlowLayout());
					jd.setTitle("学号输入...");
					jd.setBounds(220,180, 260,100);
					jd.add(new JLabel("请输入学号："));
					text1 = new JTextField(10);
					jd.add(text1);
					jd.add(button1);
					jd.setVisible(true);
					jd.setModal(true);
					button1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							jd.setVisible(false);
							String number = text1.getText();
							try{//捕获学号输入产生的异常
								Integer.parseInt(number.substring(number.length()/2,number.length()));
								Integer.parseInt(number.substring(0,number.length()/2));
								if(array.dichotomySearchByNumber(array, number)==null){
									area.setText("");
									area.append("无该学号同学的信息！");
								}
								else{
								printf(array.dichotomySearchByNumber(array, number));	
								}
								
							}
							catch(NumberFormatException m){
								area.setText("");
								area.append("学号中出现非数字字符！");
							}
							
						}
						
					});				
				}
				if(comBox2.getSelectedIndex()==1){//按照姓名查找
					JButton button1= new JButton("确定:");	
					jd = new JDialog();
					jd.getContentPane().setLayout(new FlowLayout());
					jd.setTitle("姓名输入...");
					jd.setBounds(220,180, 260,100);
					jd.add(new JLabel("请输入姓名："));
					text1 = new JTextField(10);
					jd.add(text1);
					jd.add(button1);
					jd.setVisible(true);
					jd.setModal(true);
					button1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							jd.setVisible(false);
							String name = text1.getText();
							if(array.dichotomySearchByName(array, name)==null){
								area.setText("");
								area.append("无该姓名同学的信息！");
							}
							else{
							print(array.dichotomySearchByName(array, name));	
							}
						}					
					});				
				}	
				
			}	
		});
		
		/**************************删除操作*************************/
		add(new JLabel("删除:"));
		comBox3 = new JComboBox();
		comBox3.addItem("输入学号");
		comBox3.addItem("输入姓名");
		add(comBox3);
		comBox3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(comBox3.getSelectedIndex()==0){
					JButton button1= new JButton("确定:");	
					jd = new JDialog();
					jd.getContentPane().setLayout(new FlowLayout());
					jd.setTitle("学号输入...");
					jd.setBounds(220,180, 260,100);
					jd.add(new JLabel("请输入学号："));
					text1 = new JTextField(10);
					jd.add(text1);
					jd.add(button1);
					jd.setVisible(true);
					jd.setModal(true);
					button1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							jd.setVisible(false);
							String number = text1.getText();
							try{//捕获学号输入产生的异常
								Integer.parseInt(number.substring(number.length()/2,number.length()));
								Integer.parseInt(number.substring(0,number.length()/2));
								if(array.dichotomySearchByNumber(array, number)==null){
									area.setText("");
									area.append("无该学号同学的信息！");
								}
								else{
								array.deleteByNumber(array, number);//删除该同学的分数
								printMessage(array);
								}
							}
							catch(NumberFormatException m){
								area.setText("");
								area.append("学号中出现非数字字符！");							
							}
							
						}					
					});							
				}
				if(comBox3.getSelectedIndex()==1){
					JButton button1= new JButton("确定:");	
					jd = new JDialog();
					jd.getContentPane().setLayout(new FlowLayout());
					jd.setTitle("姓名输入...");
					jd.setBounds(220,180, 260,100);
					jd.add(new JLabel("请输入姓名："));
					text1 = new JTextField(10);
					jd.add(text1);
					jd.add(button1);
					jd.setVisible(true);
					jd.setModal(true);
					button1.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							jd.setVisible(false);
							String name = text1.getText();
							if(array.dichotomySearchByName(array, name)==null){
								area.setText("");
								area.append("无该姓名同学的信息！");
							}
							else{
							array.deleteByName(array, name);//删除该同学的分数
							printMessage(array);
							}
						}					
					});							
				}
			}
			
		});

		add(lab1 = new JLabel("学号:"));
		field1 = new JTextField(10);
		add(field1);
		
		add(lab2 = new JLabel("姓名:"));
		field2 = new JTextField(4);
		add(field2);
		
		add(lab3 = new JLabel("数学:"));
		field3 = new JTextField(4);
		add(field3);
		
		add(lab4 = new JLabel("英语:"));
		field4 = new JTextField(4);
		add(field4);
		
		add(lab5 = new JLabel("Java:"));
		field5 = new JTextField(4);
		add(field5);
		
		add(lab6 = new JLabel("计算机:"));
		field6 = new JTextField(4);
		add(field6);
		
		button1 = new JButton("添加");
		add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(field1.getText()!=""){
					if(array.student[array.current].name!=null){
					    array.current++;
						array.student[array.current].number = field1.getText();
						array.student[array.current].name = field2.getText();
						array.student[array.current].Math = Integer.parseInt(field3.getText());
						array.student[array.current].English = Integer.parseInt(field4.getText());
						array.student[array.current].Java = Integer.parseInt(field5.getText());
						array.student[array.current].Computer = Integer.parseInt(field6.getText());
						array.student[array.current].average = (array.student[array.current].Math+array.student[array.current].English+array.student[array.current].Java+array.student[array.current].Computer)/4;
						field1.setText("");
						field2.setText("");
						field3.setText("");
						field4.setText("");
						field5.setText("");
						field6.setText("");
					}
					else{
						array.student[array.current].number = field1.getText();
						array.student[array.current].name = field2.getText();
						array.student[array.current].Math = Integer.parseInt(field3.getText());
						array.student[array.current].English = Integer.parseInt(field4.getText());
						array.student[array.current].Java = Integer.parseInt(field5.getText());
						array.student[array.current].Computer = Integer.parseInt(field6.getText());
						array.student[array.current].average = (array.student[array.current].Math+array.student[array.current].English+array.student[array.current].Java+array.student[array.current].Computer)/4;
						field1.setText("");
						field2.setText("");
						field3.setText("");
						field4.setText("");
						field5.setText("");
						field6.setText("");
						
						
					}
						
					
						
				}
			}
		});

		
		area = new JTextArea(50,70);
		add(area);	
	}
	
	/*******************TextArea区域打印***************************/
	void printMessage(ArrayList_Stu array){
		area.setText("");
		area.append("        学号                姓名        数学      英语     Java    计算机   平均分"+"\n");
		 for(int i=0;i<array.current+1;i++){
			 if(array.student[i].average==0){
				 printZero(array.student[i]);
			 }
			 else{
			 area.append(array.student[i].number);
			 area.append("         "+array.student[i].name);		 
			 area.append("         "+ array.student[i].Math);
			 area.append("         "+array.student[i].English);
			 area.append("         "+array.student[i].Java);
			 area.append("         "+array.student[i].Computer);
			 area.append("         "+array.student[i].average);
			 area.append("\n");
			 }
		 }
	}
	
	void print(Student [] student){
		int i = 0;
		area.setText("");
		area.append("        学号                姓名        数学      英语     Java    计算机   平均分"+"\n");
		while(student[i]!=null){
			if(student[i].average==0){
				printZero(student[i]);
			}
			else{
			 area.append(student[i].number);
			 area.append("         "+student[i].name);		 
			 area.append("         "+ student[i].Math);
			 area.append("         "+student[i].English);
			 area.append("         "+student[i].Java);
			 area.append("         "+student[i].Computer);
			 area.append("         "+student[i].average);
			 area.append("\n");
			 i++;
			}
		}
	}
	void printf(Student student){
		 area.setText("");
		 area.append("        学号                姓名        数学      英语     Java    计算机   平均分"+"\n");
		 if(student.average==0){
			 printZero(student);
		 }
		 else{
		 area.append(student.number);
		 area.append("         "+student.name);		 
		 area.append("         "+ student.Math);
		 area.append("         "+student.English);
		 area.append("         "+student.Java);
		 area.append("         "+student.Computer);
		 area.append("         "+student.average);
		 area.append("\n");
		 }
		
	}
	void printZero(Student student){
		
			 area.append(student.number);
			 area.append("         "+student.name);		 
			 area.append("          "+ student.Math);
			 area.append("           "+student.English);
			 area.append("           "+student.Java);
			 area.append("            "+student.Computer);
			 area.append("            "+student.average);
			 area.append("\n");
			
		
	}

	
}
