public class TreeNode {

	private String genero;
	private TreeNode left;
	private TreeNode right;
	private List<Libro> libros ;

	public TreeNode(String genero) {
		this.genero = genero;
		this.left = null;
		this.right = null;
		this.libros = new LinkedList() ;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	
}
