package ntu.csie.oop13spring;


public class BadWoman extends POOPet{
    public BadWoman(){
			setName("BadWoman");
		setAGI(2);
		setHP(90);
		setMP(100);

	}
    
	@Override
	protected POOAction act(POOArena arena){
		
		move(arena);
			//start fight
			
		

		return null;
	}

	@Override
	protected POOCoordinate move(POOArena arena){
		ArenaLand arenaLand = (ArenaLand) arena;
		int max=0,distance;

		
		// find nearest
		Coordinate[] posi = new Coordinate[2];
		posi = arenaLand.getAllPosi();
		for(int i=0;i<arenaLand.getPetNum();i++){
			distance = Math.abs(posi[0].getX()-posi[1].getX())+Math.abs(posi[0].getY()-posi[1].getY());
			if(max < distance){
				max = distance;
			}
		}
		int agi = this.getAGI();
		while(agi>0){
			distance = Math.abs(posi[0].getX()-posi[1].getX())+Math.abs(posi[0].getY()-posi[1].getY());
			// distance=1 means starting fight
			
			if(distance==1){
				return null; 
			}
			if(posi[1].getX() != posi[0].getX()){
				if(posi[1].getX() < posi[0].getX())
					posi[1].setX(posi[1].getX()+1);
				else 
					posi[1].setX(posi[1].getX()-1);
			}
			else if(posi[1].getY() != posi[0].getY()){
				if(posi[1].getY() < posi[0].getY())
					posi[1].setY(posi[1].getY()+1);
				else 
					posi[1].setY(posi[1].getY()-1);
			}
			
			agi--;
		}
		return posi[1];
    }

	
}
