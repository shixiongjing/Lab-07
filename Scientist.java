public class Scientist{
	public int[] location;
	
	public Scientist(){
		location=new int[6];
	}
	
	public int move(int dim, int unit, World world){
		location[dim-1]+=unit;
		location=world.wrap(location);
		location[5]=world.getcolor(location);
		return location[5];
	}

}