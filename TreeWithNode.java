package arboles;

import java.util.ArrayList;
import java.util.List;


public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	//Integer getRoot() 
	private Integer getRoot() {
		if (this.root != null) {
			return this.root.getValue();
		} else {
			return null ;
		}
	}
	
	//boolean hasElem(Integer)
	/**
	 * Complejidad: O(h) h= altura del arbol (porque se puede decidir ir a der o izq)
	 * @param n
	 * @param busco
	 * @return
	 */
	
	public boolean hasElem(TreeNode n, Integer busco) {
		if (n.getValue() == busco) {
			return true ;
		} else {
			if ((n.getValue() > busco) && (n.getLeft() != null)){
				return hasElem(n.getLeft(), busco);
			}
			if ((n.getValue() < busco) && (n.getRight() != null)){
				return hasElem(n.getRight(), busco);
			}
		}
		return false ;
	}
	
	//boolean isEmpty() 
	public boolean isEmpty() {
		return this.root == null ;
	}
	
	//int getHeight()
	public int getHeight(TreeNode n) {
		if ((n.getLeft() == null) && (n.getRight() == null)) {
			return 0;
		}
		int der = 0;
		int izq = 0;
		if (n.getLeft() != null) {
			izq = getHeight(n.getLeft()) + 1 ;
		}
		if (n.getRight() != null) {
			der = getHeight(n.getRight()) + 1 ;
		}
		return Math.max(izq, der) ;
	}
	
	//void printPosOrder()
	public void printPosOrder() {
		if (this.root != null) {
			printPosOrder(this.root) ;
		}
	}
	private void printPosOrder(TreeNode n) {
		if (n.getLeft() != null) printPosOrder(n.getLeft());
		if (n.getRight() != null ) printPosOrder(n.getRight());
		System.out.println(n.getValue()) ;
	}
	
	//void printPreOrder()
	public void printPreOrder() {
		if (this.root != null) {
			printPreOrder(this.root) ;
		}
	}
	private void printPreOrder(TreeNode n) {
		System.out.print(n.getValue() + " ") ;
		if (n.getLeft() != null) printPreOrder(n.getLeft());
		else System.out.print("- ");
		if (n.getRight() != null ) printPreOrder(n.getRight());
		else System.out.print("- ");
	}
		
	//void printInOrder()
	public void printInOrder() {
		if (this.root != null) {
			printInOrder(this.root) ;
		}
	}
	/**
	 * Imprime el arbol en orden
	 * Complejidad: O(n) porque si o si lo recorro todo
	 * @param n
	 */
	private void printInOrder(TreeNode n) {
		if (n.getLeft() != null) { 
			printInOrder(n.getLeft());
		}
		else { 
			System.out.print("- ");; 
		}
			System.out.print(n.getValue()) ;
		if (n.getRight() != null ) {
			printInOrder(n.getRight());
		} else { 
			System.out.print("- ");; 
		}
	}

	//List getLongestBranch()
	public List <Integer> getLongestBranch() {
		List<Integer> lis = new ArrayList<Integer>();
		if (this.root != null) {
			lis.addAll(getLongestBranch(this.root));
		}
		return lis;
	}
	
	private List <Integer> getLongestBranch(TreeNode n){
		List<Integer> izq = new ArrayList<Integer>();
		List<Integer> der = new ArrayList<Integer>();
		if ((n.getLeft() == null) && (n.getRight() == null)) {
			izq.add(n.getValue());
			return izq ;
		}
		if (n.getLeft() != null) {
			izq.add(n.getValue());
			izq.addAll(getLongestBranch(n.getLeft()));
		}
		if (n.getRight() != null) {
			der.add(n.getValue());
			der.addAll(getLongestBranch(n.getRight()));
		}
		if (izq.size() >= der.size()) {
			return izq ;
		} else {
			return der ;
		}
	}
	
	// List getFrontera()
	public List <Integer> getFrontera() {
		List<Integer> lis = new ArrayList<Integer>();
		if (this.root == null) {
			
		}else {
			lis.addAll(getFrontera(this.root));
		}
		return lis;
	}
	private List <Integer> getFrontera(TreeNode n) {
		List<Integer> izq = new ArrayList<Integer>();
		List<Integer> der = new ArrayList<Integer>();
		
		if ((n.getLeft() == null) && (n.getRight() == null)) {
			izq.add(n.getValue());
		}
		if (n.getLeft() != null) {
			izq.addAll(getFrontera(n.getLeft())) ; 
		}
		if (n.getRight() != null) {
			der.addAll(getFrontera(n.getRight())) ; 
		}
		izq.addAll(der) ;
		return izq ;
	}
	
	//Integer getMaxElem()
	public Integer getMaxElem(TreeNode n) {
		if (n.getRight() == null) {
			return n.getValue() ;
		} else {
			return getMaxElem(n.getRight()) ;
		}
	}
	//Integer getMinElem()
		public Integer getMinElem(TreeNode n) {
			if (n.getLeft() == null) {
				return n.getValue() ;
			} else {
				return getMinElem(n.getLeft()) ;
			}
		}
	
	//getElemAtLEvel
	public List <Integer> elemAtLevel(int level) {
		List<Integer> lis = new ArrayList<Integer>();
		if (this.root == null) {
			
		}else {
			lis.addAll(getElemAtLevel(this.root, level));
		}
		return lis;
	}
	
	private List <Integer> getElemAtLevel(TreeNode n, int level) {
		List<Integer> lis = new ArrayList<Integer>();
		if (level == 0 ) {
			lis.add(n.getValue());
		}
		if (n.getLeft()!= null) {
			lis.addAll(getElemAtLevel(n.getLeft(), level-1)); 
		}
		if (n.getRight()!= null) {
			lis.addAll(getElemAtLevel(n.getRight(), level-1)); 
		}
		return lis;
	}
	
	private boolean esHoja(TreeNode n) {
		return ((n.getLeft() == null) && (n.getRight() == null)) ;
	}
	
	public boolean delete(Integer valor) {
		if (this.root == null) {
			return false ;
		}else {
			if (this.getRoot() == valor) {
				if (esHoja(this.root)) {
					this.root = null;
					return true ;
				}
				return deleteNoEsHoja(this.root) ;
			} else {
				return delete(this.root, valor);
			}
		}
	}
	//boolean delete(Integer)
	private boolean delete(TreeNode n, Integer valor) {
	
		if (n.getValue() > valor) { //voy a izquierda
			if (n.getLeft() != null) {
				if (n.getLeft().getValue().equals(valor)) { //este hay que borrar
					if (esHoja(n.getLeft())) {
						n.setLeft(null);
						return true ;
					}else { //si no es hoja
						return deleteNoEsHoja(n.getLeft()) ;
					}
				} else {
					return delete(n.getLeft(), valor) ;
				}
			} else {
				return false ; // no hay nada a la izquierda
			}
			
		}//voy a izquierda
		else {
			 //voy a derecha
				if (n.getRight() != null) {
					if (n.getRight().getValue().equals(valor)) { //este hay que borrar
						if (esHoja(n.getRight())) {
							n.setRight(null);
							return true ;
						}else { //si no es hoja
							return deleteNoEsHoja(n.getRight()) ;
						}
					}else {
						return delete(n.getRight(), valor) ;
					}
				}else {
					return false ; // no hay nada a la derecha
				}
			}//voy a derecha
		}
	
	private boolean deleteNoEsHoja(TreeNode nodo) {
		if (nodo.getLeft() != null) { //busco máximo x izquierda
			Integer maxIzq = getMaxElem(nodo.getLeft()) ;
			delete(nodo, maxIzq) ;
			nodo.setValue(maxIzq);
			return true ;
		} else {
			if (nodo.getRight() != null) { //busco mínimo x derecha
				Integer minDer = getMinElem(nodo.getRight()) ;
				delete(nodo, minDer) ;
				nodo.setValue(minDer) ;
				return true ;
			}else {
				return false ;  
			}
		} 
	} 
	
}
