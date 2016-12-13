package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * This is the service class where the functionality is implemented. 
 * Input is read from the console, fertile lands and their areas are calculated and printed to console as output
 */
public class BarrenLandService{

	// list of barren lands from input
	LinkedList<Integer[]> barrenLands; 
	// list of points to be inspected
	LinkedList<Integer[]> pointsToBeInspected;
	// Fertile lands
	HashMap<Integer, Integer> fertileAreaMap;
	boolean isInspected[][];
	final static int XLIMIT = 400;
	final static int YLIMIT = 600;

	// This method is for reading the input from the console
	public void readInput() throws Exception{
		System.out.println("Please enter your input below.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		parseInput(input);
	}

	// This method is to parse the input and find out the coordinates corresponding to the given input string
	public void parseInput(String input) throws Exception{	

		String[] parts = input.split(",");
		for(String s:parts){
			s = s.replace("\"", "");
			s = s.replaceAll("“|”", "");
			s = s.replaceAll("\\{|\\}", "");
			s = s.replaceAll("^ ", "");

			if(!s.isEmpty()){
				String[] coord = s.split(" ");

				try{
					Integer[] temp = {Integer.parseInt(coord[0]), Integer.parseInt(coord[1]), 
							Integer.parseInt(coord[2]), Integer.parseInt(coord[3])};
					barrenLands.add(temp);
				}
				catch(Exception e)
				{
					throw new Exception("Invalid Input. Please enter your input as {\"x1 y1 a1 b1\",\"x2 y2 a2 b2\"}, where x y a b are integers and correspond to coordinate values");
				}

			}
		}
	}

	// Set all points as false (not inspected)
	public void clearLand() {
		for(int i = 0; i < XLIMIT; i++)
			for(int j = 0; j < YLIMIT; j++)
				isInspected[i][j] = false;
	}

	// Set all points inside a barren rectangle as inspected
	public void markBarrenLandInspected(){
		ListIterator<Integer[]> iterator = barrenLands.listIterator();		
		while(iterator.hasNext()){

			Integer[] rectangle = iterator.next();

			for(int i = rectangle[0]; i <= rectangle[2]; i++)
				for(int j = rectangle[1]; j <= rectangle[3]; j++)
					isInspected[i][j] = true;							
		}
	}

	// Traverse through the land and add all the connected unmarked points to get fertile land area. 
	// Once the queue is empty, check for a new fertile land if any and repeat the area calculation
	public void getFertileLands(){
		int fertLandCount = 1;
		int i = 0;
		int j = 0;

		while(i < XLIMIT && j < YLIMIT){

			if(pointsToBeInspected.isEmpty()) {
				Integer point[] = {i, j};

				// If node[i][j] has not been visited add to queue
				// As the queue was empty, this is a new fertile land
				if(!isInspected[i][j]) {		  
					fertLandCount++;
					fertileAreaMap.put(fertLandCount, 0);
					pointsToBeInspected.add(point);
				}
				// To ensure all the land is inspected
				if(i == (XLIMIT-1)){
					i = 0;
					j++;
				}
				else 
					i++;
			}

			if(!pointsToBeInspected.isEmpty()) {
				Integer point[] = pointsToBeInspected.pop();

				int x = point[0];
				int y = point[1];

				// If node[i][j] has not been visited add to queue the surrounding points
				if(!isInspected[x][y]){
					if(x > 0)
						addNeighbourPointsToInspect(x-1, y);
					if(x < (XLIMIT - 1))
						addNeighbourPointsToInspect(x+1, y);
					if(y > 0) 
						addNeighbourPointsToInspect(x, y-1);
					if(y < (YLIMIT - 1))
						addNeighbourPointsToInspect(x, y+1);

					isInspected[x][y] = true;
					fertileAreaMap.put(fertLandCount, (fertileAreaMap.get(fertLandCount) + 1));
				}
			}
		}

	}

	// Add node to the queue to be be inspected
	public void addNeighbourPointsToInspect(int i, int j){
		if(!isInspected[i][j]){	
			pointsToBeInspected.add(new Integer[] {i, j});
		}
	}

	// To return output (sorted list of fertile land areas) in string format with space as delimiter
	public String returnOutput(){
		int[] result = new int[fertileAreaMap.values().size()];
		int i = 0;	

		for (Map.Entry<Integer, Integer> entry : fertileAreaMap.entrySet()){
			result[i] = entry.getValue();
			i++;
		}

		Arrays.sort(result);		
		return (Arrays.toString(result)).replaceAll("\\[|\\]|,", "");

	}

	public BarrenLandService(){
		barrenLands = new LinkedList<Integer[]>();
		pointsToBeInspected = new LinkedList<Integer []>();
		fertileAreaMap = new HashMap<Integer, Integer>();
		isInspected = new boolean[XLIMIT][YLIMIT];	
	}

}