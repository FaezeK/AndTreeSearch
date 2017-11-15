package andTreeSearch;

public class Slot {
	
	String type;
	String day;
	String time;
	int max;
	int min;
	
	public Slot(String line, String type) {
		line = line.replaceAll(" +", "");		//Remove erroneous whitespace
		String[] parts = line.split(",");
		this.type = type;
		this.day = parts[0];
		this.time = parts[1];
		this.max = Integer.parseInt(parts[2]);
		this.min = Integer.parseInt(parts[3]);
	}

	public String getType(){
		return type;
	}
	public String getDay(){
		return day;
	}
	public String getTime(){
		return time;
	}
	public int getMin(){
		return min;
	}
	public int getMax(){
		return max;
	}

}
