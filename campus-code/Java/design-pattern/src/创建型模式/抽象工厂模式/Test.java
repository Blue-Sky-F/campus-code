package com.zb.创建型模式.抽象工厂模式;

/**
 * 测试
 * 
 * 作者: zhoubang 
 * 日期：2015年10月27日 上午10:40:28
 */
public class Test {
   
    public static void main(String[] args) {
        
        //类型为抽象工厂类，对象为具体的工厂
        Creater create1 = new Creater1();
        
        //类型为抽象产品类，对象为具体的产品对象
        Product productA1 = create1.createProductA();
        
        //调用具体的产品对象的方法
        productA1.dosomething();
        Creater create2 = new Creater2();
        Product product2 = create2.createProductB();
        product2.dosomething();
    }

    /**
     * 
     * 从中可以看出，工厂为抽象，产品也是抽象。
     * 
     * 产品的实例，是交给工厂来创建。
     * 
     * 所有产品都继承抽象产品类Product，重写了抽象方法。
     * 
     */
    
    
    //抽象工厂的优缺点：
    
    /**
     * 抽象工厂方法从纵向上看，几乎没有可扩展性，假如我们想增加一个产品C，也就是说产品家族由原来的2个变为3个，程序将会有很大的变动，抽象工厂中就需要增加一个方法。这严重违背了开闭原则。并且抽象类是不喜欢被修改的。
     * 
     * 但是从横向上来看，却对扩展性有了很好的支持，如果我们增加一个产品等级3，我们只需要在写一个Create3就可以了，这里又符合了开闭原则，有多少个产品等级就应该有多少个实现工厂类。
     * 每增加一个产品等级就相应的增加一个实现工厂类，这里的扩展性又很自然的体现出来了。
     * 
     * 
     * 所以每个模式都是必须在合适的地方使用的。
     * 
     */
}
