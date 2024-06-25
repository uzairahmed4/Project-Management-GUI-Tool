/*
 * Student ID: 2940038
 */

import java.util.ArrayList;

/*
 *  Project class to make an Object of Projects from the CSV file 
 *  It takes the rows of the CSV file as an object
 *  Project class is a child class of CSVReader class
 */
public class Project extends CSVReader {
	// initializing an ArrayList of Strings - row
	protected ArrayList<String> row = new ArrayList<>();

	/*
	 * @param - row an ArrayList of Strings and enters the rows into the ArrayList
	 * of Project(Object)
	 */
	public Project(ArrayList<String> row) {
		this.row = row;
	}

	/*
	 * The getter method to get the row of the ArrayList of Strings
	 * 
	 * @returns - row an ArrayList of Strings that contain the row inside the CSV
	 * file
	 */
	public ArrayList<String> getRow() {
		return row;
	}

	/*
	 * The setter method to set the row of the ArrayList of Strings
	 * 
	 * @param - row to set the row of the ArrayList of Strings
	 */
	public void setRow(ArrayList<String> row) {
		this.row = row;
	}

	/*
	 * The toString method to return a Project(Object) as a string
	 */
	@Override
	public String toString() {
		return "Project: " + row;
	}

}