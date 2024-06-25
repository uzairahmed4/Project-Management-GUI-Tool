/*
 * Student ID: 2940038
 */

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class JengaGUI extends JFrame {
	/**
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class.
	 */
	private static final long serialVersionUID = 1L;

	// instantiate the ArrayList of Project and stores the data from the CSV file
	// by reading the CSV file using the readData method from the CSVReader class
	protected ArrayList<Project> project = CSVReader.readData();

	// the GUI components
	private JPanel contentPane;
	private JTextField projectTypeField, projectManagerField, locationField;
	private JLabel projectTypeLabel, projectManagerLabel, locationLabel, datasetLabel, searchLabel, searchOptionsLabel,
			addOrUpdateLabel;
	private JButton searchProjectTypeButton, searchProjectManagerButton, searchLocationButton, addProjectButton,
			updateProjectButton;
	private JTextArea dataTextArea;
	private JScrollPane tableScrollPane, textAreaScrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JengaGUI frame = new JengaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JengaGUI() {
		setTitle("JengaGUI_ID:2940038");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		projectTypeLabel = new JLabel("Project Type");
		projectTypeLabel.setBounds(10, 340, 120, 30);
		contentPane.add(projectTypeLabel);

		projectTypeField = new JTextField();
		projectTypeField.setBounds(130, 340, 300, 30);
		contentPane.add(projectTypeField);
		projectTypeField.setColumns(10);

		projectManagerLabel = new JLabel("Project Manager");
		projectManagerLabel.setBounds(10, 380, 120, 30);
		contentPane.add(projectManagerLabel);

		projectManagerField = new JTextField();
		projectManagerField.setColumns(10);
		projectManagerField.setBounds(130, 380, 300, 30);
		contentPane.add(projectManagerField);

		locationLabel = new JLabel("Location");
		locationLabel.setBounds(10, 420, 120, 30);
		contentPane.add(locationLabel);

		locationField = new JTextField();
		locationField.setColumns(10);
		locationField.setBounds(130, 420, 300, 30);
		contentPane.add(locationField);

		textAreaScrollPane = new JScrollPane();
		textAreaScrollPane.setBounds(10, 490, 960, 63);
		contentPane.add(textAreaScrollPane);

		dataTextArea = new JTextArea();
		textAreaScrollPane.setViewportView(dataTextArea);
		dataTextArea.setEditable(false);

		datasetLabel = new JLabel("Dataset");
		datasetLabel.setBounds(10, 10, 100, 32);
		contentPane.add(datasetLabel);

		searchLabel = new JLabel("Searched Project Row");
		searchLabel.setBounds(10, 460, 250, 30);
		contentPane.add(searchLabel);

		searchOptionsLabel = new JLabel("Search Options");
		searchOptionsLabel.setBounds(10, 300, 200, 30);
		contentPane.add(searchOptionsLabel);

		addOrUpdateLabel = new JLabel("Add or Update Project");
		addOrUpdateLabel.setBounds(700, 300, 250, 30);
		contentPane.add(addOrUpdateLabel);

		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(10, 37, 960, 260);
		contentPane.add(tableScrollPane);

		table = new JTable();
		tableScrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// sets the Array of columnNames by calling the method columnNamesArray
		final String columnNames[] = columnNamesArray(project);
		// sets the 2D Array of rowData by calling the method rowDataArray
		final String rowData[][] = rowDataArray(project);
		// inputs the values of the rowData and the columnNames into the table
		table.setModel(new DefaultTableModel(rowData, columnNames));

		searchProjectTypeButton = new JButton("Search Project Type");
		searchProjectTypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				// iterates through the column names to find out the column index of the
				// attribute Project type
				for (int i = 0; i < columnNames.length; i++) {
					if (columnNames[i].equalsIgnoreCase("Project type")) {
						index = i;
					}
				}

				// if the text field is empty it pops up a message to enter the Project Type in
				// the text field
				if (projectTypeField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter a Project Type to be searched");
				} else {
					// initializes a string search that gets the value from the Project Type text
					// field
					String search = projectTypeField.getText();

					// clears the text area before displaying any of the searched results
					dataTextArea.setText("");
					// iterates through all the rows inside the project
					for (int j = 0; j < project.size(); j++) {
						// initializes a string check with the column index - index found before and the
						// row index iterating through all the rows in the project
						String check = project.get(j).getRow().get(index);
						// checks if the text field - search and data in the table - check are equal
						if (search.equalsIgnoreCase(check)) {
							// gets the project if the values match
							Project p = project.get(j);
							// appends the project row into the text area
							dataTextArea.append(p.toString() + "\n");
						}
					}
					// clears the Project Type text field
					projectTypeField.setText("");
				}
			}
		});
		searchProjectTypeButton.setBounds(440, 340, 180, 30);
		contentPane.add(searchProjectTypeButton);

		searchProjectManagerButton = new JButton("Search Project Manager");
		searchProjectManagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				// iterates through the column names to find out the column index of the
				// attribute Project Manager
				for (int i = 0; i < columnNames.length; i++) {
					if (columnNames[i].equalsIgnoreCase("Project manager")) {
						index = i;
					}
				}

				// if the text field is empty it pops up a message to enter the Project Manager
				// in
				// the text field
				if (projectManagerField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter a Project Manager to be searched");
				} else {
					String search = projectManagerField.getText();

					// clears the text area before displaying any of the searched results
					dataTextArea.setText("");
					// iterates through all the rows inside the project
					for (int j = 0; j < project.size(); j++) {
						// initializes a string check with the column index - index found before and the
						// row index iterating through all the rows in the project
						String check = project.get(j).getRow().get(index);
						// checks if the text field - search and data in the table - check are equal
						if (search.equalsIgnoreCase(check)) {
							// gets the project if the values match
							Project p = project.get(j);
							// appends the project row into the text area
							dataTextArea.append(p.toString() + "\n");
						}
					}
					// clears the Project Manager text field
					projectManagerField.setText("");
				}
			}
		});
		searchProjectManagerButton.setBounds(440, 380, 180, 30);
		contentPane.add(searchProjectManagerButton);

		searchLocationButton = new JButton("Search Location");
		searchLocationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				// iterates through the column names to find out the column index of the
				// attribute Location
				for (int i = 0; i < columnNames.length; i++) {
					if (columnNames[i].equalsIgnoreCase("Location")) {
						index = i;
					}
				}

				// if the text field is empty it pops up a message to enter the Location in
				// the text field
				if (locationField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter a Location to be searched");
				} else {
					String search = locationField.getText();

					// clears the text area before displaying any of the searched results
					dataTextArea.setText("");
					// iterates through all the rows inside the project
					for (int j = 0; j < project.size(); j++) {
						// initializes a string check with the column index - index found before and the
						// row index iterating through all the rows in the project
						String check = project.get(j).getRow().get(index);
						// checks if the text field - search and data in the table - check are equal
						if (search.equalsIgnoreCase(check)) {
							// gets the project if the values match
							Project p = project.get(j);
							// appends the project row into the text area
							dataTextArea.append(p.toString() + "\n");
						}
					}
					// clears the Project Manager text field
					locationField.setText("");
				}
			}
		});
		searchLocationButton.setBounds(440, 420, 180, 30);
		contentPane.add(searchLocationButton);

		addProjectButton = new JButton("Add Project");
		addProjectButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// initializes an ArrayList of Strings to store the values given by the user to
				// add a project
				ArrayList<String> input = new ArrayList<>();
				for (int i = 0; i < project.get(0).getRow().size(); i++) {
					// takes the values of the attributes from the user to enter it into the
					// ArrayList
					String values = JOptionPane.showInputDialog("Enter the " + columnNames[i] + " :");
					input.add(values);
				}
				// adds the ArrayList of Strings taken by the user into the ArrayList of
				// Project(Object) instantiated at the start
				project.add(new Project(input));
				// gets the rowData again after adding the project entered by the user, using
				// the accessRow method
				String rowData[][] = accessRow(project);
				// sets the rowData and columnNames into the JTable
				table.setModel(new DefaultTableModel(rowData, columnNames));
				JOptionPane.showMessageDialog(null, "The Project has been added");
			}
		});
		addProjectButton.setBounds(700, 340, 180, 30);
		contentPane.add(addProjectButton);

		updateProjectButton = new JButton("Update Project");
		updateProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// selects the row chosen by the user in the table to update it
					int rowUpdate = table.getSelectedRow();
					// initializes an ArrayList of Strings to store the values given by the user to
					// add a project
					ArrayList<String> input = new ArrayList<>();
					for (int i = 0; i < project.size(); i++) {
						// checks the row to be updated
						if (i == rowUpdate) {
							for (int j = 0; j < project.get(0).getRow().size(); j++) {
								// takes the values of the attributes from the user to enter it into the
								// ArrayList
								String values = JOptionPane.showInputDialog("Enter the " + columnNames[j],
										project.get(i).getRow().get(j));
								input.add(values);
							}
						}
					}
					// sets the row given by the user by using the index - rowUpdate and the
					// ArrayList - input from the user
					project.set(rowUpdate, new Project(input));
					// gets the rowData again after updating the project entered by the user, using
					// the accessRow method
					String rowData[][] = accessRow(project);
					// sets the rowData and columnNames into the JTable
					table.setModel(new DefaultTableModel(rowData, columnNames));
					JOptionPane.showMessageDialog(null, "The Project has been updated");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Please select a row to update");
				}
			}
		});
		updateProjectButton.setBounds(700, 380, 180, 30);
		contentPane.add(updateProjectButton);
	}

	/*
	 * takes in the ArrayList of projects as a parameter and returns a 2D Array of
	 * Strings containing the values of the rowData of the CSV file in it
	 * 
	 * @param - projectArray it takes the ArrayList of Project that has stored the
	 * values of the rowData of the CSV file in it
	 * 
	 * @return - rowLine returns the 2D Array of Strings that has the values of the
	 * rowData of CSV file copied to it
	 */
	private String[][] rowDataArray(ArrayList<Project> projectArray) {
		projectArray.remove(0);
		// initializes the Array of Strings - rowLine by giving the length of the row
		// and the column as the dimensions of the 2D array
		String[][] rowLine = new String[projectArray.size()][projectArray.get(0).getRow().size()];
		// iterates through the rows and columns inside the ArrayList of Project
		// containing the values from the CSV file
		for (int i = 0; i < projectArray.size(); i++) {
			for (int j = 0; j < projectArray.get(0).getRow().size(); j++) {
				// sets the values in the 2D Array of Strings
				rowLine[i][j] = projectArray.get(i).getRow().get(j);
			}
		}
		// returns the 2D Array of Strings
		return rowLine;
	}

	/*
	 * takes in the ArrayList of projects as a parameter and returns a Array of
	 * Strings containing the values of the columnNames of the CSV file in it
	 * 
	 * @param - projectArray it takes the ArrayList of Project that has stored the
	 * values of the columnNames of the CSV file in it
	 * 
	 * @return - columnLine returns the Array of Strings that has the values of the
	 * columnNames of CSV file copied to it
	 */
	private String[] columnNamesArray(ArrayList<Project> projectArray) {
		// initializes an Array of Strings - columnLine by giving the length of the
		// column as the size
		String[] columnLine = new String[projectArray.get(0).getRow().size()];
		// iterates through the column headers inside the ArrayList of Project
		for (int i = 0; i < projectArray.get(0).getRow().size(); i++) {
			// sets the values in the Array of Strings
			columnLine[i] = projectArray.get(0).getRow().get(i);
		}
		// returns the Array of Strings
		return columnLine;
	}

	/*
	 * takes in the ArrayList of projects as a parameter and returns a 2D Array of
	 * Strings containing the values of the rowData of the CSV file in it. It only
	 * returns the selected rowLine and not the whole rowData from the CSV file
	 * 
	 * @param - projectArray it takes the ArrayList of Project that has stored the
	 * values of selected rowLine of the CSV file in it
	 * 
	 * @return - rowLine returns the 2D Array of Strings that has the values of the
	 * selected rowData of CSV file copied to it
	 */
	private String[][] accessRow(ArrayList<Project> projectArray) {
		// initializes the Array of Strings - rowLine by giving the length of the row
		// and the column as the dimensions of the 2D array
		String[][] rowLine = new String[projectArray.size()][projectArray.get(0).getRow().size()];
		// iterates through the rows and columns inside the ArrayList of Project
		// containing the values from the CSV file
		for (int i = 0; i < project.size(); i++) {
			for (int j = 0; j < projectArray.get(0).getRow().size(); j++) {
				// sets the values in the 2D Array of Strings
				rowLine[i][j] = projectArray.get(i).getRow().get(j);
			}
		}
		// returns the 2D Array of Strings
		return rowLine;
	}

}
