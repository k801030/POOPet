package ntu.csie.oop13spring;


public class PetWind extends POOPet{
    private static int totalNum = 1;
	public PetWind(){
		if(totalNum==1)
			setName("Wind");
		else
			setName("Wind"+totalNum);
		setAGI(3);
		setHP(100);
		setMP(50);
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
