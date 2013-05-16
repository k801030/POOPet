package ntu.csie.oop13spring;


public class BadBoy extends POOPet{
	private POOPet me ;
	private POOPet other ;
	private boolean meet = false;
	public BadBoy(){
		setName("BadBoy");
		setAGI(2);
		setHP(50);
		setMP(50);
		
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
		other = pets[1];
		me = pets[0];
		
		POOAction action = new POOAction();
		//skill
		FirstMeet firstMeet = new FirstMeet();
		SendDiamond sendDiamond = new SendDiamond();
		SendChocolate sendChocolate = new SendChocolate();
		FindGirl findGirl = new FindGirl();
		SendLoveLetter sendLoveLetter = new SendLoveLetter();
		WaitHer waitHer = new WaitHer();
		
		int hp = this.getHP();
		int mp = this.getMP();
		if(move(arena)==null){
			//meet
			if(meet==false){
				action = doAction(this, me,firstMeet,firstMeet.getActionName());
				meet = true;
				((CuteGirl)other).ABoyCome();
				return action;
			}
			if(hp<15 && mp>50){
				this.setHP(1);
				this.setMP(mp-50);
				action = doAction(this, other,sendDiamond,sendDiamond.getActionName());
				return action;
			}
			if(mp>10 && rand>50){
				this.setMP(mp-20);
				action = doAction(this, other,sendChocolate,sendChocolate.getActionName());
				return action;
			}
			
			if(mp>5 && rand>30){
				this.setMP(mp-10);
				action = doAction(this, other,sendLoveLetter,sendLoveLetter.getActionName());
				return action;
			}
			this.setMP(mp+1);
			action = doAction(this, other,waitHer,waitHer.getActionName());
			return action;
			
			
		}else{
				action = doAction(this, me,findGirl,findGirl.getActionName());	
				return action;
		}	
	}
	
	private POOAction doAction(POOPet me, POOPet other, POOSkill skill, String actionName){
		POOAction action = new POOAction();
		action.skill = skill;
		action.dest = other;
		System.out.println(me.getName()+": "+actionName);
		
		return action;
	}
	

}

class FirstMeet extends POOSkill{
	
	public void act(POOPet pet){
		int mp = pet.getMP();
			pet.setMP(mp+10);
	}
	
	public String getActionName(){
		return "Meet a cute girl";
	}
}


class SendDiamond extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		
		if(hp>0)
			if(pet.setHP(hp-50)==false)
				pet.setHP(0);
	}
	
	public String getActionName(){
		return "Give diamond ring";
	}
}

class SendChocolate extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		
		if(hp>0)
			if(pet.setHP(hp-20)==false)
				pet.setHP(0);
	}
	
	public String getActionName(){
		return "Give chocolate";
	}
	
}
class SendLoveLetter extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		
		if(hp>0)
			if(pet.setHP(hp-10)==false)
				pet.setHP(0);
	}
	
	public String getActionName(){
		return "Give love letter";
	}
	
}

class WaitHer extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		
		if(hp>0)
			pet.setHP(hp-1);
	}
	
	public String getActionName(){
		return "Wait for her.";
	}
	
}

class FindGirl extends POOSkill{
	
	public void act(POOPet pet){
		int mp = pet.getMP();
		if(mp>0)
			pet.setMP(mp-1);
	}
	
	public String getActionName(){
		return "Find the girl";
	}
}



