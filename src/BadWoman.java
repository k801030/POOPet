package ntu.csie.oop13spring;


public class BadWoman extends POOPet{
    public BadWoman(){
			setName("BadWoman");
		setAGI(2);
		setHP(90);
		setMP(100);

	}
    
	@Override
	protected POOAction act(POOArena arena) {
		POOAction action = new POOAction();
		POOSkill my = new POOTinyAttackSkill();
		action.skill = my;
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected POOCoordinate move(POOArena arena) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
