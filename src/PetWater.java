package ntu.csie.oop13spring;


public class PetWater extends POOPet{
    private static int totalNum = 1;
    private Coordinate c = new Coordinate();
    public PetWater(){
		if(totalNum==1)
			setName("Water");
		else
			setName("Water"+totalNum);
		setAGI(2);
		setHP(90);
		setMP(100);
		
		totalNum++;
		//System.out.println("success to load  MyPet1");
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
