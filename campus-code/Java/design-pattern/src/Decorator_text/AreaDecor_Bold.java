/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator_text;

/**
 *
 * @author 徐翼飞
 */
public class AreaDecor_Bold extends Decorator {
    public AreaDecor_Bold(javax.swing.JTextArea component){
        super(component);
    }
     public void showText(){
        this.component.setVisible(true);
        this.component.setFont(new   java.awt.Font("Dialog",   1,this.component.getFont().getSize()));
    }
    
}
