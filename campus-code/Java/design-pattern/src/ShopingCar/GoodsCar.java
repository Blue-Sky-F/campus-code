/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopingCar;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JFrame;

/**
 *
 * @author 寰愮考椋�
 */
public class GoodsCar extends Canvas {

    /**
     * Creates new form GoodsCar
     */
    public GoodsCar() {
        //initComponents();
        this.setPreferredSize(new Dimension(800,400));
    }
    public void paint(Graphics g){
        Image image1=null;
        Image image2=null;
        Image image3=null;
        Image image4=null;
        try {
        	
           image1 = ImageIO.read(new File("C:\\Users\\寰愮考椋瀄\\Desktop\\閿洏.jpg"));
            image2 = ImageIO.read(new File("C:\\Users\\寰愮考椋瀄\\Desktop\\閿洏2.jpg"));
            image3 = ImageIO.read(new File("C:\\Users\\寰愮考椋瀄\\Desktop\\閿洏3.jpg"));
            image4 = ImageIO.read(new File("C:\\Users\\寰愮考椋瀄\\Desktop\\閿洏4.jpg"));
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
            g.drawImage(image1,0,0,200,200,null);
            g.drawImage(image2,210,0,200,200,null);
            g.drawImage(image3,420,0,200,200,null);
            g.drawImage(image4,630,0,200,200,null);
        
    }
    public static void main(String args[]){
        GoodsCar goodscar = new GoodsCar();
        JFrame j = new JFrame();
		j.setLayout(new FlowLayout());
		j.setPreferredSize(new Dimension(900,800));
                j.add(goodscar);
		j.pack();
		j.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();

        label1.setText("label1");

        label2.setText("label2");
    }// </editor-fold>//GEN-END:initComponents

    private void setLayout(GroupLayout layout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
