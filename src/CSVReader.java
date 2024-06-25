/*
 * Student ID: 2940038
 */

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The CSVReader class reads the CSV file and then stores it into an ArrayList
 * of Project(Object) The CSV file contains a list of Projects for the architect
 * firm Jenga Design Ltd. The CSVReader class is a super class of the Project
 * class
 */
public class CSVReader {
	// initializing an ArrayList of Project to store the values from the CSV file in
	// it
	protected static ArrayList<Project> data = new ArrayList<>();

	// initializing the path variable which stores the path of the CSV file in it
	private static String path;
	private static String line;
	private static String[] split;

	public static void main(String[] args) {
		readData(); // calls the readData() method
	}

	/*
	 * Kindly set the path variable with the path of the CSV file to read it
	 * readData - It reads the data from the CSV file using the path given to it and
	 * then stores the values inside an ArrayList of strings and then adds it into
	 * an ArrayList of Project(Object) and returns the 2D array.
	 * 
	 * @returns data - ArrayList<Project> returns the ArrayList which contains the
	 * data from the CSV file
	 */
	public static ArrayList<Project> readData() {
		// set the path of the CSV file in the given string path below
		// stores the path of the file in a string
		path = "jenga_projects.csv";

		line = ""; // stores an empty string
		// try catch block to catch any exceptions while parsing the CSV file
		try {
			// parsing a CSV file into BufferedReader class constructor
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				// checks if the CSV file is empty or not
				while ((line = br.readLine()) != null) {
					split = line.split(",", -1); // use comma as separator
					// initializes an ArrayList of Strings to store the values from the splitted
					// array of Strings
					ArrayList<String> separatedStringValues = new ArrayList<>();
					for (String cell : split) {
						// adds the separated string values into the ArrayList separatedStringValues
						separatedStringValues.add(cell);
					}
					// adds the data stored in the ArrayList of strings into the ArrayList of
					// Project(Object)
					data.add(new Project(separatedStringValues));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// returns the ArrayList of Project(Object) - data
		return data;
	}
}
