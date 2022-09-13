package ExcelMapping.Utils;

public class Gradeassignment {

	public String assigngrades(int mark)
	{   
		String result = "";
		try
		{ 
			if(mark<=100 && mark>=91){
				result = "A1";
			}
			else if(mark<=91&& mark>=81){
				result = "A2";
			}
			else if( mark<=81&&mark>=71){
				result = "B1";
			}
			else if(mark<=71&& mark>=61){
				result = "B2";
			}
			else if( mark<=61&&mark>=51){
				result = "C1";
			}
			else if(mark<=51&&mark>=41){
				result = "C2";
			}
			else if( mark<=41&& mark>=31){
				result = "D";
			}
			else if(mark<=31&& mark>=21){
				result = "E1";
			}
			else{
				result = "E2";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}

	public String assignGradePoints (int mark)
	{
		String result = "";
		try{ 
			if(mark<=100 && mark>=91){
				result  = "10";
			}
			else if(mark<=91&& mark>=81){
				result ="9";
			}
			else if( mark<=81&&mark>=71){
				result = "8";
			}
			else if(mark<=71&& mark>=61){
				result = "7";
			}
			else if( mark<=61&&mark>=51){
				result = "6";
			}
			else if(mark<=51&&mark>=41){
				result = "5";
			}
			else if( mark<=41&& mark>=31){
				result = "4";
			}
			else if(mark<=31&& mark>=21){
				result = "C";
			}
			else{
				result = "C";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return  result ;
	}
}




