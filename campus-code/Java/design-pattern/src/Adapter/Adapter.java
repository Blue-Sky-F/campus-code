package Adapter;

public class Adapter implements DogBark,CatBark {
	public Dog dog;
	public Cat cat;
	public Adapter(){
		dog = new Dog();
		cat = new Cat();
	}
	public void dogBark(){
		cat.catBark();
	}
	public void catBark(){
		dog.dogBark();
	}

}
