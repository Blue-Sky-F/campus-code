package Windows;
import java.awt.*;
import javax.swing.*;

import java.awt.Event.*;
import static javax.swing.JFrame.*;
public class StackWindows extends JFrame {
	JMenuBar menubar;
	JMenu menu;
	JButton item1,item2,item3;
	JTextField field;
	JTextArea area;
	Listener listener1;
	public StackWindows(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		setLayout(new FlowLayout());
		add(new JLabel("��ջ��:"));
		field=new JTextField(35);
		add(field);
		menubar=new JMenuBar();
		item1=new JButton("ȷ��");
		item2=new JButton("ȷ��");
		item3=new JButton("ȷ��");
		listener1=new Listener();
		item1.addActionListener(listener1);
		item2.addActionListener(listener1);
		item3.addActionListener(listener1);
		add(new JLabel("PUSH:"));
		add(item1);
		add(new JLabel("       "));
		add(new JLabel("POP:"));
		add(item2);
		add(new JLabel("       "));
		add(new JLabel("���:"));
		add(item3);
		add(new JLabel("                                                               "));
		area= new JTextArea(10,20);
		add(new JLabel("��ջ���У�"));
		add(area);
		listener1.add(field,area,item1,item2,item3);
	}
	
	

}
