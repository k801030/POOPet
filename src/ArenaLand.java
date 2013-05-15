package ntu.csie.oop13spring;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);

		for(int i=0;i<allpets.size();i++){
				allpets.get(i).act(this);
				scanner.next();
				return true;
		}
		return true;

	}
	
	@Override
    public void show(){
		// create basic map
		Coordinate point = new Coordinate();
		char[][] map = new char[size][size];
		for(int i=0;i<size;i++)
    		for(int j=0;j<size;j++)
    			map[i][j] = '.';
    	
    	// locate pets' positions
    	for(int i=0;i<size;i++)
    		for(int j=0;j<size;j++){
    			point.setX(j);
    			point.setY(i);		
    			char num = '1';
    			// check each pet
    			for(int k=0;k<allpets.size();k++,num++)
    				if(point.equals(allposi.get(k)))
    					map[i][j] = num;
    		}
    	printMap(map);
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