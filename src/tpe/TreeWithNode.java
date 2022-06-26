package src.tpe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TreeWithNode {

	private TreeNode root;

	public TreeWithNode() {
		this.root = null;
	}

	public void add(String genero) {
		if (this.root == null)
			this.root = new TreeNode(genero);
		else
			this.add(this.root, genero);
	}


	private void add(TreeNode actual, String genero) {
		if (actual.getGenero().compareTo(genero) > 0) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(genero);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),genero);
			}
		} else if (actual.getGenero().compareTo(genero) < 0) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(genero);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), genero);
			}
		}
	}

	public void agregarLibro(String genero, Libro l) {
		if (this.root != null) {
			this.agregarLibro(this.root, genero, l);
		}
	}

	private void agregarLibro(TreeNode n, String genero, Libro l) {
		if (n.getGenero().compareTo(genero) == 0) {
			n.addLibro(l);
		} else {
			if ((n.getGenero().compareTo(genero) > 0) && (n.getLeft() != null)){
				agregarLibro(n.getLeft(), genero, l);
			}
			if ((n.getGenero().compareTo(genero) < 0) && (n.getRight() != null)){
				agregarLibro(n.getRight(), genero, l);
			}
		}
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
		System.out.print(n.getGenero()) ;
		if (n.getRight() != null ) {
			printInOrder(n.getRight());
		} else {
			System.out.print("- ");
		}
	}


	public List<Libro> getLibrosGenero(String genero) {
		if (this.root != null) {
			List<Libro> listaLibros = new LinkedList<Libro>();
			listaLibros.addAll(getListaLibros(this.root, genero));
			return listaLibros;
		}
		return null;
	}

	public List<Libro> getListaLibros(TreeNode n, String genero) {
		List<Libro> aux = new LinkedList<Libro>();
		if (n.getGenero().compareTo(genero) == 0) {
			aux.addAll(n.getLibros()) ;
		} else {
			if ((n.getGenero().compareTo(genero) > 0) && (n.getLeft() != null)){
				aux.addAll(getListaLibros(n.getLeft(), genero)) ;
			}
			if ((n.getGenero().compareTo(genero) < 0) && (n.getRight() != null)){
				aux.addAll(getListaLibros(n.getRight(), genero));
			}
		}
		return aux ;
	}
	
	public int getAltura() {
		if (this.root != null) {
			return getAltura(this.root) ;
		} else {
			return 0;
		}
	}
		
	private int getAltura(TreeNode n) {
		if ((n.getLeft() == null) && (n.getRight() == null)) {
			return 0;
		}
		int der = 0;
		int izq = 0;
		if (n.getLeft() != null) {
			izq = getAltura(n.getLeft()) + 1 ;
		}
		if (n.getRight() != null) {
			der = getAltura(n.getRight()) + 1 ;
		}
		return Math.max(izq, der) ;
	}
	
	public int getCantNodos() {
		if (this.root != null) {
			return getCantNodos(this.root) ;
		} else {
			return 0;
		}
	}
	private int getCantNodos(TreeNode n) {
		if ( n== null ) {
			return 0;
		}
			int izq = 0 ;
			int der = 0 ;
			if (n.getLeft() != null) {
				izq += getCantNodos(n.getLeft())  ;
			}
			if (n.getRight() != null) {
				der += getCantNodos(n.getRight()) ;
			}
			return izq + der + 1;
		}
	
	public void printAltura() {
		if (this.root != null) {
			System.out.println("Altura del �rbol: " + this.getAltura()); ;
		}
	}
	
	public void printCantNodos() {
		if (this.root != null) {
			System.out.println("Cantidad de nodos del �ndice: " + this.getCantNodos()); 
		}
	}
}
