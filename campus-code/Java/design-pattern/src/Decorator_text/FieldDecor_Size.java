/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator_text;

/**
 *具体装饰类，装饰JTextField
 * @author 徐翼飞
 */
public class FieldDecor_Size extends Decorator {
    public FieldDecor_Size(javax.swing.JTextField component){
        super(component);
    }
    public void showText(){   
    }
    //向构件添加新的职责
    public void setSize(int z){
         this.component.setVisible(true);
        this.component.setFont(new   java.awt.Font("Dialog",   0,   z));
    }
    
}
