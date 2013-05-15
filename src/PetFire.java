package ntu.csie.oop13spring;


public class PetFire extends POOPet{
    private int HP, MP, AGI;
    private String name;
    private static int totalNum = 1;
	public PetFire(){
		if(totalNum==1)
			setName("Fire");
		else
			setName("Fire"+totalNum);
		setAGI(AGI);
		setHP(HP);
		setMP(MP);
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
}
