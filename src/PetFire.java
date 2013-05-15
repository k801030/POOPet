package ntu.csie.oop13spring;

import javax.annotation.PostConstruct;


public class PetFire extends POOPet{
	private Coordinate c ;
    private static int totalNum = 1;
	public PetFire(){
		if(totalNum==1)
			setName("Fire");
		else
			setName("Fire"+totalNum);
		setAGI(2);
		setHP(100);
		setMP(80);
		
		totalNum++;
	}
	
	@Override
	protected POOAction act(POOArena arena){
		
		move(arena);
			//start fight
			
		

		return null;
	}
	
	protected POOCoordinate move(POOArena arena){
		POOPet[] pet = new POOPet[3];
		pet = arena.getAllPets();
		ArenaLand arenaLand = (ArenaLand) arena;
		int max=0,distance;
		int near=0;
		
		// find nearest
		Coordinate[] posi = new Coordinate[2];
		posi = arenaLand.getAllPosi();
		for(int i=0;i<arenaLand.getPetNum();i++){
			distance = Math.abs(posi[0].getX()+posi[0].getY()-posi[1].getX()-posi[1].getY());
			if(max < distance){
				near = i;
				max = distance;
			}
		}
		int agi = this.getAGI();/*
		while(agi>0){
			distance = Math.abs(c.getX()+c.getY()-pet[near].getC().getX()-pet[near].getC().getY());
			// distance=1 means starting fight
			
			if(distance==1){
				return null; 
			}
			if(this.c.getX() != pet[near].getC().getX()){
				if(this.c.getX()> pet[near].getC().getX())
					this.c.setX(this.c.getX()+1);
				else 
					this.c.setX(this.c.getX()-1);
			}
			else if(this.c.getY() != pet[near].getC().getY()){
				if(this.c.getY()> pet[near].getC().getY())
					this.c.setY(this.c.getY()+1);
				else 
					this.c.setY(this.c.getY()-1);
			}
			
			agi--;
		}*/
		return c;
    }
	public void setC(Coordinate c) {
		this.c = c;
	}
	

	
	public Coordinate getC() {
		return c;
	}

	

	//skill
	class BurnSkill extends POOSkill{
		
		public void act(POOPet pet){
			
		}
	}
	class ExplosionSkill extends POOSkill{
		
		public void act(POOPet pet){
			
		}
	}
}
