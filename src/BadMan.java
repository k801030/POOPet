package ntu.csie.oop13spring;


public class BadMan extends POOPet{
	public BadMan(){
		setName("BadMan");
		setAGI(2);
		setHP(100);
		setMP(80);
		
	}
	
	@Override
	protected POOAction act(POOArena arena){
		
		move(arena);
			//start fight
			
		

		return null;
	}
	
	protected POOCoordinate move(POOArena arena){
		ArenaLand arenaLand = (ArenaLand) arena;
		int max=0,distance;

		
		// find nearest
		Coordinate[] posi = new Coordinate[2];
		posi = arenaLand.getAllPosi();
		for(int i=0;i<arenaLand.getPetNum();i++){
			distance = Math.abs(posi[0].getX()+posi[0].getY()-posi[1].getX()-posi[1].getY());
			if(max < distance){
				max = distance;
			}
		}
		int agi = this.getAGI();
		while(agi>0){
			distance = Math.abs(posi[0].getX()+posi[0].getY()-posi[1].getX()-posi[1].getY());
			// distance=1 means starting fight
			
			if(distance==1){
				return null; 
			}
			if(posi[0].getX() != posi[1].getX()){
				if(posi[0].getX() < posi[1].getX())
					posi[0].setX(posi[0].getX()+1);
				else 
					posi[0].setX(posi[0].getX()-1);
			}
			else if(posi[0].getY() != posi[1].getY()){
				if(posi[0].getY() < posi[1].getY())
					posi[0].setY(posi[0].getY()+1);
				else 
					posi[0].setY(posi[0].getY()-1);
			}
			
			agi--;
		}
		return posi[0];
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
