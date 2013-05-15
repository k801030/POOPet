package ntu.csie.oop13spring;

import java.util.ArrayList;


public class ArenaLand extends POOArena{
	private ArrayList<POOPet> allpets = new ArrayList<POOPet>(0);
    
    public void addPet(POOPet p){
        allpets.add(p);
    }
	@Override
	public boolean fight(){
		POOPet[] petList = new POOPet[5];

		for(int i=0;i<allpets.size();i++)
			System.out.println(allpets.get(i).getName());
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
