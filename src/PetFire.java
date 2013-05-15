package ntu.csie.oop13spring;


public class PetFire extends POOPet{
    private static int totalNum = 1;
	public PetFire(){
		if(totalNum==1)
			setName("Fire");
		else
			setName("Fire"+totalNum);
		setAGI(3);
		setHP(100);
		setMP(80);
		totalNum++;
		
	}
	
	@Override
	protected POOAction act(POOArena arena){
		return null;
	}

    
	@Override
    protected POOCoordinate move(POOArena arena){
		return null;
    	
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
