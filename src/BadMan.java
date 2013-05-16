package ntu.csie.oop13spring;

import sun.security.action.GetBooleanAction;


public class BadMan extends POOPet{
	private POOPet me ;
	private POOPet enemy ;

	public BadMan(){
		setName("BadMan");
		setAGI(2);
		setHP(100);
		setMP(80);
		
	}
	
	
	
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
	
	@Override
	protected POOAction act(POOArena arena){
		int rand = (int) (Math.random()*100);
		
		POOPet[] pets = new POOPet[2];
		
		ArenaLand arenaLand = (ArenaLand)arena;
		pets = arenaLand.getAllPets2();
		enemy = pets[1];
		me = pets[0];
		
		POOAction action = new POOAction();
		//skill
		StrongKick strongKick = new StrongKick();
		PlayMobile playMobile = new PlayMobile();
		Smoke smoke = new Smoke();
		
		int mp = this.getMP();
		if(move(arena)==null){
		
			//start fight
			if(mp>50){
				this.setMP(mp-50);
				action = doAction(this, enemy,strongKick,strongKick.getName());
			}
		}else{
			if(rand>=70){
				action = doAction(this, me,playMobile,playMobile.getName());
			}else{
				
				action = doAction(this, me,smoke,smoke.getName());
				
			}
			
		}
		
		return action;
	}
	
	private POOAction doAction(POOPet me, POOPet enemy, POOSkill skill, String skillName){
		POOAction action = new POOAction();
		action.skill = skill;
		action.dest = enemy;
		System.out.println(me.getName()+" do "+skillName+" on "+enemy.getName());
		
		return action;
	}
	

}

class StrongKick extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		int mp = pet.getMP();
		
		if(hp>0)
			pet.setHP(hp-10);
		if(mp>0)
			pet.setMP(mp+1);
	}
	
	public String getName(){
		return "Strong Kick";
	}
}

class PlayMobile extends POOSkill{
	
	public void act(POOPet pet){
		int mp = pet.getMP();
		if(mp>0)
			pet.setMP(mp-1);
	}
	
	public String getName(){
		return "Play Mobile";
	}
}

class Smoke extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		int mp = pet.getMP();

		if(hp>0)
			pet.setHP(hp-1);
		if(mp>0)
			pet.setMP(mp+1);
	}
	
	public String getName(){
		return "Smoke";
	}
}

class ExplosionSkill extends POOSkill{
	
	public void act(POOPet pet){
		
	}
}