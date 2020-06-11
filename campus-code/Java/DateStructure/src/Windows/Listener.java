package Windows;
import Stack.*;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Listener implements ActionListener {
	JTextField field;
	JTextArea area;
	JButton tem1,tem2,tem3;
	Stack<String> stack=new Stack(100);
	
	public void add(JTextField field,JTextArea area,JButton item1,JButton item2,JButton item3){
		this.field=field;
		this.area=area;
		this.tem1=item1;
		this.tem2=item2;
		this.tem3=item3;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(tem1)&&!field.getText().equals("")){
			stack.push(field.getText());
			field.setText("");
			
		}
		else if(e.getSource().equals(tem2)){
			Object t = stack.pop();
			if(t!=null){
			area.append("   "+t);
			}
		}
		else if(e.getSource().equals(tem3)){
			area.setText("");
		}
	}

}
