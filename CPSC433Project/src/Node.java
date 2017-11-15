package andTreeSearch;

public class Node {
	
	Slot[] slots = null;
	int size;

	public Node(Input in) { //Root Node
		size = 0;
		int capacity = in.courses.size();
		slots = new Slot[capacity];
		for (int i = 0; i < capacity; i++) {
			slots[i] = null;
		}
		// Adding classes in partial assignment to the root node
		for (int j = 0; j < in.partialAssignments.size(); j++) {
			String classTime = (in.partialAssignments.get(j)).getright();
			Course partAssignCourse = (in.partialAssignments.get(j)).getleft();
			String classType;
			if(partAssignCourse.getLecture() != null) {
				classType = partAssignCourse.getLecture();
			} else {
				classType = partAssignCourse.getTutorial();
			};
			String type = classType.split(",")[0];
			String day = classTime.split(",")[0];
			String time = classTime.split(",")[1];
			int max = slots[in.courses.indexOf(in.partialAssignments.get(j))].getMax();
			int min = slots[in.courses.indexOf(in.partialAssignments.get(j))].getMin();
			String line = day + ", " + time + ", " + max + ", " + min;
			slots[in.courses.indexOf(in.partialAssignments.get(j))] = new Slot(line,type);
		}
	}
	
	public Node(Node parentNode, int depth) {}
	

}
