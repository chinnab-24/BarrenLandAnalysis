package code;

/**
 * This is the class that contains the main method that calls the service class. 
 * An object of the service class is created and its methods are called to perform the corresponding functions
 */
public class BarrenLandAnalysis {

	public static void main(String[] args){
		BarrenLandService land = new BarrenLandService();

		try{
			land.readInput();
			land.clearLand();
			land.markBarrenLandInspected();
			land.getFertileLands();
			String output = land.returnOutput();

			System.out.println("The output is : "+output);
		}
		catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("Error Occured : Please check the values of the coordinates.");
		}
		catch (Exception e)
		{
			System.out.println("Error Occured : "+e.getMessage());
		}

	}

}
