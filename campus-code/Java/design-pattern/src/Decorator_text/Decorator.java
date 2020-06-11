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
public abstract class Decorator extends javax.swing.JComponent {
    javax.swing.JComponent component;
    public abstract void showText();
    public Decorator(javax.swing.JComponent component){
        this.component = component;
    }
    
    
}
