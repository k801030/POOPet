package ntu.csie.oop13spring;

import java.util.ArrayList;


public class MyArena extends POOArena{
	private ArrayList<POOPet> allpets = new ArrayList<POOPet>(0);
    
    public void addPet(POOPet p){
        allpets.add(p);
        System.out.println("hi");
    }
	@Override
	public boolean fight(){
		
		//for(int i=0;i<this.)
		System.out.println(this.getAllPets());
		return false;
	}
	@Override
    public void show(){
    	
    }
	
    @Override
    public POOCoordinate getPosition(POOPet p){
    	return null;
    }
}
