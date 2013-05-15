package ntu.csie.oop13spring;


public class PetWind extends POOPet{
    private int HP, MP, AGI;
    private String name;
    private static int totalNum = 1;
	public PetWind(){
		if(totalNum==1)
			setName("Wind");
		else
			setName("Wind"+totalNum);
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
