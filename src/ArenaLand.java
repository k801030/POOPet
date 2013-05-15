package ntu.csie.oop13spring;
import java.util.ArrayList;
import java.util.Random;



public class ArenaLand extends POOArena{
	private ArrayList<POOPet> allpets = new ArrayList<POOPet>(0);
    private ArrayList<Coordinate> petCoordinates = new ArrayList<Coordinate>(0);
    public void addPet(POOPet p){
        allpets.add(p);
        Coordinate c = new Coordinate();
        c = makeRandomCoordinate(c);
        petCoordinates.add(c);
    }
	@Override
	public boolean fight(){
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
    private Coordinate makeRandomCoordinate(Coordinate c){
    	Random ran = new Random();
        c.setX(ran.nextInt(16));
        c.setY(ran.nextInt(16));
    	return c;
    }
}
class Coordinate extends POOCoordinate{
	
	public  boolean equals(POOCoordinate other){
		return true;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}