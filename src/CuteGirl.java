package ntu.csie.oop13spring;


public class CuteGirl extends POOPet{
	private POOPet me ;
	private POOPet other ;
	private boolean meet = false;
	public CuteGirl(){
			setName("CuteGirl");
		setAGI(2);
		setHP(50);
		setMP(50);

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
		int rand;
		while(agi>0){
			distance = Math.abs(posi[0].getX()-posi[1].getX())+Math.abs(posi[0].getY()-posi[1].getY());
			// distance=1 means starting fight
			
			if(distance==1){
				return null; 
			}
			rand = (int)(Math.random()*4);
			if(rand==1){
				posi[1].setX(posi[1].getX()+1);
			}else if(rand==2){
				posi[1].setX(posi[1].getX()-1);
			}else if(rand==3){
				posi[1].setY(posi[1].getY()+1);
			}else{
				posi[1].setY(posi[1].getY()-1);
			}


			
			agi--;
		}
		
		
		return posi[1];
    }
	
	@Override
	protected POOAction act(POOArena arena){
		int rand = (int) (Math.random()*100);
		POOPet[] pets = new POOPet[2];

		ArenaLand arenaLand = (ArenaLand)arena;
		pets = arenaLand.getAllPets2();
		other = pets[0];
		me = pets[1];
		
		POOAction action = new POOAction();
		//skill
		
		WalkAround walkAround = new WalkAround();
		NotCool notCool = new NotCool();
		NotHandSome notHandSome = new NotHandSome();
		MomDisagree momDisagree = new MomDisagree();
		DoNotNotice doNotNotice = new DoNotNotice();
		HaveBoyFriend haveBoyFriend = new HaveBoyFriend();
		int mp = this.getMP();
		int hp = this.getHP();
		if(move(arena)==null && meet==true){
			//meet
			
			if(mp>7 && rand>30){
				this.setMP(mp-10);
				action = doAction(this, other,notCool,notCool.getActionName());
				return action;
			}
			if(mp>10 && rand>65){
				this.setMP(mp-20);
				action = doAction(this, other,notHandSome,notHandSome.getActionName());
				return action;
			}
			if(mp>50 && hp <20){
				this.setMP(mp-50);
				action = doAction(this, me,momDisagree,momDisagree.getActionName());
				return action;
			}
			if(rand>95){
				action = doAction(this, other,haveBoyFriend,haveBoyFriend.getActionName());
				return action;
			}
				
			this.setMP(mp+10);
			action = doAction(this, other,doNotNotice,doNotNotice.getActionName());
			return action;
			
		}else{
				action = doAction(this, me,walkAround,walkAround.getActionName());
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
	
	public void ABoyCome(){
		meet = true;
	}
	
}

class WalkAround extends POOSkill{
	
	public void act(POOPet pet){
		int mp = pet.getMP();
		int hp = pet.getHP();
		if(mp>0)
			pet.setMP(mp-1);
		if(hp>0)
			pet.setHP(hp+1);
	}
	
	public String getActionName(){
		return "Walk around";
	}
}

class NotCool extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		if(hp>0)
			if(pet.setHP(hp-10)==false)
				pet.setHP(0);
	}
	
	public String getActionName(){
		return "Tell him the wrong phone number";
	}
}

class NotHandSome extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		if(hp>0)
			if(pet.setHP(hp-20)==false)
				pet.setHP(0);
	}
	
	public String getActionName(){
		return "Laugh at him";
	}
}

class MomDisagree extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
			pet.setHP(hp+50);
	}
	
	public String getActionName(){
		return "Ask mom for help";
	}
}

class HaveBoyFriend extends POOSkill{
	
	public void act(POOPet pet){
			pet.setHP(0);
	}
	
	public String getActionName(){
		return "Make other boy friend";
	}
}

class DoNotNotice extends POOSkill{
	
	public void act(POOPet pet){
		int hp = pet.getHP();
		pet.setHP(hp-1);
	}
	
	public String getActionName(){
		return "Do not notice him";
	}
}
