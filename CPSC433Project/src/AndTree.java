package andTreeSearch;

public class AndTree {
	
	int depth;
	
	public AndTree(Input in) {
		Node rootNode = new Node(in);
	}
	public AndTree(Node parentNode, AndTree t) {
		Node node = new Node(parentNode, t.depth);
	}
	
	public int getDepth() {
		return depth;
	}
}
