package ntu.csie.oop13spring;


public class MyPet1 extends POOPet{
    private int HP, MP, AGI;
    private String name;
    private int totalNum = 0;
	public MyPet1(){
		totalNum++;
		setName("Water"+totalNum);
		setAGI(AGI);
		setHP(HP);
		setMP(MP);
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
