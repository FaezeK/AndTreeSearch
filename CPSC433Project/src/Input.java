import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
	public String path;
	public String line;
	
	public String name;
	public ArrayList<Slot> slots = new ArrayList<Slot>();
	public ArrayList<Course> courses = new ArrayList<Course>();
	public ArrayList<Pair<Course, Course>> notCompatible = new ArrayList<Pair<Course, Course>>();
	public ArrayList<Pair<Course, String>> unwanted = new ArrayList<Pair<Course, String>>();
	public ArrayList<Pair<Pair<String, Course>, Integer>> preferences = new ArrayList<Pair<Pair<String, Course>, Integer>>();
	public ArrayList<Pair<Course, Course>> pair = new ArrayList<Pair<Course, Course>>();
	public ArrayList<Pair<Course, String>> partialAssignments = new ArrayList<Pair<Course, String>>();
	
	public Input(String path) {
		this.path = path;
	}
		
	public void Parse() {
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String section = null;
			String[] parts;
			line = bufferedReader.readLine();
			while(line != null) {
				if(line.length() != 0 && line.charAt(line.length() - 1) == ':') {
					section = line;
				} else if (line.trim().length() == 0) { //Check if line is whitespace
					section = null;
				} else {
					switch (section) {
					case "Name:":
						name = line;
						break;
					case "Course slots:": case "Lab slots:":
						slots.add(new Slot(line, section));
						System.out.println(section+line);
						break;
					case "Courses:": case "Labs:":
						courses.add(new Course(line));
						System.out.println(section+line);
						break;
					case "Not compatible:":
						parts = line.split(",");
						notCompatible.add(new Pair<Course, Course>(new Course(parts[0]), new Course(parts[1])));
						System.out.println(section+line);
						break;
					case "Unwanted:":
						parts = line.split(",", 2);
						unwanted.add(new Pair<Course, String>(new Course(parts[0]), parts[1]));	//TODO setup the correct slot instead of string
						System.out.println(section+line);
						break;
					case "Preferences:":
						//TODO Preferences with invalid slots can be ignored, can invalid classes be handled the same way?
						parts = line.split(",");
						preferences.add(new Pair<Pair<String, Course>, Integer>(new Pair<String, Course>(parts[0]+", "+parts[1].trim(), new Course(parts[2])), Integer.parseInt(parts[3].trim())));
						System.out.println(section+line);
						break;
					case "Pair:":
						parts = line.split(",");
						pair.add(new Pair<Course, Course>(new Course(parts[0]), new Course(parts[1])));
						System.out.println(section+line);
						break;
					case "Partial assignments:":
						//TODO Partial assignments that are invalid result in an error message and exit.
						parts = line.split(",", 2);
						
//						Course temp = new Course(parts[0]);
//						System.out.print(temp.equals(courses.get(2)));
//						courses.add(temp);
//						System.out.print(courses.indexOf(temp));
//						System.out.println((temp==null ? courses.get(2)==null : temp.equals(courses.get(2))));
//						System.out.println(courses.contains(temp));
//						System.out.print(courses.indexOf(temp));
//						System.out.println(temp);
//						System.out.println(courses.get(2));
						
						partialAssignments.add(new Pair<Course, String>(new Course(parts[0]), parts[1])); //TODO setup the correct slot instead of string
						System.out.println(section+line);
						break;
					}
				}
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}
