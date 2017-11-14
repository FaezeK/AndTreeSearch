
public class Course {
	private String department;
	private int courseNum;
	private String lecture;
	private String tutorial;
	
	public Course(String line) {
		line = line.trim().replaceAll(" +", " ");
		String[] parts = line.split(" ");
		this.department = parts[0];
		this.courseNum = Integer.parseInt(parts[1]);
		if (parts[2].equals("LEC")) {
			this.lecture = parts[2]+" "+parts[3];
			if (parts.length == 6) {
				this.tutorial = parts[4]+" "+parts[5];
			}
		} else {
			this.tutorial = parts[2]+" "+parts[3];
		}
	}
	
	//TODO Getters
}
