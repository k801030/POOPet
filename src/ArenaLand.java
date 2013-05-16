package ntu.csie.oop13spring;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Action;

public class ArenaLand extends POOArena{
	private final int size = 16;
	private ArrayList<POOPet> allpets = new ArrayList<POOPet>(0);
	private ArrayList<Coordinate> allposi = new ArrayList<Coordinate>(0);
    private int round = 0;
    public void addPet(POOPet p){
        allpets.add(p);
        Coordinate c = new Coordinate();
        allposi.add(makeRandomCoordinate(c));
        
    }
    
	@Override
	public boolean fight(){
		
		
		
		POOAction action = new POOAction();
		
		//enter any key to continue
		try{
	          System.in.read();
	          }catch(Exception e){}
		
		//action
		action = allpets.get(round).act(this);
		// executive action
		action.skill.act(action.dest);
		
		round+=1;
		round%=allpets.size();
		
		//enter any key to continue
		try{
	          System.in.read();
	          }catch(Exception e){}
	          
		return true;

	}
	
	@Override
    public void show(){
		int x,y;
		
		// create basic map
		char[][] map = new char[size][size];
		for(int i=0;i<size;i++)
    		for(int j=0;j<size;j++)
    			map[i][j] = '.';
    	
    	// locate pets' positions
    	x = allposi.get(0).getX();
    	y = allposi.get(0).getY();
    	map[y][x]= 'M'; 
    	
    	x = allposi.get(1).getX();
    	y = allposi.get(1).getY();
    	map[y][x]= 'W'; 
    	
    	printMap(map);
    	
    	for(int i=0;i<allpets.size();i++)
    		showStatus(allpets.get(i));
    }
	private void showStatus(POOPet pet){
		
		System.out.print("["+pet.getName()+"] ");
		System.out.print("HP:"+pet.getHP()+" ");
		System.out.print("MP:"+pet.getMP()+" ");
		System.out.println("AGI:"+pet.getAGI()+" ");
	}
	
	private void printMap(char[][] map){
    	for(int i=0;i<size;i++){
    		for(int j=0;j<size;j++)
    			System.out.print(map[i][j]);
    		System.out.print("\n");
    	}
	}
	
	
	
	
    @Override
    public POOCoordinate getPosition(POOPet p){
    	return null;
    }
    

    
    public int getPetNum(){
    	return allpets.size();
    }
    
    public Coordinate[] getAllPosi(){
        Coordinate[] parr = new Coordinate[0];
        return allposi.toArray(parr);
    }
    public final POOPet[] getAllPets2(){
        POOPet[] parr = new POOPet[0];
        return allpets.toArray(parr);
    }
    private Coordinate makeRandomCoordinate(Coordinate c){
    	Random ran = new Random();
        c.setX(ran.nextInt(size));
        c.setY(ran.nextInt(size));
    	return c;
    }
}

class Coordinate extends POOCoordinate{
	
	public  boolean equals(POOCoordinate other){
		
		if(this.getX()==((Coordinate)other).getX() && this.getY()==((Coordinate)other).getY())
			return true;
		return false;
	}

	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}